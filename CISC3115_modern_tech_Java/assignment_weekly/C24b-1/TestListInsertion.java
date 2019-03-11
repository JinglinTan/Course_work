
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestListInsertion {
  public static void main(String[] args) {
    TestListInsertion app = new TestListInsertion();

    final int initSize = 10000;
    final int max = 5000000;
    final int maxInsertions = 10000;

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    app.makeRandomList(arrayList, initSize, max);

    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    app.makeRandomList(linkedList, initSize, max);

    app.testDelete(arrayList);
    app.testDelete(linkedList);

    // app.testInsertion(arrayList, maxInsertions);
    // app.testInsertion(linkedList, maxInsertions);
  }

  private void testDelete(List list) {
    long startTime = System.nanoTime();
    while(!list.isEmpty()) {
      list.remove(0);
    }
    long endTime = System.nanoTime();
    System.out.println("Time to deleting the whole list " +
      " for " + list.getClass().getName() + ": " + (endTime - startTime));
  }

  private <T> void testInsertion(List<T> list, int maxInsertions) {
    Random rng = new Random();
    T t = list.get(0);

    long startTime = System.nanoTime();
    for (int i=0; i<maxInsertions; i++) {
      list.add(0, t);
    }
    long endTime = System.nanoTime();

    System.out.println("Time to inserting randomly " + maxInsertions +
      " elments to a " + list.getClass().getName() + ": " + (endTime - startTime));
  }

  private List<Integer> makeRandomList(List<Integer> list, int size, int max) {
    Random rng = new Random();
    for (int i=0; i<size; i++) {
      list.add(rng.nextInt(max));
    }
    return list;
  }
}
