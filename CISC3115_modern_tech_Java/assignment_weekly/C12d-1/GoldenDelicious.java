import java.util.Objects;

final public class GoldenDelicious extends Apple{
  private String name = "GoldenDelicious";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object theOther) {
    if(theOther instanceof GoldenDelicious) {
      return name.equals(((GoldenDelicious)theOther).getName());
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(name);
  }
}
