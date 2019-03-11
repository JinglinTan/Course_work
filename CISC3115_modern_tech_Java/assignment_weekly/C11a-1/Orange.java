public class Orange extends Fruit{
  private String name = "NameOrange";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }

  public String getOrangeJuiceRecipe() {
      return "OrangeJuiceRecipe";
  }
}
