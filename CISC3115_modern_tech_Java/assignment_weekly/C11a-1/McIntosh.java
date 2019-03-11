public class McIntosh extends Apple{
  private String name = "NameMcIntosh";

  public String toString(){
    return this.getClass().getSimpleName() + " " + name;
  }
}
