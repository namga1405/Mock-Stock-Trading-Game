package Stack;
import java.util.*;

public class Minigame {
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter move:");
	String move = input.nextLine();
	Stack s1 = new Stack();
	while (!move.equals("quit")) {
		if (!move.equals("undo")) {
			s1.push(move);
		} else {
			if(s1.isEmpty()) {
				System.out.println("Stack is empty");
			}
			else {
				System.out.println(s1.pop());
			}
		}
		System.out.println("Enter move:");
		move = input.nextLine();
	}
	if (!s1.isEmpty()) {
		while (!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
	} else {
		System.out.println("There is non left in stack");
	}
	System.out.println("End");
	}
}
