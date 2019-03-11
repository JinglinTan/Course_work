import java.util.ArrayList;

//Jinglin
public class Mentor extends Person {
    private ArrayList<Student> mentees;
    private ArrayList<Student> pingMentees;
    private int id;
    private static int countID = 70000;

    public Mentor(String firstName, String lastName, String memberType) {
        super(firstName, lastName, memberType);
        mentees = new ArrayList<Student>();
        pingMentees = new ArrayList<Student>();
        id = ++countID;
    }

    public ArrayList<Student> getMentees() {
        return mentees;
    }

    public ArrayList<Student> getPingMentees() {
        return pingMentees;
    }

    public int getId() {
        return id;
    }

    public boolean addMentee(Student student) {
        for(Student s: mentees) {
            if(s == student) {
                System.out.println("The student is already added to this mentor, please reselect a student");
                return false;
            }
        }
        mentees.add(student);
        return true;
    }

    public boolean addPingMentee(Student student) {
        for(Student s: pingMentees) {
            if(s == student) {
                System.out.println("The student is already pinged by this mentor");
                return false;
            }
        }
        pingMentees.add(student);
        return true;
    }


    public void removePingMentee(Student student) {
        for(int i = 0; i < pingMentees.size(); i++) {
            if(pingMentees.get(i) == student) pingMentees.remove(i);
        }
    }

    @Override
    public String toString() {
        String studentList = "";
        String ping = "";
        for (Student m : mentees) studentList += m.getFirstName() + " " + m.getLastName() + ", ";
        for (Student m : pingMentees) ping += m.getFirstName() + " " + m.getLastName() + ", ";
        return "Mentor{Last name:" + getLastName() +
                ", First name:" + getFirstName() +
                ", Member type:" + getMemberType() +
                ", Mentee(s):" + studentList +
                ", Pinging mentee(s):" + ping + "}";
    }
}
