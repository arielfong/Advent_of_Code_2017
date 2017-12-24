import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
/* Advent of Code 2017, Day 1
 * A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. 
 * A passphrase consists of a series of words (lowercase letters) separated by spaces.
 * To ensure security, a valid passphrase must contain no duplicate words.
 * How many passphrases are valid?
 * 
 * For added security, yet another system policy has been put in place. 
 * Now, a valid passphrase must contain no two words that are anagrams 
 * of each other - that is, a passphrase is invalid if any word's letters 
 * can be rearranged to form any other word in the passphrase.
 * Under this new system policy, how many passphrases are valid?
 */

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
