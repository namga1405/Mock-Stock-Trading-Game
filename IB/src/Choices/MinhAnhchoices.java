package Choices;

import java.util.Scanner;

public class MinhAnhchoices {
	public static void main(String[] args) {
		String options1[] = new String[] {"Summer","Winter"}; 
		String options2[] = new String[] {"Active Activity", "Relaxed Activity"}; 
		String options3[] = new String[] {"Free", "Paid"}; 
		String options4_1[] = new String[] {"Running", "Indoor Climbing"}; 
		String options4_2[] = new String[] {"Sit on the beach", "Yatch trip"}; 
		String options4_3[] = new String[] {"Build an Igloo", "Ski Lessons"};
		String options4_4[] = new String[] {"Read book by the fireplace", "Spa Retreat"};
		int step = 1;
		boolean initiate = true;
		String output = "";
		String result1 = "";
		String result2 = "";
		String result3 = "";
		String result4 = "";
		Scanner input = new Scanner(System.in);
		while(initiate == true) {
			if(step == 1) 
				System.out.println("[ ENTER 3 TO RETURN ]");
				System.out.println("SEASON?");
				for(int i = 0; i<2; i++) {
					output = options1[i];
					System.out.print("ENTER "); System.out.print(i+1); System.out.print(" FOR: "); System.out.println(output);
				}
				int choice = input.nextInt();
				if (choice == 3) {
					step = 1;
				}
				else if (choice == 1) {
					result1 = options1[0];
					step = step+1;
				}
				else if (choice == 2) {
					result1 = options1[1];
					step = step+1;
				}
			if(step == 2) {
				System.out.println("[ ENTER 3 TO RETURN ]");
				System.out.println("LAST CHOICE: " +result1);
				for(int i = 0; i<2; i++) {
					output = options2[i];
					System.out.print("ENTER "); System.out.print(i+1); System.out.print(" FOR: "); System.out.println(output);
				}
				choice = input.nextInt();
				if (choice == 1) {
					result2 = options2[0];
					step = step+1;
				}
				else if (choice == 2) {
					result2 = options2[1];
					step = step+1;
				}
				else if (choice == 3) {
					step = 1;
				}
			}	
			if(step == 3) {
				System.out.println("[ ENTER 3 TO RETURN ]");
				System.out.println("LAST CHOICE: " +result2);
				for(int i = 0; i<2; i++) {
					output = options3[i];
					System.out.print("ENTER "); System.out.print(i+1); System.out.print(" FOR: "); System.out.println(output);
				}
				choice = input.nextInt();
				if(choice == 1) {
					result3 = options3[0];
					if(result1 == options1[0]) {
						if(result2 == options2[0]) {
							result4 = options4_1[0];
						}
						else if(result2 == options2[1]) {
							result4 = options4_2[0];
						}
					}
					else if(result1 == options1[1]) {
						if(result2 == options2[0]) {
							result4 = options4_3[0];
						}
						else if(result2 == options2[1]) {
							result4 = options4_4[0];
						}
					}
					initiate = false;
				}
				else if(choice == 2) {
					result3 = options3[1];
					if(result1 == options1[0]) {
						if(result2 == options2[0]) {
							result4 = options4_1[1];
						}
						else if(result2 == options2[1]) {
							result4 = options4_2[1];
						}
					}
					else if(result1 == options1[1]) {
						if(result2 == options2[0]) {
							result4 = options4_3[1];
						}
						else if(result2 == options2[1]) {
							result4 = options4_4[1];
						}
					}
					initiate = false;
				}	
				else if (choice == 3) {
					step = 2;
				}
			}	
		}
		System.out.println("YOUR CHOICES: " +result1 +", " +result2 + ", " +result3); 
		System.out.println("RESULT: " +result4);
	}

}


