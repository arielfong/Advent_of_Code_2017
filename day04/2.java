import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
  public static boolean isAnagram(String a, String b) {
    if (a.length() == b.length()) {
      for (int i = 0; i < a.length(); i++) {
        if (b.contains("" + a.charAt(i))) {
          b = b.replaceFirst("" + a.charAt(i), " ");
        }
        else {
          return false;
        }
      }
      return true;
    }
    else {
      return false;
    }
  }
	
  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input4.txt");
    Scanner keyboard = new Scanner(file);
    String[] passphrase;
    int valid = 0;
    boolean noAnagrams = true;
    while (keyboard.hasNextLine()) {
      passphrase = (keyboard.nextLine()).split("\\s+");
      outerloop:
      for (int i = 0; i<passphrase.length-1; i++) {
        for (int j = i+1; j<passphrase.length; j++) {
          if (isAnagram(passphrase[i], passphrase[j])) {
            noAnagrams = false;
            break outerloop;
          }
        }
      }
      if (noAnagrams) {
        valid++;
      }
      noAnagrams = true;
    }
    System.out.println(valid);
  }
}
