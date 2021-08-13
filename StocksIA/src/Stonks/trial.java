package Stonks;

import java.util.Scanner;

public class trial {

	public static void main(String[] args) {
		boolean boo = true;
		while (boo != false) {
		Scanner input = new Scanner(System.in);
		System.out.println("have a number");
		int num1 = input.nextInt();
		System.out.println("have another one");
		int num2 = input.nextInt();
		if (num2 > num1) {
			boo = false;
		}
		}
		System.out.println("Done");
	}

}
