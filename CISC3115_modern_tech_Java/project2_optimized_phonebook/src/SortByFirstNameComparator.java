import java.util.Comparator;

public class SortByFirstNameComparator implements Comparator<Person> {
    public int compare(Person lhs, Person rhs) {
        return lhs.getFirstName().compareTo(rhs.getFirstName());
    }
}
