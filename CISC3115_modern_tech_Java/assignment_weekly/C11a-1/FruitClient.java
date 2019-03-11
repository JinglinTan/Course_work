class FruitClient {
  public static void main(String[] args) {

    //1)polymorphisms demo
    Fruit apple = new Apple(); //Fruit is super type to Apple
    Fruit orange = new Orange(); //Fruit is super type to Orange
    Fruit golden = new GoldenDelicious(); //Fruit is higher in hierarchy chain than GoldenDelicious
    Fruit mcIntosh = new McIntosh(); //Fruit is higher in hierarchy chain than McIntosh
    Apple golden2 = new GoldenDelicious(); //Apple is super type to GoldenDelicious
    Apple mcIntosh2 = new McIntosh(); //Apple is super type to mcIntosh


    //2)dynamic binding
    System.out.println(apple.toString()); //this prints out the class name of Apple and its "name" data field,
                                          //not the class name of Fruit and its "name" because JVM search
                                          //the method toString() from the actual class Apple

    System.out.println(mcIntosh.toString()); //this prints out the class name of McIntosh and its "name" data field,
                                             //not the class name of Fruit or Apple and its "name" because JVM search
                                             //the method toString() from the actual class McIntosh


    //3)down-casting and up-casting
    //down-casting
    if(apple instanceof Apple){   //check if Apple is apple's actual type or a superclass of apple's actual type
      System.out.println(((Apple)apple).getApplePieRecipe()); //if true, cast Apple type to apple, it's down-casting
                                                              //since apple's declared type is Fruit, which is a 
                                                              //superclass of Apple. Now, apple has access to
                                                              //getApplePieRecipe() that is unnique to class Apple
    }

    //up-casting
    McIntosh mi = new McIntosh(); //create a McIntosh object
    System.out.println(((Fruit)mi).toString()); //cast Fruit type to mi(McIntosh object), it's up-casting since
                                                //mi's declared type is McIntosh, lower in hierarchy chain than
                                                //Fruit
  }
}
