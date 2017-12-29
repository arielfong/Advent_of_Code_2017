import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day7 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input7.txt");
    Scanner keyboard = new Scanner(file);
    ArrayList<String> names = new ArrayList<String>();
    HashSet<String> towers = new HashSet<String>();
    while (keyboard.hasNextLine()) {
      String line = keyboard.nextLine();
      if (line.contains("->")) {
        String[] disks = line.split("[(>,]");
        for (int i = 0; i<disks.length; i++) {
          disks[i] = disks[i].trim();
          System.out.println(disks[i]);
        }
        names.add(disks[0]);
        for (int i = 2; i<disks.length; i++) {
          towers.add(disks[i]);
        }
      }
    }
    for (int i = 0; i<names.size(); i++) {
      if (!towers.contains(names.get(i))) {
        System.out.println(names.get(i));
      }
    }
  }
}
