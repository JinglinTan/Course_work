import java.util.ArrayList;

class FruitClient {
  public static void main(String[] args) {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    fruits.add(new Fruit());
    fruits.add(new Apple());
    fruits.add(new Orange());
    fruits.add(new GoldenDelicious());
    fruits.add(new McIntosh());
    fruits.add(new Apple());

    for(Fruit f: fruits) {
      System.out.println(f);
    }

    System.out.println("Apple == Fruit? " + fruits.get(1).equals(fruits.get(0)));
    System.out.println("Apple == Apple? " + fruits.get(1).equals(fruits.get(5)));
  }
}
