import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
/* Advent of Code 2017, Day 7
 * Wandering further through the circuits of the computer, you come upon a tower of 
 * programs that have gotten themselves into a bit of trouble. A recursive algorithm 
 * has gotten out of hand, and now they're balanced precariously in a large tower.
 * One program at the bottom supports the entire tower. It's holding a large disc, 
 * and on the disc are balanced several more sub-towers. At the bottom of these sub-towers, 
 * standing on the bottom disc, are other programs, each holding their own disc, and so on. 
 * At the very tops of these sub-sub-sub-...-towers, many programs stand simply keeping the 
 * disc below them balanced but with no disc of their own.
 * You offer to help, but first you need to understand the structure of these towers. 
 * You ask each program to yell out their name, their weight, and (if they're holding a disc) 
 * the names of the programs immediately above them balancing on that disc. You write this 
 * information down (your puzzle input). Unfortunately, in their panic, they don't do this in 
 * an orderly fashion; by the time you're done, you're not sure which program gave which information.
 * What is the name of the bottom program?
 * 
 * Apparently, one program has the wrong weight, and until it's fixed, they're stuck here.
 * For any program holding a disc, each program standing on that disc forms a sub-tower. 
 * Each of those sub-towers are supposed to be the same weight, or the disc itself isn't balanced. 
 * The weight of a tower is the sum of the weights of the programs in that tower.
 * Given that exactly one program is the wrong weight, what would its weight need to be to balance the entire tower?
 */

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
