import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
