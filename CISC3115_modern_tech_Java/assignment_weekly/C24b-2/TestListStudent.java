import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ListIterator;

public class TestListStudent  {
  public static void main(String[] args) {
    TestListStudent test = new TestListStudent();

    final int size = 5;

    System.out.println("-------ArrayList----------");
    ArrayList<Student> studentArrayList =
      (ArrayList<Student>)test.makeRandomStudentList(new ArrayList<Student>(), size);
    test.printList(studentArrayList);

    // test.updateRandomStudent(studentArrayList, "John", "Doe");
    replaceJToJohn(studentArrayList);

    System.out.println("-----------------");
    test.printList(studentArrayList);

    System.out.println("-------LinkedList----------");
    LinkedList<Student> studentLinkedList =
      (LinkedList<Student>)test.makeRandomStudentList(new LinkedList<Student>(), size);
    test.printList(studentLinkedList);

    // test.updateRandomStudent(studentLinkedList, "John", "Doe");
    replaceJToJohn(studentLinkedList);

    System.out.println("-----------------");
    test.printList(studentLinkedList);
  }

  private static void replaceJToJohn(List<Student> list) {
    ListIterator iter = list.listIterator();
    while(iter.hasNext()) {
      Student student = (Student)iter.next();
      if(student.getFirstName().substring(0, 1).equals("J")) {
        student.setFirstName("John");
      }
    }
  }

  private void updateRandomStudent(List<Student> list, String firstName, String lastName) {
    Random rng = new Random();
    int index = rng.nextInt(list.size());
    Student s = list.get(index);

    s.setFirstName(firstName);
    s.setLastName(lastName);
  }

  private List<Student> makeRandomStudentList(List<Student> list, int size) {
    Random rng = new Random();
    for (int i=0; i<size; i++) {
      String firstName = String.valueOf((char)('A' + rng.nextInt(26)));
      String lastName = String.valueOf((char)('A' + rng.nextInt(26)));
      double gpa = rng.nextDouble() * 4.0;
      Student s = new Student(i, firstName, lastName, gpa);
      list.add(s);
    }
    return list;
  }

  private void printList(List<Student> list) {
    for(Student s: list) {
      System.out.println(s.toString());
    }
  }
}
