class ShowErrors {
  public static void main(String[] args) {
    C c = new C(5.0);
    System.out.println(c.value);
  }

  static class C {
    double value = 2;

    C(double n) {
      value = n;
    }
  }
}
