public class Apple extends Fruit{
  private String name = "NameApple";

  public String toString() {
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getApplePieRecipe() {
      return "ApplePieRecipe";
  }
}
