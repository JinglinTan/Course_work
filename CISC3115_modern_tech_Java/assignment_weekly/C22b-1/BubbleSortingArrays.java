/**
 * The sample program from Chapter 13 in
 *   Liang Y Daniel, Introduction to Java Programming, 11st Edition
 * which is revised to use the Bubble sort
 */
public class BubbleSortingArrays {
  public static void main(String[] args) {
    // Create an Integer array
    Integer[] intArray = {
      Integer.valueOf(2), Integer.valueOf(4),  Integer.valueOf(3)
    };

    // Create a Double array
    Double[] doubleArray = {
      Double.valueOf(3.4), Double.valueOf(1.3), Double.valueOf(-22.1)
    };

    // Create a Character array
    Character[] charArray = {
      Character.valueOf('a'), Character.valueOf('J'), Character.valueOf('r')
    };

    // Create a String array
    String[] stringArray = {"Tom", "John", "Fred"};

    // Sort the arrays
    bubbleSort(intArray, intArray.length);
    bubbleSort(doubleArray, doubleArray.length);
    bubbleSort(charArray, charArray.length);
    bubbleSort(stringArray, stringArray.length);

    // Display the sorted arrays
    System.out.print("Sorted Integer objects: ");
    printList(intArray);
    System.out.print("Sorted Double objects: ");
    printList(doubleArray);
    System.out.print("Sorted Character objects: ");
    printList(charArray);
    System.out.print("Sorted String objects: ");
    printList(stringArray);
  }

  //bubbleSort
  public static void bubbleSort(Comparable[] list, int i) {
    if(i == 1) return;
    int j = 0;
    while(j < i - 1) {
      if(list[j].compareTo(list[j + 1]) > 0) {
        Comparable temp = list[j];
        list[j] = list[j + 1];
        list[j + 1] = temp;
      }
      j++;
    }
    bubbleSort(list, --i);
  }

  /** Sort an array of comparable objects using the Bubble sort algorithm */
  public static void sort(Comparable[] list) {
    Comparable currentMin;
    int currentMinIndex;

    // select subarray (the range of the array) where we bubble up the greatest in the subarray
    for (int i = 0; i < list.length - 1; i++) {
      // bubble up the greast in the subarray (in the range of the array)
      for (int j=0; j <list.length - i - 1; j++) {
        if (list[j].compareTo(list[j+1]) > 0) {
          Comparable tmp = list[j];
          list[j] = list[j+1];
          list[j+1] = tmp;
        }
      }
    }
  }

  /** Print an array of objects */
  public static void printList(Object[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
    System.out.println();
  }
}
