import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    private static ArrayList<Person> addressBook = new ArrayList<Person>();
    private static Person selectedMember;

    public static void main(String[] args) {
        try(Scanner scLoad = new Scanner(new File("saveFile.txt"))) {
        load(scLoad);
        } catch(Exception e) {
//            System.out.println(e.getMessage());
            System.out.println("Error: - load file might not exist(This is normal for first-time launching)");
        }
        Scanner sc = new Scanner(System.in);
        int redo = 1;
        while(redo != 0) {
            redo = Switch.mainMenuOptions(sc);
            if(redo == 0) break;
            if(selectedMember instanceof Student) redo = Switch.studentFunction(sc);
            else if(selectedMember instanceof Mentor) redo = Switch.mentorFunction(sc);
            selectedMember = null;
            System.out.println();
        }
        try(PrintWriter pw = new PrintWriter(new File("saveFile.txt"))) {
            save(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program closed");
    }

    //getter
    public static Person getSelectedMember() {
        return selectedMember;
    }

    //save method
    public static void save(PrintWriter pw) {
        String str;
        for(Person p: addressBook) {
            str = p.getClass().getSimpleName() + "#" + p.getFirstName() +
                    "#" + p.getLastName() + "#" + p.getMemberType();
            pw.println(str);
        }
        pw.println("&$#");
        for(Person p: addressBook) {
            if(p instanceof Student) {
                if(!((Student)p).getMentors().isEmpty()) {
                    str = "mentors#" + ((Student)p).getId();
                    for (Mentor m : ((Student) p).getMentors()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
                if(!((Student)p).getPings().isEmpty()) {
                    str = "pings#" + ((Student) p).getId();
                    for (Mentor m : ((Student) p).getPings()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
            }else if(p instanceof Mentor) {
                if(!((Mentor)p).getMentees().isEmpty()) {
                    str = "mentees#" + ((Mentor) p).getId();
                    for (Student m : ((Mentor) p).getMentees()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
                if(!((Mentor)p).getPingMentees().isEmpty()) {
                    str = "pingMentees#" + ((Mentor) p).getId();
                    for (Student m : ((Mentor) p).getPingMentees()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
            }
        }
    }

    //load method
    public static void load(Scanner sc) {
        System.out.println("loading...");
        String str = "";
        if(sc.hasNext()) str = sc.nextLine();
        while(!str.equals("&$#")) {
            String[] a = str.split("#");
            if(a[0].equals("Student")) {
                addStudent2(a[1], a[2], a[3]);
            }else {
                addMentor2(a[1], a[2], a[3]);
            }
            str = sc.nextLine();
        }
        while(sc.hasNext()) {
            str = sc.nextLine();
            String[] a = str.split("#");
            if(a[0].equals("mentors") || a[0].equals("pings")) {
                Student student = null;
                ArrayList<Mentor> mentors = new ArrayList<Mentor>();
                for(int i = 0; i < addressBook.size(); i++) {
                    if(addressBook.get(i).getId() == Integer.parseInt(a[1])) {
                        student = (Student)addressBook.get(i);
                    }
                }
                for(int j = 2; j < a.length; j++) {
                    for (int i = 0; i < addressBook.size(); i++) {
                        if (addressBook.get(i).getId() == Integer.parseInt(a[j])) {
                            mentors.add((Mentor) addressBook.get((i)));
                        }
                    }
                }
                if(a[0].equals("mentors")) for(Mentor m: mentors) student.addMentor(m);
                if(a[0].equals("pings")) for(Mentor m: mentors) student.addPing(m);
            }
            if(a[0].equals("mentees") || a[0].equals("pingMentees")) {
                Mentor mentor = null;
                ArrayList<Student> students = new ArrayList<Student>();
                for(int i = 0; i < addressBook.size(); i++) {
                    if(addressBook.get(i).getId() == Integer.parseInt(a[1])) {
                        mentor = (Mentor)addressBook.get(i);
                    }
                }
                for(int j = 2; j < a.length; j++) {
                    for (int i = 0; i < addressBook.size(); i++) {
                        if (addressBook.get(i).getId() == Integer.parseInt(a[j])) {
                            students.add((Student) addressBook.get((i)));
                        }
                    }
                }
                if(a[0].equals("mentees")) for(Student s: students) mentor.addMentee(s);
                if(a[0].equals("pingMentees")) for(Student s: students) mentor.addPingMentee(s);
            }
        }
    }

    //general method
    public static int handleInvalidNumberInput(Scanner sc, int max) {
        int i = 0;
        int redo = 1;
        while(redo != 0) {
            try {
                i = sc.nextInt();
            } catch (Exception e) {
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
        if(list.isEmpty()) {
            System.out.println("No result found");
            return false;
        }
        for(int i = 0; i < list.size(); i++) System.out.println((i + 1) + ": " + list.get(i));
        return true;
    }

    //general method
    public static void selectFromList(Scanner sc, ArrayList list) {
        System.out.println("0: Back");
        if(printArrayList(sc, list)) {
            System.out.println("Please select a member to edit/add:");
            int select = handleInvalidNumberInput(sc, list.size());
            if(select == 0) return;
            selectedMember = (Person) list.get(select - 1);
        }
    }

    //method level 0
    public static void showAddressBook(Scanner sc) {
        printArrayList(sc, addressBook);
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

    //load method level 1
    public static void addStudent2(String firstName, String lastName, String memberType) {
        addressBook.add(new Student(firstName, lastName, memberType));
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

    //load method level 1
    public static void addMentor2(String firstName, String lastName, String memberType) {
        addressBook.add(new Mentor(firstName, lastName, memberType));
    }

    //switch level 1

    //method level 2
    public static void searchStudentByFirstName(Scanner sc) {
        System.out.println("Please enter the student's first name:");
        String firstName = sc.next();
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Student && addressBook.get(i).getFirstName().equals(firstName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchStudentByLastName(Scanner sc) {
        System.out.println("Please enter the student's last name:");
        String lastName = sc.next();
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Student && addressBook.get(i).getLastName().equals(lastName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllUndergraduateStudent(Scanner sc) {
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Student && addressBook.get(i).getMemberType().equals("Undergraduate student")) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllGraduateStudent(Scanner sc) {
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Student && addressBook.get(i).getMemberType().equals("Graduate student")) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchStudentByMentorsLastName(Scanner sc) {
        System.out.println("Please enter the mentor's last name:");
        String mentorLastName = sc.next();
        ArrayList<Person> mentorList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Mentor && addressBook.get(i).getLastName().equals(mentorLastName)) {
                mentorList.add(addressBook.get(i));
            }
        }
        ArrayList<Person> studentList = new ArrayList<Person>();
        for(int i = 0; i < mentorList.size(); i++) {
            ArrayList<Student> mentees = ((Mentor)mentorList.get(i)).getMentees();
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
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Mentor && addressBook.get(i).getFirstName().equals(firstName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchMentorByLastName(Scanner sc) {
        System.out.println("Please enter the mentor's last name:");
        String lastName = sc.next();
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Mentor && addressBook.get(i).getLastName().equals(lastName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllAcademicMentor(Scanner sc) {
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Mentor && addressBook.get(i).getMemberType().equals("Academic mentor")) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllIndustryMentor(Scanner sc) {
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i) instanceof Mentor && addressBook.get(i).getMemberType().equals("Industry mentor")) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllMembersByFirstName(Scanner sc) {
        System.out.println("Please enter the member's first name:");
        String firstName = sc.next();
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i).getFirstName().equals(firstName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //method level 2
    public static void searchAllMembersByLastName(Scanner sc) {
        System.out.println("Please enter the mentor's last name:");
        String lastName = sc.next();
        ArrayList<Person> resultList = new ArrayList<Person>();
        for(int i = 0; i < addressBook.size(); i++) {
            if(addressBook.get(i).getLastName().equals(lastName)) {
                resultList.add(addressBook.get(i));
            }
        }
        selectFromList(sc, resultList);
    }

    //switch level 2

    //method level 3
    public static void addMentorToStudent(Scanner sc) {
        Student student = (Student)selectedMember;
        selectedMember = null;
        int redo = 2;
        while(redo != 0) {
            redo = Switch.searchMentor(sc, false);
            if(redo == 2) {
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
        int redo = 2;
        while(redo != 0) {
            redo = Switch.searchStudent(sc, false);
            if(redo == 2) {
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
        int redo = 2;
        while(redo != 0) {
            redo = Switch.searchStudent(sc, false);
            if(redo == 2) {
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
