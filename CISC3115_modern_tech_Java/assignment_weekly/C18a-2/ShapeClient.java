//there was no error when I ran this client

import java.util.ArrayList;

public class ShapeClient
{
    public static void main(String[] args) {
        ArrayList<Shape> shapeList = new ArrayList<Shape>();

        Shape s1 = new Circle("circle 1", 10);
        shapeList.add(s1);

        Shape s2 = new Rectangle("rectangle 2", 100, 100);
        shapeList.add(s2);

        Shape s3 = new RightTriangle("RightTriangle 3", 50, 50);
        shapeList.add(s3); //added a RightTriangle object to the list

        Shape s4 = new EquilateralTriangle("EquilateralTriangle 4", 100);
        shapeList.add(s4); //added a EquilateralTriangel object to the list

        if (!s1.getClass().isInstance(s2)) {
        	System.out.println("Actual types of s1 and s2 are different");
        }

        double totalArea = sumAreasOfShapes(shapeList);
        System.out.println("The total area of the shapes are " + totalArea);

        //statements to demonstrate the use of the isEquailateral method
        if(((Triangle)s3).isEquilateral()) {
          System.out.println("s3 is an equilateral triangle");
        } else {
          System.out.println("s3 is not equilateral triangle");
        }

        if(((Triangle)s4).isEquilateral()) {
          System.out.println("s4 is an equilateral triangle");
        } else {
          System.out.println("s4 is not equilateral triangle");
        }
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
