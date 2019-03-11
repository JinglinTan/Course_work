public class Student {
  private int id;
  private String firstName;
  private String lastName;
  private double gpa;

  public Student(int id, String firstName, String lastName, double gpa) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gpa = gpa;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String toString() {
    return "Student[id=" + id +
      ",firstName=" + firstName +
      ",lastName=" + lastName +
      ",gpa=" + gpa + "]";
  }
}
