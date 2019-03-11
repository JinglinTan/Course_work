public class TriangleClient{
  public static void main(String[] args){
    Triangle triangle1 = new Triangle(3, 4, 5);
    Triangle triangle2 = new Triangle(3, 4, 5, "green", true);

    triangle1.printTriangle();
    triangle2.printTriangle();

    EquilateralTriangle triangle3 = new EquilateralTriangle(7);
    EquilateralTriangle triangle4 = new EquilateralTriangle(7, "blue", true);

    triangle3.printTriangle();
    triangle4.printTriangle();
  }
}
