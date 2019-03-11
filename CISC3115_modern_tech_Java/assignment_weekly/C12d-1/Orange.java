import java.util.Objects;

public class Orange extends Fruit{
  private String name = "Orange";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getOrangeJuiceRecipe() {
      return "OrangeJuiceRecipe";
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object theOther) {
    if(theOther instanceof Orange) {
      return name.equals(((Orange)theOther).getName());
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(name);
  }
}
