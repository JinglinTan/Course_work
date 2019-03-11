public class Circle {
  private double radius = 1.0;

  public Circle() {
  }

  public Circle(double newRadius) {
    radius = newRadius;
  }

  public Circle(Circle c) {
    radius = c.radius;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double newRadius) {
    radius = newRadius;
  }

  public double getArea() {
    return radius * radius * Math.PI;
  }
}
