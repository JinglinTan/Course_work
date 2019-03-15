import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestingRuntime {
    public static void testRuntime(Scanner sc) {
        System.out.println("Please enter the number of entries to be tested:");
        int times = sc.nextInt();
        testAdding(times);
        testSearching(times);
    }

    public static void testAdding(int times) {
        Random rd = new Random();

        ArrayList<String> a = new ArrayList<String>(times);
        ArrayList<String> b = new ArrayList<String>(times);
        ArrayList<String> c = new ArrayList<String>(times);

        for(int i = 0; i < times; i++) {
            a.add(rd.nextInt(100000) + "");
            b.add(rd.nextInt(100000) + "");
            c.add(rd.nextInt(100000) + "");
        }

        long startTime = System.nanoTime();
        for(int i = 0; i < times; i++) {
            Client.addStudent2(a.get(i), b.get(i), c.get(i));
        }
        long endTime = System.nanoTime();

        System.out.println("Runtime of adding " + times + " entries is " +
                (endTime - startTime) + " nanoseconds");
    }

    public static void testSearching(int times) {
        long startTime = System.nanoTime();
        for(int i = 0; i < times; i++) {
            Client.searchStudentByFirstNameTest(i + "");
        }
        long endTime = System.nanoTime();

        System.out.println("Runtime of searching " + times + " entries is " +
                (endTime - startTime) + " nanoseconds");
    }
}
