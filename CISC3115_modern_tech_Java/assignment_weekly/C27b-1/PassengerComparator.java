import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger> {
  public int compare(Passenger lhs, Passenger rhs) {
    return Integer.compare(lhs.getSeatClass(), rhs.getSeatClass());
  }
}
