import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input5.txt");
    Scanner keyboard = new Scanner(file);
    ArrayList<Integer> jumps = new ArrayList<Integer>();
    while (keyboard.hasNext()) {
      jumps.add(keyboard.nextInt());
    }
    int index = 0;
    int newIndex;
    int steps = 0;
    boolean stillStepping = true;
    while (stillStepping) {
      if (index<0 || index>=jumps.size()) {
        stillStepping = false;
      }
      else {
        newIndex = jumps.get(index);
        if (newIndex >= 3) {
          jumps.set(index, newIndex-1);
        }
        else {
          jumps.set(index, newIndex+1);
        }
        index = index + newIndex;
        steps++;
      }
    }
    System.out.println(steps);
  }
}
