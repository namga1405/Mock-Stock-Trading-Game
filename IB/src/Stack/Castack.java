package Stack;
import java.util.*;

public class Castack {

	public static void main(String[] args) {
		int a1[] = {4,3,5,6,1,9};	
		Stack s1 = new Stack();
		for (int i = 0; i < 6; i++) {
			s1.push(a1[i]);
		}
		int count = 0;
		while(!s1.isEmpty()) {
			a1[count] = (int) s1.pop();
			count++;
		}
		for (int x = 0; x < 6; x++) {
			System.out.println(a1[x]);
		}
	}

}
