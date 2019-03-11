import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class SortShapes {
  public static void main(String[] args) {
    /* create and initialize an Array */
    ArrayList<GeometricObject> shapes = new ArrayList<GeometricObject>();
    shapes.add(new Circle(3));
    shapes.add(new Rectangle(6, 7));
    shapes.add(new Circle(1));
    shapes.add(new Rectangle(4, 5));
    shapes.add(new Circle(2));
    shapes.add(new Rectangle(2, 3));

    /* Sort the Array */
    Collections.sort(shapes);

    /* print out the circles */
    for (GeometricObject g: shapes) {
      System.out.print(g + " ");
      System.out.println();
    }
  }
}
