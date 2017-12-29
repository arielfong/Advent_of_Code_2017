import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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
