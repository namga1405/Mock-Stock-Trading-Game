package Recurssion;
import java.util.Scanner;

public class Factorial {
	public static int fac(int n) {
		int result = n;
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return result;
		}
		else {
			return (fac(n-1)*result);
		}
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose a number");
		System.out.println(fac(input.nextInt()));
		
	}
	
}
