package Grade;
import java.io.EOFException;
import java.util.Scanner;
public class StudentGrade {
	
	// Eliminate letters and decimals
	public boolean checkInt(String i) {
		try {
			Integer.parseInt(i);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
		
	}
	//Store grades method
	public int[] inpGrade(int[] Grade) {
		for (int i = 0; i < 10; i ++) {
			System.out.println("Enter the grade of student number " +  (i+1)  + " here: ");
			Scanner input = new Scanner(System.in);
			String students_grade = input.nextLine();
			
			//Using validation to eliminate all decimals and letters
			while (!checkInt(students_grade)) {
				System.out.println("Invalid grade, please enter the students grade here: ");
				students_grade = input.nextLine();
			}
			
			int studentgrade = Integer.parseInt(students_grade);
			
			while (studentgrade < 0 || studentgrade > 100) {
				System.out.println("Invalid grade, please enter the " + (i+1) + " students grade here: ");
				studentgrade = input.nextInt();
			}
			Grade[i] = studentgrade;
		}
		return Grade;
	}	
	
	//Set boundary methods
	public int[] inpboundaries(int[] Boundary) {
		Scanner input = new Scanner(System.in);
		String alphabet[] = new String[] {"A", "B", "C", "D", "E"};
		System.out.println("Enter the boundary for grade A: ");
		String boundary = input.nextLine();
		while (!checkInt(boundary)) {
			System.out.println("Invalid boundary, please enter the students grade here: ");
			boundary = input.nextLine();
		}
		int realboundary = Integer.parseInt(boundary);
		while (realboundary < 0 || realboundary > 100) {
			System.out.println("Invalid boundary, please enter the students grade here: ");
			realboundary = input.nextInt();
		}
		
		Boundary[0] = realboundary;
		for(int i = 1; i < 5; i++) {
			System.out.println("Enter the boundary for grade " + alphabet[i] + ": ");
				boundary = input.nextLine();
				
		while (!checkInt(boundary)) {
			System.out.println("Invalid boundary, please enter the students grade here: ");
			boundary = input.nextLine();
				}
		
			int intboundary = Integer.parseInt(boundary);
			while (intboundary < 0 || intboundary > 100 || intboundary >= Boundary[i-1]) {
				System.out.println("Invalid boundary, please enter the boundary for " + alphabet[i]+ ": ");
				intboundary = input.nextInt();
			}
			Boundary[i] = intboundary;
		}
		return Boundary;		
	}
	//Calculate the average
	public int calcAverage(int[] grades)
	{
		int total = 0;
		for(int i = 0; i < 10; i ++) {
			total = total + grades[i];
		}
		int average = total/10;
		return average;
	}
	
	
	//Set average
	public int average(int[] grades) {
		int total = 0;
		int avg = 0;
		//import calcAverage method into this method 
		int average = calcAverage(grades);
		for(int n = 0; n < 10; n++) {
			if (grades[n] == average) {
				avg ++;
			}
		}
		return avg;
	}
	
	//Set below average
	public int belowaverage(int[] grades) {
		int total = 0;
		int belowavg = 0;
		//import calcAverage method into this method 
		int average = calcAverage(grades);
		for(int n = 0; n < 10; n++) {
			if (grades[n] < average) {
				belowavg++;
			}
		}
		return belowavg;
	}
	
	//Set above average
	public int aboveaverage(int[] grades) {
		int total = 0;
		int aboveavg = 0;
		//import calcAverage method into this method 
		int average = calcAverage(grades);
		for(int n = 0; n < 10; n++) {
			if (grades[n] > average) {
				aboveavg++;
			}
		}
		return aboveavg;
	}
	
	//Compare grade to boundaries
	public int[] compare(int[] grades, int[] boundary) {
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int E = 0;
		int F = 0;
		for (int i = 0; i < 10; i++) {
				if (grades[i] >= boundary[0]) {
					A = A + 1;
				}
				if (grades[i] >= boundary[1] && grades[i] < boundary[0]) {
					B = B + 1;
				}	
				if (grades[i] >= boundary[2] && grades[i] < boundary[1]) {
					C = C + 1;
				}
				if (grades[i] >= boundary[3] && grades[i] < boundary[2]) {
					D = D + 1;
				}
				if (grades[i] >= boundary[4] && grades[i] < boundary[3]) {
					E = E + 1;
				}
				if (grades[i] < boundary[4]) {
					F = F + 1;
				}
		}
		int[] band = new int[] {A,B,C,D,E,F};
		return band;
	}
	
	
	public static void main(String[] args) 
	{
		//Input students grade and boundary
		StudentGrade o1 = new StudentGrade();
		
		int[] Grade = new int[10];
		//Using inpGrade method into Grade array
		Grade = o1.inpGrade(Grade);
		int[] Boundary = new int[5];
		//Using inpboundaries method into Boundary array
		Boundary = o1.inpboundaries(Boundary);
		//Using compare method into Band array
		int[] Band = o1.compare(Grade,Boundary);
		
		//Output average/above average/below average
		System.out.println("The average is: " + o1.calcAverage(Grade));
		System.out.println("Number of average students: " + o1.average(Grade));
		System.out.println("Number of above average students: " + o1.aboveaverage(Grade));
		System.out.println("Number of below average students: " + o1.belowaverage(Grade));
		String[] Alphabet = new String[] {"A", "B", "C", "D", "E", "F"};
		for (int i = 0; i < 6; i++) {
			System.out.println("Number of students that get " + Alphabet[i] + " is: " + Band[i]);
					
				}
			}
		}


	



	

