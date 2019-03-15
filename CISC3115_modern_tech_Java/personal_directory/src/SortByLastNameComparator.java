import java.util.Comparator;

public class SortByLastNameComparator implements Comparator<Person> {
    public int compare(Person lhs, Person rhs) {
        return lhs.getLastName().compareTo(rhs.getLastName());
    }
}
