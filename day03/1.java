import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
