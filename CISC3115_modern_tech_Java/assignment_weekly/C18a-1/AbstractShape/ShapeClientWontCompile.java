//this program cannot be compiled because the compiler prevents us to
//instantiate the abstract class Shape

/**
 * This  program won't compile. Why?
 */
import java.util.ArrayList;

public class ShapeClientWontCompile
{
    public static void main(String[] args) {
        ArrayList<Shape> shapeList = new ArrayList<Shape>();

        Shape s1 = new Circle("circle 1", 10);
        shapeList.add(s1);

        Shape s2 = new Rectangle("rectangle 2", 100, 100);
        shapeList.add(s2);

        // Compiler may not prevent this kind of error
        Shape s3 = new Shape("Shape 3");
        shapeList.add(s3);

        Shape s4 = new RightTriangle("RightTriangle 4", 50, 50);
        shapeList.add(s4);

        double totalArea = sumAreasOfShapes(shapeList);
        System.out.println("The total area of the shapes are " + totalArea);
    }

    public static double sumAreasOfShapes(ArrayList<Shape> shapeList) {
      double sum = 0.;
      // Use the enhanced for loop
      // for (Shape shape: shapeList) {
      //   sum += shape.getArea();
      // }

      // Use the for loop
      for (int i=0; i<shapeList.size(); i++) {
        sum += shapeList.get(i).getArea();
      }
      return sum;
    }
}
