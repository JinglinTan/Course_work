import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Jinglin
public class Maps {
    private static Map<String, ArrayList<Student>> studentFirstNameMap = new HashMap<String, ArrayList<Student>>();
    private static Map<String, ArrayList<Student>> studentLastNameMap = new HashMap<String, ArrayList<Student>>();
    private static Map<Integer, Student> studentIDMap = new HashMap<Integer, Student>();
    private static Map<String, ArrayList<Mentor>> mentorFirstNameMap = new HashMap<String, ArrayList<Mentor>>();
    private static Map<String, ArrayList<Mentor>> mentorLastNameMap = new HashMap<String, ArrayList<Mentor>>();
    private static Map<Integer, Mentor> mentorIDMap = new HashMap<Integer, Mentor>();
    private static Map<String, ArrayList<Person>> personFirstNameMap = new HashMap<String, ArrayList<Person>>();
    private static Map<String, ArrayList<Person>> personLastNameMap = new HashMap<String, ArrayList<Person>>();
    private static Map<String, ArrayList<Person>> typeMap = new HashMap<String, ArrayList<Person>>();

    public static void putStudentToMaps(Student student) {
        putStudentFirstNameMap(student);
        putStudentLastNameMap(student);
        putStudentIDMap(student);
        putPersonFirstNameMap(student);
        putPersonLastNameMap(student);
        putTypeMap(student);
    }

    public static void putMentorToMaps(Mentor mentor) {
        putMentorFirstNameMap(mentor);
        putMentorLastNameMap(mentor);
        putMentorIDMap(mentor);
        putPersonFirstNameMap(mentor);
        putPersonLastNameMap(mentor);
        putTypeMap(mentor);
    }

    //put

    public static void putStudentFirstNameMap(Student student) {
        String firstName = student.getFirstName();
        if (!studentFirstNameMap.containsKey(firstName)) {
            studentFirstNameMap.put(firstName, new ArrayList<Student>());
        }
        ArrayList<Student> arr = studentFirstNameMap.get(firstName);
        arr.add(student);
    }

    public static void putStudentLastNameMap(Student student) {
        String lastName = student.getLastName();
        if (!studentLastNameMap.containsKey(lastName)) {
            studentLastNameMap.put(lastName, new ArrayList<Student>());
        }
        ArrayList<Student> arr = studentLastNameMap.get(lastName);
        arr.add(student);
    }

    public static void putStudentIDMap(Student student) {
        studentIDMap.put(student.getId(), student);
    }

    public static void putMentorIDMap(Mentor mentor) {
        mentorIDMap.put(mentor.getId(), mentor);
    }

    public static void putMentorFirstNameMap(Mentor mentor) {
        String firstName = mentor.getFirstName();
        if (!mentorFirstNameMap.containsKey(firstName)) {
            mentorFirstNameMap.put(firstName, new ArrayList<Mentor>());
        }
        ArrayList<Mentor> arr = mentorFirstNameMap.get(firstName);
        arr.add(mentor);
    }

    public static void putMentorLastNameMap(Mentor mentor) {
        String lastName = mentor.getLastName();
        if (!mentorLastNameMap.containsKey(lastName)) {
            mentorLastNameMap.put(lastName, new ArrayList<Mentor>());
        }
        ArrayList<Mentor> arr = mentorLastNameMap.get(lastName);
        arr.add(mentor);
    }

    public static void putPersonFirstNameMap(Person person) {
        String firstName = person.getFirstName();
        if (!personFirstNameMap.containsKey(firstName)) {
            personFirstNameMap.put(firstName, new ArrayList<Person>());
        }
        ArrayList<Person> arr = personFirstNameMap.get(firstName);
        arr.add(person);
    }

    public static void putPersonLastNameMap(Person person) {
        String lastName = person.getLastName();
        if (!personLastNameMap.containsKey(lastName)) {
            personLastNameMap.put(lastName, new ArrayList<Person>());
        }
        ArrayList<Person> arr = personLastNameMap.get(lastName);
        arr.add(person);
    }

    public static void putTypeMap(Person person) {
        String type = person.getMemberType();
        if (!typeMap.containsKey(type)) {
            typeMap.put(type, new ArrayList<Person>());
        }
        ArrayList<Person> arr = typeMap.get(type);
        arr.add(person);
    }

    //get

    public static ArrayList<Student> getStudentFirstNameMap(String firstName) {
        return studentFirstNameMap.get(firstName);
    }

    public static ArrayList<Student> getStudentLastNameMap(String lastName) {
        return studentLastNameMap.get(lastName);
    }

    public static Student getStudentIDMap(int id) {
        return studentIDMap.get(id);
    }

    public static ArrayList<Mentor> getMentorFirstNameMap(String firstName) {
        return mentorFirstNameMap.get(firstName);
    }

    public static ArrayList<Mentor> getMentorLastNameMap(String lastName) {
        return mentorLastNameMap.get(lastName);
    }

    public static Mentor getMentorIDMap(int id) {
        return mentorIDMap.get(id);
    }

    public static ArrayList<Person> getPersonFirstNameMap(String firstName) {
        return personFirstNameMap.get(firstName);
    }

    public static ArrayList<Person> getPersonLastNameMap(String lastName) {
        return personLastNameMap.get(lastName);
    }

    public static ArrayList<Person> getTypeMap(String type) {
        return typeMap.get(type);
    }
}
