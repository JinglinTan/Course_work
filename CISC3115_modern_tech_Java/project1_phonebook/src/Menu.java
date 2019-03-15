public class Menu {
    public static void mainMenu() {
        System.out.println("Welcome to Personal Directory app, you are in the main menu:");
        System.out.println("0: Save and exit");
        System.out.println("1: Search entry and edit");
        System.out.println("2: Add entry");
        System.out.println("3: Show entire Address Book");
        System.out.println("Please enter a number of option:");
    }

    public static void addTypeMenu() {
        System.out.println("0: Back to main menu");
        System.out.println("1: Add a student");
        System.out.println("2: Add a mentor");
        System.out.println("Please enter a number of option:");
    }

    public static void searchTypeMenu() {
        System.out.println("0: Back to main menu");
        System.out.println("1: Search for a student and edit");
        System.out.println("2: Search for a mentor and edit");
        System.out.println("3: Search for a member(student or mentor) and edit");
        System.out.println("Please enter a number of option:");
    }

    public static void searchStudentMenu(boolean callFromSearchEntry) {
        if(callFromSearchEntry) System.out.println("0: Back to main menu");
        else {
            System.out.println("Please search a student to be added");
            System.out.println("0: Back to mentor menu");
        }
        System.out.println("1: Search student by first name");
        System.out.println("2: Search student by last name");
        System.out.println("3: Show all undergraduate students");
        System.out.println("4: Show all graduate students");
        System.out.println("5: Mentor's last name");
        System.out.println("Please enter a number of option:");
    }

    public static void searchMentorMenu(boolean callFromSearchEntry) {
        if(callFromSearchEntry) System.out.println("0: Back to main menu");
        else {
            System.out.println("Please search a mentor to be added");
            System.out.println("0: Back to student menu");
        }
        System.out.println("1: Search mentor by first name");
        System.out.println("2: Search mentor by last name");
        System.out.println("3: Show all academic mentors");
        System.out.println("4: Show all Industry mentors");
        System.out.println("Please enter a number of option:");
    }

    public static void searchAllMembersMenu() {
        System.out.println("0: Back to main menu");
        System.out.println("1: Search member by first name");
        System.out.println("2: Search member by last name");
        System.out.println("Please enter a number of option:");
    }

    public static void studentFunctionMenu() {
        System.out.println("0: Back to main menu");
        System.out.println("1: Add a mentor to mentor list");
        System.out.println("2: Remove a ping");
        System.out.println("Please enter a number of option:");
    }

    public static void mentorFunctionMenu() {
        System.out.println("0: Back to main menu");
        System.out.println("1: Add a student to mentee list");
        System.out.println("2: Ping a student");
        System.out.println("Please enter a number of option:");
    }
}
