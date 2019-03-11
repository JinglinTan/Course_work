import java.util.Objects;

final public class McIntosh extends Apple{
  private String name = "McIntosh";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object theOther) {
    if(theOther instanceof McIntosh) {
      return ((McIntosh)theOther).getName().equals(name);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(name);
  }
}
