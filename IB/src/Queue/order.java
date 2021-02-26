package Queue;
import java.util.*;

public class order {
	Queue order;
	Scanner input;
	
public static void main(String[] args) {
	order o1 = new order();
}
public order() {
	order = new LinkedList<String>();
	input = new Scanner(System.in);
	System.out.println("Welcome to BIS Pizza");
	int choice = 0;
	while (choice != 4) {
		System.out.println("Current order total: "+order.size());
		System.out.println("1. Place order");
		System.out.println("2. View next order");
		System.out.println("3: Complete order");
		System.out.println("4. Exit system");
		System.out.println(">> ");
		choice = validChoice(1,4);
		if (choice == 1) {
			addOrder();
		}
		if (choice == 2) {
			System.out.println(viewOrder());
		}
		if (choice == 3) {
			System.out.println(completeOrder());
		}
	}
}
	public int validChoice(int min, int max) {
		input = new Scanner(System.in);
		int c = input.nextInt();
		while (c < min || c > max) {
			System.out.println("No");
			c = input.nextInt();
		}
		return c;
	}
	
	public String validSize(String s, String m , String l) {
		input = new Scanner(System.in);
		String a = input.nextLine();
		a = a.toUpperCase();
		while (!a.equals(s)&&!a.equals(m)&&!a.equals(l)) {
			System.out.println("No");
			a = input.nextLine().toUpperCase();
		}
		return a;
	}
	
	public void addOrder() {
		System.out.println("Choose your size: S,M,L");
		String size = validSize("S","M","L");
		System.out.println("Choose your topping: ");
		String topping = input.nextLine();
		String call = size + " " + topping;
		order.add(call);
	}
	public Object viewOrder() {
		if (!order.isEmpty()) {
			return order.peek();
		}
		else {
			return "Nothing left in order";
		}
	}
	public Object completeOrder() {
		if (!order.isEmpty()) {
			return "The order " + order.remove() + " is completed";
		}
		else {
			return "Nothing left in order";
		}	
	}
	
	
}
