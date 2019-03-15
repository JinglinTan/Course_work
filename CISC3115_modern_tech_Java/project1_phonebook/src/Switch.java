import java.util.Scanner;

public class Switch {
    //switch level 0
    public static int mainMenuOptions(Scanner sc) {
        Menu.mainMenu();
        int n = Client.handleInvalidNumberInput(sc, 3);
        switch(n) {
            case 0:
                return 0;
            case 1:
                return searchEntry(sc); //switch
            case 2:
                return addEntry(sc); //switch
            case 3:
                Client.showAddressBook(sc); //method
                break;
            default:
                break;
        }
        return 1;
    }

    //switch level 1
    public static int searchEntry(Scanner sc) {
        Menu.searchTypeMenu();
        int n = Client.handleInvalidNumberInput(sc, 3);
        switch(n) {
            case 0:
                return 2;
            case 1:
                return searchStudent(sc, true); //switch
            case 2:
                return searchMentor(sc, true); //switch
            case 3:
                return searchAllMembers(sc); //switch
            default:
                break;
        }
        return 1;
    }

    //switch level 1
    public static int addEntry(Scanner sc) {
        Menu.addTypeMenu();
        int n = Client.handleInvalidNumberInput(sc, 2);
        switch(n) {
            case 0:
                return 2;
            case 1:
                Client.addStudent(sc); //method
                break;
            case 2:
                Client.addMentor(sc); //method
                break;
            default:
                break;
        }
        return 1;
    }

    //switch level 2
    public static int searchStudent(Scanner sc, boolean callFromSearchEntry) {
        Menu.searchStudentMenu(callFromSearchEntry);
        int n = Client.handleInvalidNumberInput(sc, 5);
        switch(n) {
            case 0:
                return 2;
            case 1:
                Client.searchStudentByFirstName(sc); //method
                break;
            case 2:
                Client.searchStudentByLastName(sc); //method
                break;
            case 3:
                Client.searchAllUndergraduateStudent(sc); //method
                break;
            case 4:
                Client.searchAllGraduateStudent(sc); //method
                break;
            case 5:
                Client.searchStudentByMentorsLastName(sc); //method
                break;
            default:
                break;
        }
        return 1;
    }

    //switch level 2
    public static int searchMentor(Scanner sc, boolean callFromSearchEntry) {
        Menu.searchMentorMenu(callFromSearchEntry);
        int n = Client.handleInvalidNumberInput(sc, 4);
        switch(n) {
            case 0:
                return 2;
            case 1:
                Client.searchMentorByFirstName(sc); //method
                break;
            case 2:
                Client.searchMentorByLastName(sc); //method
                break;
            case 3:
                Client.searchAllAcademicMentor(sc); //method
                break;
            case 4:
                Client.searchAllIndustryMentor(sc); //method
                break;
            default:
                break;
        }
        return 1;
    }

    //switch level 2
    public static int searchAllMembers(Scanner sc) {
        Menu.searchAllMembersMenu();
        int n = Client.handleInvalidNumberInput(sc, 2);
        switch(n) {
            case 0:
                return 2;
            case 1:
                Client.searchAllMembersByFirstName(sc); //method
                break;
            case 2:
                Client.searchAllMembersByLastName(sc); //method
                break;
            default:
                break;
        }
        return 1;
    }

    //switch level 3
    public static int studentFunction(Scanner sc) {
        while(true) {
            System.out.println("Selected " + Client.getSelectedMember());
            Menu.studentFunctionMenu();
            int n = Client.handleInvalidNumberInput(sc, 2);
            switch (n) {
                case 0:
                    return 2;
                case 1:
                    Client.addMentorToStudent(sc); //method
                    break;
                case 2:
                    Client.removePing(sc); //method
                    break;
                default:
                    break;
            }
        }
    }

    //switch level 3
    public static int mentorFunction(Scanner sc) {
        while (true) {
            System.out.println("Selected " + Client.getSelectedMember());
            Menu.mentorFunctionMenu();
            int n = Client.handleInvalidNumberInput(sc, 2);
            switch (n) {
                case 0:
                    return 2;
                case 1:
                    Client.addStudentToMentor(sc); //method
                    break;
                case 2:
                    Client.pingMentee(sc); //method
                    break;
                default:
                    break;
            }
        }
    }
}
