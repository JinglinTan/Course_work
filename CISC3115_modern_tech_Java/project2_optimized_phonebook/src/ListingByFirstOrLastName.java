import java.util.Collections;
import java.util.Scanner;

public class ListingByFirstOrLastName {
    public static void listingByFirstName(Scanner sc) {
        Collections.sort(Client.getAddressBook(), new SortByFirstNameComparator());
        Client.printArrayList(sc, Client.getAddressBook());
    }

    public static void listingByLastName(Scanner sc) {
        Collections.sort(Client.getAddressBook(), new SortByLastNameComparator());
        Client.printArrayList(sc, Client.getAddressBook());
    }
}
