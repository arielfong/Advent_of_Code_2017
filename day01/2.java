import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/* Advent of Code 2017, Day 1
 * The captcha requires you to review a sequence of digits (your puzzle input) and 
 * find the sum of all digits that match the next digit in the list. 
 * The list is circular, so the digit after the last digit is the first digit in the list.
 * For example:
 * 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
 * 1111 produces 4 because each digit (all 1) matches the next.
 * 1234 produces 0 because no digit matches the next.
 * 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
 * 
 * Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. 
 * That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. 
 * Fortunately, your list has an even number of elements.
 */

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
