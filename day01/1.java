import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input1.txt");
    Scanner keyboard = new Scanner(file);
    keyboard.useDelimiter("");
    ArrayList<Integer> input = new ArrayList<Integer>();
    while (keyboard.hasNext()) {
      input.add(keyboard.nextInt());
    }
    int sum = 0;
    for (int i = 0; i< input.size()-1; i++) {
      if (input.get(i) == input.get(i+1)) {
        sum += input.get(i);
      }
    }
    if (input.get(input.size()-1) == input.get(0)) {
      sum += input.get(0);
    }
    System.out.println(sum);
  }
}

