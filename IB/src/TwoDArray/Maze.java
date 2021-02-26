package TwoDArray;
import java.util.*;

public class Maze {	
	static Stack s1 = new Stack();
	//Check direction method
	public static int ChooseDirection(String direct) {
		String direction = direct.toUpperCase();
		
		while(!direction.equals("N")&&!direction.equals("S")&&!direction.equals("E")&&!direction.equals("W")&&!direction.equals("P")) {
			System.out.println("Invalid direction, please enter again");
			
			Scanner input = new Scanner (System.in);
			direction = input.nextLine();
			direction = direction.toUpperCase();
		}
		//Numerical value correspond to the direction
		if (direction.equals("N")) {
			return 0;
		}
		if (direction.equals("E")) {
			return 1;
		}
		if (direction.equals("W")) {
			return 2;
		}
		if (direction.equals("S")) {
			return 3;
		}
		else {
			return 4;
		}
	}
	//Check for wall
	public static boolean checkWall (int room, int direction, int[][] maze) {
		if (maze[room][direction] == -1) {
			return false;
		}
			return true;
	}
	
	
	public static void main(String[] args) {
		ArrayList<String> user = new ArrayList<String>();
		ArrayList<Integer> score = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);		
		
	//Play the damn game
		boolean play = true;
		
		while(play != false) {
		int room = 0;
		int tries = 0;
		boolean go = false;
		int[][] matrix = // N E W S
			{
				{-1,1,-1,-1},//0
				{-1,2,0,5},//1
				{-1,3,1,-1},//2
				{-1,-1,2,7},//3
				{-1,5,-1,8},//4
				{1,-1,4,-1},//5
				{-1,7,-1,-1},//6
				{3,-1,6,-1},//7
				{4,9,-1,12},//8
				{-1,-1,8,-1},//9
				{-1,11,-1,14},//10
				{-1,-1,10,15},//11
				{8,13,-1,-1},//12
				{-1,14,12,-1},//13
				{10,-1,13,-1},//14
				{-1,-1,-1,-1}//15
			};
		String narrative[] = new String[] {
				"You are tied up by Tri at the lobby\n"
				+ "run away because god knows what kind of stuff he can do to you",//0
				
				"You reach the computer science room\n"
				+ "but Tri is about to hit you with a computer",//1
				
				"You escape Tri and hide inside the toilet\n"
				+ "Nani?, he is already in the toilet, run",//2
						
				"You dash straight to the cateen, thank god you don't see Tri\n"
				+ "Sike, he's behind you, with a fork in his hand",//3
				
				"You slowly walk back to the common room and hide behind the forests\n"
				+ "Oh no, the predator has found you, run",//4
				
				"You are in the corridoor and you hear an echo\n"
				+ "WHY ARE YOU RUNNING, WHY ARE YOU RUNNING",//5
				
				"You are in art room, but Tri is also in art room",//6
				
				"You come into economics classroom\n"
				+ "Tri throws prior dollars at you like naruto",//7
				
				"You have been hit by a few dollars, but it's ok, you are at the nurse\n"
				+ "Oh no, the nurse is Tri, run",//8
				
				"You come to business classroom\n"
				+ "But Tri is also in there, ready to do some business with you",//9
				
				"You are in Math room\n"
				+ "Tri is sitting in the teacher seat, with a protractor to track you down",//10
				
				"You think you are safe in the science room ah\n"
				+ "Hay ya, Tri is in his labcoat, ready to do some experiment with you",//11
				
				"Library is big for you, but not for Tri\n"
				+ "He throws book at you like Ash throwing pokemon's ball",//12
				
				"You run to the theatre and hide behind one of the chairs\n"
				+ "But Tri finds you and about to perform to you his comedy sketch",//13
				
				"You are at the cafe\n"
				+ "Tri is sitting next to you, giving you tobacco and say it's time to get phe",//14
				
				"You have escaped Tri"//15
				
				
		};
	    System.out.println("            ESCAPE THE PREDATOR          ");
		System.out.println("-----------------------------------------");
		System.out.println(narrative[0]);
		while (room != 15) {
			System.out.println("Enter n,s,e,w to the respective direction and p to exit game");
			String direction = input.nextLine();
			if (direction.equals("undo")) {
				if (!s1.isEmpty()) {
					System.out.println("You have undo your move");
					tries++;
					room = (int) s1.pop();
					System.out.println(narrative[room]);
				} else {
					System.out.println("You cannot undo at this point");
				}
			} else {
			int way = ChooseDirection(direction);
			if (way == 4) {
				System.out.println("Thank you for playing the game");
				System.exit(0);
			} 
			else {
				go = checkWall(room,way,matrix);
			}
			
			if (go) {
				tries ++;
				s1.push(room);
				room = matrix[room][way];
				System.out.println(narrative[room]);
			} else {
			tries ++;
			System.out.println("You have hit a wall, and Tri is coming closer to you");
			}
		}
		}
		//Check high score
		System.out.println("You have done the maze in " + tries + " tries"); 
		System.out.println("Please enter your username");
		Scanner name = new Scanner(System.in);
		String username = name.nextLine();
		user.add(username);
		score.add(tries);
		
		
		
		System.out.println("Do you want to play again, y for yes, any letter for no");
		Scanner pick = new Scanner(System.in);
		String choose = pick.nextLine();
		choose = choose.toUpperCase();		
		if (!choose.equals("Y")) {
			play = false;
		}
		else {
			play = true;
		}
	}
		for(int i = 0; i < score.size(); i++) {
			System.out.println(score.get(i));
			System.out.println(user.get(i));
		}
		Integer[] finalscore = score.toArray(new Integer[0]);
		String[] finalname = user.toArray(new String[0]);
		int num = finalscore.length;
		for (int i = 0; i < num; i++) {
			for (int j = i + 1;j < num; j++) {
				if (finalscore[i] > finalscore[j]) {
					int temp = finalscore[i];
					String temp1 = finalname[i];
					
					finalscore[i] = finalscore[j];
					finalname[i] = finalname[j];
					
					finalscore[j] = temp;
					finalname[j] = temp1;
				}
			}
		}
		System.out.println("The player with the lowest number of tries is " +finalname[0]+ " with the score of " +finalscore[0]);
		System.out.println("Thank you for playing the game");
}
}

