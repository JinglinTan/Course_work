public class EquilateralTriangle extends Triangle{
  public EquilateralTriangle(double side){
    super(side, side, side);
  }

  public EquilateralTriangle(double side, String color, boolean filled){
    super(side, side, side, color, filled);
  }
}
