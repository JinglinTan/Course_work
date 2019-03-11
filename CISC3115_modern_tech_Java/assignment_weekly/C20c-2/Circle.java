public class Circle extends GeometricObject implements Comparable<Circle> {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double getPerimeter() {
    return 2 * radius;
  }

  @Override
  public int compareTo(Circle o) {
    return (int)(Math.round(getArea() - o.getArea()));
  }

  @Override
  public String toString() {
    return "Radius: " + getRadius() +
          " Area: " + getArea();
  }
}
