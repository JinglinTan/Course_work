public class CircleUtils {

  public void printCircle(Circle c) {
    System.out.println("The area of the circle of radius " + c.getRadius() + " is " + c.getArea());
  }

  public void printCircle(Circle circle, int times) {
    Circle c = new Circle(circle);
    System.out.println("Radius \t\t Area");
    for (int i = 0; i < times; i ++) {
      System.out.println(c.getRadius() + "\t\t" + c.getArea());
      c.setRadius(c.getRadius() + 1);
    }
  }

  public void doubleRadius(Circle c){
    c.setRadius(c.getRadius() * 2);
  }

  public void doubleArea(Circle c){
    c.setRadius(c.getRadius() * Math.sqrt(2));
  }

  public Circle getNewCircleDoubleRadius(Circle c){
    Circle cNew = new Circle();
    cNew.setRadius(2 * c.getRadius());
    return cNew;
  }

  public Circle getNewCircleDoubleArea(Circle c){
    Circle cNew = new Circle();
    cNew.setRadius(Math.sqrt(2) * c.getRadius());
    return cNew;
  }
}
