import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/* Advent of Code 2017, Day 1
 * For each row, determine the difference between the largest value and the smallest value; 
 * the checksum is the sum of all of these differences.
 * 
 * Now, it sounds like the goal is to find the only two numbers in each row where one 
 * evenly divides the other - that is, where the result of the division operation is a whole number. 
 * They would like you to find those numbers on each line, divide them, and add up each line's result.
 */

public class Day2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input2.txt");
		Scanner keyboard = new Scanner(file);
		int checksum = 0;
		while (keyboard.hasNextLine()) {
			String[] nums = (keyboard.nextLine()).split("\\s+");
			int[] intNums = new int[nums.length];
			for (int i = 0; i < intNums.length; i++) {
				intNums[i] = Integer.parseInt(nums[i]);
			}
			outerloop:
			for (int i = 0; i < intNums.length; i++) {
				for (int j = i+1; j < intNums.length; j++) {
					if (intNums[i] > intNums[j]) {
						if (intNums[i]%intNums[j] == 0) {
							checksum += intNums[i]/intNums[j];
							break outerloop;
						}
					}
					else {
						if (intNums[j]%intNums[i] == 0) {
							checksum += intNums[j]/intNums[i];
							break outerloop;
						}
					}
				}
			}
		}
		System.out.println(checksum);
	}
}
