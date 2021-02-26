package FileRead;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Golf {
	 ArrayList<String> names = new ArrayList<String>(50);
	 ArrayList<String> password = new ArrayList<String>(50);
	 ArrayList<String> category = new ArrayList<String>(50);
	 int noJunior;
	 int noAdult;
	 int noSenior;
	 int noMember;
	 boolean end = false;
	 boolean check;
	 Scanner input = new Scanner(System.in);

	

	public Golf() {
		try {
			File Obj = new File("/Users/Macos/Desktop/IB/Computer Science/Golf/members.txt");
			Scanner read = new Scanner(Obj);
			while(read.hasNextLine()) {
				String data = read.nextLine();
				names.add(data.split(",")[0] + " " + data.split(",")[1]);
				category.add(data.split(",")[2]);
				password.add(data.split(",")[3]);
			}
			read.close();
		} catch (Exception e) {
			System.out.println("File error");
			e.printStackTrace();
		}
		
		
		System.out.println(" --------------- CURRENT MEMBERS ---------------"); 
		for (int i = 0; i < password.size(); i++) {
			String pass = password.get(i);
			check = checkPass(pass);
			while (check == false) {
				System.out.println("Password for " + names.get(i) + " is invalid");
				System.out.print("Please re-enter your password: ");
				pass = input.nextLine();
			}
			//Inserting the new password into the same position
			password.set(i, pass);
		}
		System.out.println("Nothing needed to add");
		System.out.println(" ");
	
		
		
		
		while (end == false) {
			System.out.println("--------------- NEW MEMBERS ---------------");
			System.out.println(">>>>> WELCOME TO TEETASTIC GOLF CLUB <<<<<");
			System.out.print(">> Please enter your first name: ");
			String first = input.nextLine();
			check = checkString(first);
			while (check == false) {
				System.out.print("Invalid input, please re-enter: ");
				first = input.nextLine();
				check = checkString(first);
			}
			System.out.print(">> Please enter your last name: ");
			String last = input.nextLine();
			while (check == false) {
				System.out.print("Invalid input, please re-enter: ");
				last = input.nextLine();
				check = checkString(last);
			}
			String name = first + " " + last;
			names.add(name);
			
			System.out.print(">> Are you a junior, adult or senior: ");
			String type = input.nextLine();
			check = checkCat(type);
			while (check == false) {
				System.out.print("Invalid input, please re-enter: ");
				type = input.nextLine();
				check = checkCat(type);
			}
			category.add(type);
		
			System.out.println("The password must be: \n 1) At least 8 characters long \n 2) Start with a capital letter \n 3) End with a symbol ");
			System.out.print(">> Please register your passowrd: ");
			String pass = input.nextLine();
			check = checkPass(pass);
			while (check == false) {
				System.out.print("Invalid input, please re-enter: ");
				pass = input.nextLine();
				check = checkPass(pass);
			}
			password.add(pass);
			
			System.out.print("Is there any new customer, Y for yes and N for no: ");
			System.out.println(" ");
			String choose = input.nextLine();
			end = run(choose);
		}
		
		noJunior = Junior(names,category);
		noAdult = Adult(names,category);
		noSenior = Senior(names,category);
		noMember = Total(names);
		
		System.out.println("---------- OUTPUTING ----------");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + " " + category.get(i));
		}
		System.out.println("There are " + noJunior + " junior members");
		System.out.println("There are " + noAdult + " adult members");
		System.out.println("There are " + noSenior + " senior members");
		System.out.println("There are a total of " + noMember + " members");
		
		
	}
	
	public int Junior (ArrayList<String> n, ArrayList<String> c) {
		ArrayList<String> j = new ArrayList<String>();
		for (int i = 0; i < c.size(); i++) {
			String cat = c.get(i).toUpperCase();
			if (cat.equals("JUNIOR")) {
				j.add(n.get(i));
			}
		}
		return j.size();
	}
	
	public int Adult (ArrayList<String>n, ArrayList<String> c) {
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < c.size(); i++) {
			String cat = c.get(i).toUpperCase();
			if (cat.equals("ADULT")) {
				a.add(n.get(i));
			}
		}
		return a.size();
	}
	
	public int Senior (ArrayList<String>n, ArrayList<String> c) {
		ArrayList<String> s = new ArrayList<String>();
		for (int i = 0; i < c.size(); i++) {
			String cat = c.get(i).toUpperCase();
			if (cat.equals("SENIOR")) {
				s.add(n.get(i));
			}
		}
		return s.size();
		
	}
	
	public boolean run(String i) {
		Scanner input = new Scanner(System.in);
	 	String x = i.toUpperCase();
	 	while (!x.equals("Y") && !x.equals("N")) {
	 		System.out.print("Invalid input, please enter again: ");
	 		x = input.nextLine();
	 		x = x.toUpperCase();
	 	}
	 	if (x.contentEquals("N")) {
	 		return true;
	 	} else {
	 		return false;
	 	}
}
	public boolean checkCat(String i) {
		Scanner input = new Scanner(System.in);
		String x = i.toUpperCase();
		if (!x.equals("JUNIOR") && !x.equals("ADULT") && !x.equals("SENIOR")) {
			return false;
	}
		else {
			return true;
		}
	}
	
	public boolean checkString(String i) {
		i = i.toLowerCase();
		char[] charArray = i.toCharArray();
		for (int x = 0; x < charArray.length; x++) {
			//Make sure it is letter
			if (!(charArray[x] >= 'a' && charArray[x] <= 'z')){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkPass(String i) {
		char[] charArray = i.toCharArray();
		//Make a range between 0 to 9 via [0-9] in a set structure (.*[value].*)
		String numbers = "(.*[0-9].*)";
		int last = charArray.length-1;
		String lastchar = Character.toString(charArray[last]);
		if (charArray.length < 8) {
			return false;
		}
		//Make sure it is a capital letter
		if (!(charArray[0] >= 'A' && charArray[0] <= 'Z')) {
			return false;
		}
		if(!lastchar.equals("!")&&!lastchar.equals("@")&&!lastchar.equals("#")&&!lastchar.equals("$")&&!lastchar.equals("%")&&!lastchar.equals("^")&&!lastchar.equals("&")&&!lastchar.equals("*")) {
			return false;
		}
		if (!i.matches(numbers)) {
			return false;
		}
		return true;
		
	}
	
	public int Total(ArrayList<String>n) {
		return n.size();
	}
	
	public static void main(String[] args) {
		Golf g1 = new Golf();
	}
}
