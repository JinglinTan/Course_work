import java.util.Objects;

public class Fruit {
  private String name = "Fruit";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object theOther) {
    if(theOther instanceof Fruit) {
      return ((Fruit)theOther).getName().equals(name);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(name);
  }
}
