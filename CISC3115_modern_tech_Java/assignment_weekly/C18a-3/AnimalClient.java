import java.util.ArrayList;

public class AnimalClient {
  public static void main(String[] args) {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Feline> felines = new ArrayList<Feline>();

    animals.add(new Dove());
    animals.add(new Whale());
    animals.add(new Cat());
    animals.add(new Panther());

    felines.add(new Cat());
    felines.add(new Panther());

    animalMakeNoise(animals);
    felinesPounce(felines);
  }

  public static void animalMakeNoise(ArrayList<Animal> animals) {
    for(Animal a: animals) {
      a.makeNoise();
    }
  }

  public static void felinesPounce(ArrayList<Feline> felines) {
    for(Feline f: felines) {
      f.pounce();
    }
  }
}
