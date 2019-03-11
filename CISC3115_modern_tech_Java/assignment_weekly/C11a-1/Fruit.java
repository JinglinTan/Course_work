public class Fruit {
  private String name = "NameFruit";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }
}
