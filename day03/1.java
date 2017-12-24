import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* Advent of Code 2017, Day 1
 * Each square on the grid is allocated in a spiral pattern starting at a location marked 1 
 * and then counting up while spiraling outward. For example, the first few squares are allocated like this:
 * 17  16  15  14  13
 * 18   5   4   3  12
 * 19   6   1   2  11
 * 20   7   8   9  10
 * 21  22  23---> ...
 * How many steps are required to carry the data from the square identified in your puzzle input all the way to the access port? 
 * Calculate the Manhattan Distance between the location of the data and square 1.
 * 
 * As a stress test on the system, the programs here clear the grid and then store the value 1 in square 1. 
 * Then, in the same allocation order as shown above, they store the sum of the values in all adjacent squares, including diagonals.
 * So, the first few squares' values are chosen as follows:
 * 147  142  133  122   59
 * 304    5    4    2   57
 * 330   10    1    1   54
 * 351   11   23   25   26
 * 362  747  806--->   ...
 * What is the first value written that is larger than your puzzle input?
 */

public class Day3 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input3.txt");
		Scanner keyboard = new Scanner(file);
		int input = keyboard.nextInt();
		int matrixLength = (int)Math.sqrt(input);
		int manhattanDistance = matrixLength/2;
		int extra = input - (matrixLength*matrixLength);
		int newMatrixLength = matrixLength + 2;
		
		if (extra < newMatrixLength) {
			manhattanDistance += Math.abs(matrixLength/2 - extra);
		}
		else if (extra < newMatrixLength * 2) {
			manhattanDistance += Math.abs(matrixLength/2 - extra - newMatrixLength);
		}
		else if (extra < newMatrixLength * 3) {
			manhattanDistance = manhattanDistance += Math.abs(matrixLength/2 - extra - newMatrixLength*2);
		}
		else {
			manhattanDistance = manhattanDistance += Math.abs(matrixLength/2 - extra - newMatrixLength*3);
		}
		System.out.println(manhattanDistance);
	}
}
