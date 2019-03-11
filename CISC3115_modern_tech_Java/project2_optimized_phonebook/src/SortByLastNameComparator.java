import java.util.Comparator;

//Jia Liang
public class SortByLastNameComparator implements Comparator<Person> {
    public int compare(Person lhs, Person rhs) {
        return lhs.getLastName().compareTo(rhs.getLastName());
    }
}
