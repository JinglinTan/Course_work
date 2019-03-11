import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ExerciseC17a2 {
  public static void main(String[] args) {
    if(args.length != 2) {
      System.out.println("Usage: java ExerciseC17a2 replaceText sourceFile");
      System.exit(1);
    }

    Scanner input = null;
    PrintWriter output = null;

    try {
      input = new Scanner(new File(args[1]));
      ArrayList<String> text = new ArrayList<String>();
      while(input.hasNext()) {
        String str = input.nextLine();
        str = str.replaceAll(args[0], "");
        text.add(str);
      }
      output = new PrintWriter(new File(args[1]));
      for(String s: text) {
        output.println(s);
      }
    } catch (IOException e) {
        System.out.println("There is an IOException");
    } finally {
        if(input != null) input.close();
        if(output != null) output.close();
    }
  }
}
