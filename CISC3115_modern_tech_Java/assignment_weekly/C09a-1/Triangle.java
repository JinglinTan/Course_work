public class Triangle extends GeometricObject{
  private double side1;
  private double side2;
  private double side3;

  public Triangle(double side1, double side2, double side3){
    if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
      this.side1 = side1;
      this.side2 = side2;
      this.side3 = side3;
    }else{
      System.out.println("This triangle is invalid");
      System.exit(1);
    }
  }

  public Triangle(double side1, double side2, double side3, String color, boolean filled){
    super(color, filled);
    if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1){
      this.side1 = side1;
      this.side2 = side2;
      this.side3 = side3;
    }else{
      System.out.println("This triangle is invalid");
      System.exit(1);
    }
  }

  public double getSide1(){
    return side1;
  }

  public void setSide1(double side1){
    this.side1 = side1;
  }

  public double getSide2(){
    return side2;
  }

  public void setSide2(double side2){
    this.side2 = side2;
  }

  public double getSide3(){
    return side3;
  }

  public void setSide3(double side3){
    this.side3 = side3;
  }

  public double getArea() {
    double p = (side1 + side2 + side3)/2.0;
    return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
  }

  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  public void printTriangle() {
    System.out.print("The circle is created " + super.getDateCreated() +
      " and the area is " + getArea() + ", and the perimeter is " + getPerimeter());
    if(isFilled() == true){
      System.out.println(" , and the color is " + getColor());
    }else{
      System.out.println();
    }
  }
}
