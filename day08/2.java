import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/* Advent of Code 2017, Day 8
 * Each instruction consists of several parts: the register to modify, 
 * whether to increase or decrease that register's value, the amount by 
 * which to increase or decrease it, and a condition. If the condition fails, 
 * skip the instruction without modifying the register. The registers all start at 0. 
 * What is the largest value in any register after completing the instructions in your puzzle input?
 * 
 * To be safe, the CPU also needs to know the highest value held in any register during this process 
 * so that it can decide how much memory to allocate to these operations. For example, in the above 
 * instructions, the highest value ever held was 10 (in register c after the third instruction was evaluated).
 */

public class Day8 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input8.txt");
		Scanner keyboard = new Scanner(file);
		HashMap<String, Integer> registers = new HashMap<String, Integer>();
		String[] insn;
		int max = Integer.MIN_VALUE;
		while(keyboard.hasNextLine()) {
			insn = keyboard.nextLine().split("\\s+");
			if (!registers.containsKey(insn[0])) {
				registers.put(insn[0], 0);
			}
			if (!registers.containsKey(insn[4])) {
				registers.put(insn[4], 0);
			}
			switch (insn[5]) {
			case "<" :
				if (registers.get(insn[4]) < Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
						break;
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
						break;
					}
				}
				break;
			case ">" :
				if (registers.get(insn[4]) > Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
						break;
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
						break;
					}
				}
				break;
			case "<=" :
				if (registers.get(insn[4]) <= Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
						break;
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
						break;
					}
				}
				break;
			case ">=" :
				if (registers.get(insn[4]) >= Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
						break;
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
						break;
					}
				}
				break;
			case "==" :
				if (registers.get(insn[4]) == Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
						break;
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
						break;
					}
				}
				break;
			case "!=" :
				if (registers.get(insn[4]) != Integer.parseInt(insn[6])) { 
					if (insn[1].equals("inc")) {
						registers.put(insn[0], registers.get(insn[0]) + Integer.parseInt(insn[2]));
					}
					else {
						registers.put(insn[0], registers.get(insn[0]) - Integer.parseInt(insn[2]));
					}
				}
			}
			if (registers.get(insn[0]) > max) {
				max = registers.get(insn[0]);
			}
		}
		for (String s : registers.keySet()) {
			if (registers.get(s) > max) {
				max = registers.get(s);
			}
		}
		System.out.println(max);
	}
}
