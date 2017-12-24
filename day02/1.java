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
		int high;
		int low;
		while (keyboard.hasNextLine()) {
			String[] nums = (keyboard.nextLine()).split("\\s+");
			int[] intNums = new int[nums.length];
			for (int i = 0; i < intNums.length; i++) {
				intNums[i] = Integer.parseInt(nums[i]);
			}
			Arrays.sort(intNums);
			high = intNums[intNums.length-1];
			low = intNums[0];
			checksum += high-low;
		}
		System.out.println(checksum);
	}
}
