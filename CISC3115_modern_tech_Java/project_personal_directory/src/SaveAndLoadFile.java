import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveAndLoadFile {
    //saveFile method
    public static void saveFile(PrintWriter pw, ArrayList<Person> addressBook) {
        String str;
        for(Person p: addressBook) {
            str = p.getClass().getSimpleName() + "#" + p.getFirstName() +
                    "#" + p.getLastName() + "#" + p.getMemberType();
            pw.println(str);
        }
        pw.println("&$#");
        for(Person p: addressBook) {
            if(p instanceof Student) {
                if(!((Student)p).getMentors().isEmpty()) {
                    str = "mentors#" + ((Student) p).getId();
                    for (Mentor m : ((Student) p).getMentors()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
                if(!((Student)p).getPings().isEmpty()) {
                    str = "pings#" + ((Student) p).getId();
                    for (Mentor m : ((Student) p).getPings()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
            }else if(p instanceof Mentor) {
                if(!((Mentor)p).getMentees().isEmpty()) {
                    str = "mentees#" + ((Mentor) p).getId();
                    for (Student m : ((Mentor) p).getMentees()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
                if(!((Mentor)p).getPingMentees().isEmpty()) {
                    str = "pingMentees#" + ((Mentor) p).getId();
                    for (Student m : ((Mentor) p).getPingMentees()) {
                        str += "#" + m.getId();
                    }
                    pw.println(str);
                }
            }
        }
    }

    //loadFile method
    public static void loadFile(Scanner sc, ArrayList<Person> addressBook) {
        System.out.println("loading...");
        String str = "";
        if(sc.hasNext()) str = sc.nextLine();
        while(!str.equals("&$#") && str.length() != 0) {
            String[] a = str.split("#");
            if(a[0].equals("Student")) {
                Client.addStudent2(a[1], a[2], a[3]);
            }else {
                Client.addMentor2(a[1], a[2], a[3]);
            }
            str = sc.nextLine();
        }
        while(sc.hasNext()) {
            str = sc.nextLine();
            String[] a = str.split("#");
            if(a[0].equals("mentors") || a[0].equals("pings")) {
                Student student = Maps.getStudentIDMap(Integer.parseInt(a[1]));
                ArrayList<Mentor> mentors = new ArrayList<Mentor>();
                for(int j = 2; j < a.length; j++) {
                    mentors.add(Maps.getMentorIDMap(Integer.parseInt(a[j])));
                }
                if(a[0].equals("mentors")) for(Mentor m: mentors) student.addMentor(m);
                if(a[0].equals("pings")) for(Mentor m: mentors) student.addPing(m);
            }
            if(a[0].equals("mentees") || a[0].equals("pingMentees")) {
                Mentor mentor = Maps.getMentorIDMap(Integer.parseInt(a[1]));
                ArrayList<Student> students = new ArrayList<Student>();
                for(int j = 2; j < a.length; j++) {
                    students.add(Maps.getStudentIDMap(Integer.parseInt(a[j])));
                }
                if(a[0].equals("mentees")) for(Student s: students) mentor.addMentee(s);
                if(a[0].equals("pingMentees")) for(Student s: students) mentor.addPingMentee(s);
            }
        }
    }
}
