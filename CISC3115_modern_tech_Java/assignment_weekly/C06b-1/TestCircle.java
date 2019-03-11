public class TestCircle {
  public static void main(String[] args) {
    Circle myCircle = new Circle (1.0);
    int n = 5;

    CircleUtils circleUtils = new CircleUtils();

    System.out.println("----------printCircle(myCircle, n)-------------");
    circleUtils.printCircle(myCircle, n);
    System.out.println("----------printCircle(myCircle)-------------");
    circleUtils.printCircle(myCircle);

    circleUtils.doubleRadius(myCircle);
    System.out.println("The double radius is " + myCircle.getRadius());

    circleUtils.doubleArea(myCircle);
    System.out.println("The double area is " + myCircle.getArea());

    Circle circle1 = circleUtils.getNewCircleDoubleRadius(myCircle);
    System.out.println("The new circle's radius is " + circle1.getRadius());

    circle1 = circleUtils.getNewCircleDoubleArea(myCircle);
    System.out.println("The new circle's area is " + circle1.getArea());
  }
}
