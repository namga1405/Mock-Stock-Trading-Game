package Recurssion;
import java.util.Scanner;

public class Fibionacci {
	public static int fib(int n) {
		if (n <2) {
			return n;
		}
		else {
			return(fib(n-1) + fib(n-2));
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Choose a number:");
		Scanner kb = new Scanner(System.in);
		System.out.println(fib(kb.nextInt()));
	}
	
}
