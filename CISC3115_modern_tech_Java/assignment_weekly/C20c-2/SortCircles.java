import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SortCircles {
  public static void main(String[] args) {
    /* create and initialize an Array */
    ArrayList<Circle> circles = new ArrayList<Circle>();
    circles.add(new Circle(3));
    circles.add(new Circle(1));
    circles.add(new Circle(2));

    /* Sort the Array */
    Collections.sort(circles);

    /* print out the circles */
    for (Circle c: circles) {
      System.out.print(c + " ");
      System.out.println();
    }
  }
}
