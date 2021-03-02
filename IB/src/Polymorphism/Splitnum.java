package Polymorphism;
import java.util.Scanner;

public class Splitnum {
		String num;
		int sum;
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("The number of time you want it to loop");
			String number = input.nextLine();
			while(!checkInt(number) || Integer.valueOf(number) < 1 || Integer.valueOf(number) > 1000) {
			if(number.equals("")) {
				System.out.println("This will be run 5 times: ");
				Splitnum s1 = new Splitnum();
				break;
			}
			else {
				System.out.println("Invalid number of tries, enter again: ");
				number = input.nextLine();
				}
			}
			Splitnum s1 = new Splitnum(Integer.parseInt(number));
			System.out.println("System ended");
			}
		
	public Splitnum() {
		for (int i = 0; i < 5; i++) {
			calculation();
		}
	}

	public Splitnum(int x) {
		for (int i = 0; i < x; i++) {
			calculation();
		}
	}	

	public int calculation() {
		Scanner input = new Scanner(System.in);
		System.out.println("Your desired number: ");
		num = input.nextLine();
		while (Integer.parseInt(num) > 1000000 || Integer.parseInt(num) < 1) {
			System.out.println("Invalid number, enter again: ");
			num = input.nextLine();
		}
		String[] intarray = num.split("");
		int len = num.length();
		sum = Integer.valueOf(intarray[0]) + Integer.valueOf(intarray[len-1]);
		System.out.println("The value of the first and last digits is " + sum);
		return sum;
	}

	public static boolean checkInt(String i) {
		try {
			Integer.parseInt(i);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
		
	}
	}
