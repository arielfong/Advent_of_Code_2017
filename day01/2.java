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
    int halfSize = input.size()/2;
    for (int i = 0; i< halfSize; i++) {
      if (input.get(i) == input.get(i+halfSize)) {
        sum += input.get(i);
      }
    }
    int counter = 0;
    for (int i = halfSize; i< input.size(); i++) {
      if (input.get(i) == input.get(counter)) {
        sum += input.get(i);
      }
      counter++;
    }
    System.out.println(sum);
  }
}
