import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SortingArrays {
  public static void main(String[] args) {
    // Create an Integer arrayList
    ArrayList<Integer> integers = new ArrayList<Integer>();
    integers.add(2);
    integers.add(4);
    integers.add(3);

    // Create a Double arrayList
    ArrayList<Double> doubles = new ArrayList<Double>();
    doubles.add(3.4);
    doubles.add(1.3);
    doubles.add(-22.1);

    // Create a Character arrayList
    ArrayList<Character> chars = new ArrayList<Character>();
    chars.add('a');
    chars.add('J');
    chars.add('r');

    // Create a String arrayList
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Tom");
    strings.add("John");
    strings.add("Fred");

    // Sort the arrayLists
    Collections.sort(integers);
    Collections.sort(doubles);
    Collections.sort(chars);
    Collections.sort(strings);

    // Display the sorted arrayLists
    System.out.print("Sorted Integer objects: ");
    printList(integers);
    System.out.print("Sorted Double objects: ");
    printList(doubles);
    System.out.print("Sorted Character objects: ");
    printList(chars);
    System.out.print("Sorted String objects: ");
    printList(strings);
  }

  /** Print an arrayList of objects */
  public static void printList(ArrayList list) {
    for (int i = 0; i < list.size(); i++)
      System.out.print(list.get(i) + " ");
    System.out.println();
  }
}
