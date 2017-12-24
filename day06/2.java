import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/* Advent of Code 2017, Day 6
 * In this area, there are sixteen memory banks; each memory bank can hold any number of blocks. 
 * The goal of the reallocation routine is to balance the blocks between the memory banks.
 * The reallocation routine operates in cycles. In each cycle, it finds the memory bank with the most
 * blocks (ties won by the lowest-numbered memory bank) and redistributes those blocks among the banks. 
 * To do this, it removes all of the blocks from the selected bank, then moves to the next (by index) 
 * memory bank and inserts one of the blocks. It continues doing this until it runs out of blocks; 
 * if it reaches the last memory bank, it wraps around to the first one.
 * The debugger would like to know how many redistributions can be done before a 
 * blocks-in-banks configuration is produced that has been seen before.
 * Given the initial block counts in your puzzle input, how many redistribution cycles 
 * must be completed before a configuration is produced that has been seen before?
 * 
 * Out of curiosity, the debugger would also like to know the size of the loop: 
 * starting from a state that has already been seen, how many block redistribution 
 * cycles must be performed before that same state is seen again?
 */
 
public class Day6 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input6.txt");
		Scanner keyboard = new Scanner(file);
		String[] temp = (keyboard.nextLine()).split("\\s+");
		ArrayList<Integer> blocks = new ArrayList<Integer>();
		ArrayList<Integer> initialConfig = new ArrayList<Integer>();
		for (int i = 0; i<temp.length; i++) {
			blocks.add(Integer.parseInt(temp[i]));
			initialConfig.add(Integer.parseInt(temp[i]));
		}
		HashSet<ArrayList<Integer>> configs = new HashSet<ArrayList<Integer>>();
		int cycles = 0;
		int maxIndex = -1;
		int maxValue;
		while (!configs.contains(blocks)) {
			configs.add(blocks);
			cycles++;
			maxValue = Integer.MIN_VALUE;
			for (int i = 0; i<blocks.size(); i++) {
				if (blocks.get(i) > maxValue) {
					maxIndex = i;
					maxValue = blocks.get(i);
				}
			}
			blocks.set(maxIndex, 0);
			while (maxValue > 0) {
				maxIndex++;
				maxValue--;
				if (maxIndex >= blocks.size()) {
					maxIndex = 0;
				}
				blocks.set(maxIndex, blocks.get(maxIndex)+1);
			}
		}
		int numCycles = cycles;
		cycles = 0;
		ArrayList<Integer> finalConfigCycle = blocks;
		configs.clear();
		configs.add(finalConfigCycle);
		blocks = initialConfig;
		while (!configs.contains(blocks)) {
			configs.add(blocks);
			cycles++;
			maxValue = Integer.MIN_VALUE;
			for (int i = 0; i<blocks.size(); i++) {
				if (blocks.get(i) > maxValue) {
					maxIndex = i;
					maxValue = blocks.get(i);
				}
			}
			blocks.set(maxIndex, 0);
			while (maxValue > 0) {
				maxIndex++;
				maxValue--;
				if (maxIndex >= blocks.size()) {
					maxIndex = 0;
				}
				blocks.set(maxIndex, blocks.get(maxIndex)+1);
			}
		}
		System.out.println(numCycles-cycles);
	}
}
