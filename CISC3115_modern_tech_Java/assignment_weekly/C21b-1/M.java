public class M {
  public static double m(double i) {
    if(i <= 1) return i;
    return m(i - 1) + 1/i;
  }
}
