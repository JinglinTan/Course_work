import java.util.Objects;

public class Apple extends Fruit{
  private String name = "Apple";

  public String toString() {
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getApplePieRecipe() {
      return "ApplePieRecipe";
  }

  public String getName() {
    return name;
  }

  public boolean equals(Object theOther) {
    if(theOther instanceof Apple) {
      return name.equals(((Apple)theOther).getName());
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(name);
  }
}
