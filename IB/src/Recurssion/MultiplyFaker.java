package Recurssion;
import java.util.Scanner;

public class MultiplyFaker {
	public static int multiplication(int a, int b) {
		if (a == 0 || b == 0) {
			return 0; // A number times 0 will equal 0
		}
		if (b == -1) {
			return -a; // A number times -1 will equal the inverse of that number
		}
		if (b == 1) {
			return a; // A number times 1 will equal itself
		}
		if (b < 0) {
			a = -a;
			b = -b;
			return a+multiplication(a, b-1); // Since the number of a in (a + a + a + a...) cannot be negative, therefore b cannot be negative. 
			//However, with knowing that a*-b = -a*b, we will invert the number into its negative form, making b positive so the logic still works
		}
		else {
			return a+multiplication(a, b-1); //It will be a + (a + a + a + a...) where the number of a in (a + a + a + a...) is b-1 
		}	
		
	}
	public static void main(String[] args) {
		System.out.println("Choose 2 numbers");
		Scanner input = new Scanner(System.in);
		int int1 = input.nextInt();
		Scanner input2 = new Scanner(System.in);
		int int2 = input2.nextInt();
		System.out.println("The product of these two numbers is " + multiplication(int1,int2));
	}
}
