import java.util.Comparator;

public class SortStudentDescending implements Comparator<Student> {
  @Override
  public int compare(Student lhs, Student rhs) {
    return lhs.getLastName().compareTo(rhs.getLastName()) * (-1);
  }
}
