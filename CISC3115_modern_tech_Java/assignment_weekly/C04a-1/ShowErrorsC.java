class ShowErrors {
  public static void main(String[] args){
    method1();
  }

  public static void method1(){
    Circle c = new Circle();
    System.out.println("What is radius " + c.getRadius());
  }

  static class Circle {
    private int radius = 4;

    public int getRadius(){
      return radius;
    }
  }
}
