package CircularQueue;

import java.lang.reflect.Array;
import java.util.*;

public class Circular {
	int nums[];
	int count = 0;
	int t = 0;
	int h = 0;
	Scanner input = new Scanner(System.in);
public static void main(String[] args) {
		Circular demo = new Circular();
	}

public Circular() {
	nums = new int[20];
	add(50);
	add(60);
	add(20);
	add(40);
	add(60);
	add(69);
	add(70);
	remove();
	for (int i = 0; i < nums.length; i++) {
		System.out.println(nums[i]);
	}
}

public void add(int data) {
	if (count == nums.length) {
		System.out.println("Full");
	}
	else {
		nums[t] = data;
		t = (t+1)%nums.length;
		count++;
	}
}

public int remove() {
	if (count == 0) {
		System.out.println("Empty");
		int empty = -1;
		return empty;
	}
	else {
		int empty = nums[h];
		nums[h] = 0;
		h = (h+1)%nums.length;
		count--;
		return empty;
	}
}

}
