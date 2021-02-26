package BinarySearch;
import java.util.Scanner;



public class Search {
		
	public Search(int target) {
		int[] a = {1, 212, 16, 67, 42, 53, 23, 14, 93, 537};
		//Set the minimum and maximum and found position
		int min = 0;
		int max = a.length - 1;
		int foundat = -1;
		//While the item hasn't been found
		while(foundat == -1 && min<=max) {
			int mid = (min+max)/2;
			//If search item at midpoint
			if(a[mid] == target) {
				foundat = mid;
			}
			//If search item > midpoint
			else if (target>a[mid]) {
				//Update midpoint
				min = mid+1;
			}
			//If search item < midpoint
			else {
				//Update midpoint
				max = mid-1;
			}
		}
		//If item is found
		if (foundat>=0) {
			System.out.println("Position is: " + foundat);
		}
		//If item is not found
		else {
			System.out.println("Item not found");
		}
}
	public static void main(String[] args) {
		//Enter the item that wanted to be found
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number you would like to find: ");
		int num = input.nextInt();
		//Constructor class
		Search s1 = new Search(num);
	}
	
}