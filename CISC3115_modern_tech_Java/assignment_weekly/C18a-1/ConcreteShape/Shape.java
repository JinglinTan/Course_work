public class Shape {
  private String name;

  public Shape(String name) {
    this.name = name;
  }

  public double getArea() {
    throw new UnsupportedOperationException("Cannot invoke the method");
  }

  public String getName() {
    return name;
  }
}
