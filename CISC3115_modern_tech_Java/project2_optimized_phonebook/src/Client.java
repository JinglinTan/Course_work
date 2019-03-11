import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Jinglin
public class Client {
    private static ArrayList<Person> addressBook = new ArrayList<Person>();
    private static Person selectedMember;

    public static void main(String[] args) {
        try(Scanner scLoad = new Scanner(new File("saveFile.txt"))) {
        SaveAndLoadFile.loadFile(scLoad, addressBook);
        } catch(IOException e) {
//            System.out.println(e.getMessage());
            System.out.println("Error: - loadFile file might not exist(This is normal for first-time launching)");
        }
        Scanner sc = new Scanner(System.in);
        int redo = 1;
        while(redo != 0) {
            redo = Switch.mainMenuOptions(sc);
            if(redo == 0) break;
            if(selectedMember instanceof Student) Switch.studentFunction(sc);
            else if(selectedMember instanceof Mentor) Switch.mentorFunction(sc);
            selectedMember = null;
            System.out.println();
        }
        try(PrintWriter pw = new PrintWriter(new File("saveFile.txt"))) {
           SaveAndLoadFile.saveFile(pw, addressBook);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program closed");
    }

    //getter

    public static ArrayList<Person> getAddressBook() { return addressBook; }

    public static Person getSelectedMember() {
        return selectedMember;
    }

    //general method
    public static int handleInvalidNumberInput(Scanner sc, int max) {
        int i = 0;
        int redo = 1;
        while(redo != 0) {
            try {
                i = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter number 0-" + max);
                sc.next();
                continue;
            }
            if (i < 0 || i > max) {
                System.out.println("Please enter number 0-" + max);
                continue;
            }
            redo = 0;
        }
        return i;
    }

    //general method
    public static boolean printArrayList(Scanner sc, ArrayList list) {
        if(list == null || list.isEmpty()) {
            System.out.println("No result found");
            return false;
        }
        for(int i = 0; i < list.size(); i++) System.out.println((i + 1) + ": " + list.get(i));
        return true;
    }

    //general method
    public static void selectFromList(Scanner sc, ArrayList list) {
        if(list != null && !list.isEmpty()) System.out.println("0: Back");
        if(printArrayList(sc, list)) {
            System.out.println("Please select a member to edit/add:");
            int select = handleInvalidNumberInput(sc, list.size());
            if(select == 0) return;
            selectedMember = (Person) list.get(select - 1);
        }
    }

    //switch level 0

    //switch level 1

    //method level 1
    public static void addStudent(Scanner sc) {
        System.out.println("0: Back to main menu");
        System.out.println("1: Add Undergraduate student");
        System.out.println("2: Add Graduate student");
        System.out.println("Please enter a number for student type:");
        int n = handleInvalidNumberInput(sc, 2);
        if(n == 0) return;
        String memberType = null;
        if(n == 1) memberType = "Undergraduate student";
        else if(n == 2) memberType = "Graduate student";
        System.out.println("Please enter the student's first name:");
        String firstName = sc.next();
        System.out.println("Please enter the student's last name:");
        String lastName = sc.next();
        addStudent2(firstName, lastName, memberType);
        System.out.println("A(n) " + memberType + " has been added");
    }

    //loadFile method level 1
    public static void addStudent2(String firstName, String lastName, String memberType) {
        Student student = new Student(firstName, lastName, memberType);
        addressBook.add(student);
        Maps.putStudentToMaps(student);
    }

    //method level 1
    public static void addMentor(Scanner sc) {
        System.out.println("0: Back to main menu");
        System.out.println("1: Add Academic mentor");
        System.out.println("2: Add Industry mentor");
        System.out.println("Please enter a number for mentor type:");
        int n = handleInvalidNumberInput(sc, 2);
        if(n == 0) return;
        String memberType = null;
        if(n == 1) memberType = "Academic mentor";
        else if(n == 2) memberType = "Industry mentor";
        System.out.println("Please enter the mentor's first name:");
        String firstName = sc.next();
        System.out.println("Please enter the mentor's last name:");
        String lastName = sc.next();
        addMentor2(firstName, lastName, memberType);
        System.out.println("An " + memberType + " has been added");
    }

    //loadFile method level 1
    public static void addMentor2(String firstName, String lastName, String memberType) {
        Mentor mentor = new Mentor(firstName, lastName, memberType);
        addressBook.add(mentor);
        Maps.putMentorToMaps(mentor);
    }

    //switch level 1

    //method level 2
    public static void searchStudentByFirstName(Scanner sc) {
        System.out.println("Please enter the student's first name:");
        String firstName = sc.next();
        ArrayList<Student> resultList = Maps.getStudentFirstNameMap(firstName);
        selectFromList(sc, resultList);
    }

    //for runtime testing
    public static void searchStudentByFirstNameTest(String name) {
        Maps.getStudentFirstNameMap(name);
    }

    //method level 2
    public static void searchStudentByLastName(Scanner sc) {
        System.out.println("Please enter the student's last name:");
        String lastName = sc.next();
        ArrayList<Student> resultList = Maps.getStudentLastNameMap(lastName);
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllUndergraduateStudent(Scanner sc) {
        ArrayList<Person> resultList = Maps.getTypeMap("Undergraduate student");
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllGraduateStudent(Scanner sc) {
        ArrayList<Person> resultList = Maps.getTypeMap("Graduate student");
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchStudentByMentorsLastName(Scanner sc) {
        System.out.println("Please enter the mentor's last name:");
        String mentorLastName = sc.next();
        ArrayList<Mentor> mentorList = Maps.getMentorLastNameMap(mentorLastName);
        ArrayList<Person> studentList = new ArrayList<Person>();
        for(int i = 0; i < mentorList.size(); i++) {
            ArrayList<Student> mentees = (mentorList.get(i)).getMentees();
            for(int j = 0; j < mentees.size(); j++) {
                if(!studentList.contains(mentees.get(j))) {
                    studentList.add(mentees.get(j));
                }
            }
        }
        selectFromList(sc, studentList);
    }

    //switch level 2

    //method level 2
    public static void searchMentorByFirstName(Scanner sc) {
        System.out.println("Please enter the mentor's first name:");
        String firstName = sc.next();
        ArrayList<Mentor> resultList = Maps.getMentorFirstNameMap(firstName);
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchMentorByLastName(Scanner sc) {
        System.out.println("Please enter the mentor's last name:");
        String lastName = sc.next();
        ArrayList<Mentor> resultList = Maps.getMentorLastNameMap(lastName);
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllAcademicMentor(Scanner sc) {
        ArrayList<Person> resultList = Maps.getTypeMap("Academic mentor");
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllIndustryMentor(Scanner sc) {
        ArrayList<Person> resultList = Maps.getTypeMap("Industry mentor");
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllMembersByFirstName(Scanner sc) {
        System.out.println("Please enter the member's first name:");
        String firstName = sc.next();
        ArrayList<Person> resultList = Maps.getPersonFirstNameMap(firstName);
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllMembersByLastName(Scanner sc) {
        System.out.println("Please enter the member's last name:");
        String lastName = sc.next();
        ArrayList<Person> resultList = Maps.getPersonLastNameMap(lastName);
        selectFromList(sc, resultList);
    }

    //switch level 2

    //method level 3
    public static void addMentorToStudent(Scanner sc) {
        Student student = (Student)selectedMember;
        selectedMember = null;
        int redo = 1;
        while(redo != 0) {
            redo = Switch.searchMentor(sc, false);
            if(redo == 0) {
                selectedMember = student;
                return;
            }
            if(selectedMember == null || !student.addMentor((Mentor) selectedMember)) continue;
            ((Mentor) selectedMember).addMentee(student);
            System.out.println("Selected mentor has been added to the student");
            redo = 0;
        }
        selectedMember = student;
    }

    //method level 3
    public static void removePing(Scanner sc) {
        ArrayList<Mentor> list = ((Student)selectedMember).getPings();
        System.out.println("0: Back to previous menu");
        printArrayList(sc, list);
        System.out.println("Please enter a number to select a ping to remove");
        int select = handleInvalidNumberInput(sc, list.size());
        if(select == 0) return;
        list.get(select - 1).removePingMentee((Student) selectedMember);
        ((Student) selectedMember).removePing(select - 1);
        System.out.println("Selected ping has been removed");
    }

    //switch level 3

    //method level 3
    public static void addStudentToMentor(Scanner sc) {
        Mentor mentor = (Mentor)selectedMember;
        selectedMember = null;
        int redo = 1;
        while(redo != 0) {
            redo = Switch.searchStudent(sc, false);
            if(redo == 0) {
                selectedMember = mentor;
                return;
            }
            if(selectedMember == null || !mentor.addMentee((Student) selectedMember)) continue;
            ((Student) selectedMember).addMentor(mentor);
            System.out.println("Selected student has been added to the mentor");
            redo = 0;
        }
        selectedMember = mentor;
    }

    //method level 3
    public static void pingMentee(Scanner sc) {
        Mentor mentor = (Mentor)selectedMember;
        selectedMember = null;
        int redo = 1;
        while(redo != 0) {
            redo = Switch.searchStudent(sc, false);
            if(redo == 0) {
                selectedMember = mentor;
                return;
            }
            if(selectedMember == null || !mentor.addPingMentee((Student) selectedMember)) continue;
            ((Student) selectedMember).addPing(mentor);
            System.out.println("Selected student has been added to the mentor's ping list");
            redo = 0;
        }
        selectedMember = mentor;
    }

    //switch level 3
}
