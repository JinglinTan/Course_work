public class CountCharacter {
  public static int c(String str, String c, int i, int count) {
    if(i == str.length()) return count;
    if(str.substring(i, i + 1).equals(c)) count++;
    i++;
    return c(str, c, i, count);
  }
}
