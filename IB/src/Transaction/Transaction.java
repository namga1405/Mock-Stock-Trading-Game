package Transaction;
import java.util.Random;
import java.util.Scanner;

public class Transaction {

	public static void main(String[] args) {
		double charge = 0.5;
		Scanner input = new Scanner(System.in);
		Random r1 = new Random();
		double balance = r1.nextInt(2000);
		System.out.println("Your balance is: " +balance);
		
		System.out.println("Enter your withdrawal amount, must be divisible by 5");
		double wd = input.nextDouble();
		while (wd <= 0) {
			System.out.println("Invalid withdrawal amount");
			System.out.println("Enter your withdrawal amount, must be divisible by 5");
			wd = input.nextInt();
		}
		if (wd%5 != 0 || wd > balance-0.5) {
			System.out.println("Your balance is now: $" +balance);
		}
		else {
			balance = balance - wd - charge;
			System.out.println("The transaction costs $0.5");
			System.out.println("Your balance is now: $" +balance);
		}
	}

}
