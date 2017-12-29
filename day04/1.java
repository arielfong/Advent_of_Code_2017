import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day4 {
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input4.txt");
    Scanner keyboard = new Scanner(file);
    String[] passphrase;
    int valid = 0;
    HashSet<String> words = new HashSet<String>();
    while (keyboard.hasNextLine()) {
      passphrase = (keyboard.nextLine()).split("\\s+");
      for (int i=0; i<passphrase.length; i++) {
        words.add(passphrase[i]);
      }
      if (words.size() == passphrase.length) {
        valid++;
      }
      words.clear();
    }
    System.out.println(valid);
  }
}
