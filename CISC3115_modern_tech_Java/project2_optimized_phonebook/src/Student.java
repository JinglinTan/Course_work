import java.util.ArrayList;

//Jia Liang
public class Student extends Person {
    private ArrayList<Mentor> mentors;
    private ArrayList<Mentor> pings;
    private int id;
    private static int countID = 10000;

    public Student(String first, String last, String memberType) {
        super(first, last, memberType);
        mentors = new ArrayList<Mentor>();
        pings = new ArrayList<Mentor>();
        id = ++countID;
    }

    public ArrayList<Mentor> getMentors() {
        return mentors;
    }

    public ArrayList<Mentor> getPings() {
        return pings;
    }

    public int getId() {
        return id;
    }

    public boolean addMentor(Mentor mentor) {
        for (int i = 0; i < mentors.size(); i++) {
            if (mentors.get(i) == mentor) {
                System.out.println("The mentor is already added to this student, please reselect a mentor");
                return false;
            }
        }
        mentors.add(mentor);
        return true;
    }

    public void addPing(Mentor ping) {
        pings.add(ping);
    }

    public void removePing(int index) {
        pings.remove(index);
    }

    @Override
    public String toString() {
        String mentorList = "";
        String ping = "";
        for (Mentor m : mentors) mentorList += m.getFirstName() + " " + m.getLastName() + ", ";
        if(mentorList.length() != 0)
            mentorList = mentorList.substring(0, mentorList.length() - 2);
        for (Mentor m : pings) ping += m.getFirstName() + " " + m.getLastName() + ", ";
        if(ping.length() != 0)
            ping = ping.substring(0, ping.length() - 2);
        return "Student{Last name:" + getLastName() +
                "; First name:" + getFirstName() +
                "; Member type:" + getMemberType() +
                "; Mentor(s):" + mentorList +
                "; Ping by mentor(s):" + ping + "}";
    }
}
