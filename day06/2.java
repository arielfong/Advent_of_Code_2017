import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

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

