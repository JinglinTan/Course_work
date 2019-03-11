public class Client {
  public static void main(String[] args) {
    GenericStack<Integer> integerStack = new GenericStack<Integer>();
    integerStack.push(new Integer(3));
    integerStack.push(new Integer(4));
    integerStack.push(new Integer(5));

    integerStack.pop();
    integerStack.pop();
    integerStack.pop();

    GenericStack<Double> doubleStack = new GenericStack<Double>();
    doubleStack.push(new Double(3));
    doubleStack.push(new Double(4));
    doubleStack.push(new Double(5));

    doubleStack.pop();
    doubleStack.pop();
    doubleStack.pop();
  }
}
