public class EquilateralTriangle extends Triangle {
  private double side;

  public EquilateralTriangle(String name, double side) {
    super(name);
    this.side = side;
  }

  public double getArea() {
    return Math.sqrt(3) / 4 * side * side;
  }

  public boolean isEquilateral() {
    return true;
  }
}
