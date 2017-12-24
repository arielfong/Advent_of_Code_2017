import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/* Advent of Code 2017, Day 5
 * An urgent interrupt arrives from the CPU: it's trapped in a maze of jump instructions, 
 * and it would like assistance from any programs with spare cycles to help find the exit.
 * The message includes a list of the offsets for each jump. Jumps are relative: -1 moves
 * to the previous instruction, and 2 skips the next one. Start at the first instruction 
 * in the list. The goal is to follow the jumps until one leads outside the list.
 * In addition, these instructions are a little strange; after each jump, the offset of 
 * that instruction increases by 1. So, if you come across an offset of 3, you would move 
 * three instructions forward, but change it to a 4 for the next time it is encountered.
 * Positive jumps ("forward") move downward; negative jumps move upward.
 * How many steps does it take to reach the exit?
 * 
 * Now, the jumps are even stranger: after each jump, if the offset was three or more, 
 * instead decrease it by 1. Otherwise, increase it by 1 as before.
 * How many steps does it now take to reach the exit?
 */

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
