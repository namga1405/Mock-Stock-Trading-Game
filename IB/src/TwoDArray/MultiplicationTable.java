package TwoDArray;
import java.util.Scanner;
public class MultiplicationTable {

		public static void main(String[] agrs) {
			int [][] multiply = new int[10][10];
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					multiply[x][y] = x*y;
				}
			}
			Scanner input = new Scanner(System.in);
			System.out.println("1st number please");
			int num1 = input.nextInt();
			System.out.println("2nd number please");
			int num2 = input.nextInt();
			System.out.println("The product of 2 numbers is " +multiply[num1][num2]);
		}
	}

