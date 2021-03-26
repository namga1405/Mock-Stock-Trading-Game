package Instafamous;
import java.util.*;


public class influencer {
static Scanner input = new Scanner(System.in);
private String fullName;
private String country;
private Object username;
private boolean instaFamous;
private Object[] description = new Object[2];
private int[] like = new int[2];


public influencer() {
	instaFamous = false;
	
	System.out.print("Please enter your first name: ");
	String firstname = input.nextLine();
	System.out.print("Please enter your last name: ");
	String lastname = input.nextLine();
	fullName = firstname+ " " +lastname;
	
	
	System.out.print("Please enter your country: ");
	country = input.nextLine();
	
	System.out.print("Please enter your Instagram username: ");
	username = input.nextLine();
}

public void arraypopulated() {
	for (int i = 0; i<like.length; i++) {
		System.out.print("Enter the description of your " + (i+1) + " photo: ");
		description[i] = input.next();
		System.out.print("Enter the number of like of your " + (i+1) + " photo: " );
		like[i] = input.nextInt();
	}
}

public void retrieveDetails() {
	System.out.println("User: " + fullName);
	System.out.println("Lives in: " + country);
	System.out.println("Username: " + username);
	System.out.println("InstaFamous: " + instaFamous);
}

public void evaluateProfile() {
	int total = 0;
	int number = like.length;
	for (int i = 0; i < like.length; i++) {
		total = total + like[i];
	}
	int average = total/number;
	if (average >= 1000) {
		instaFamous = true;
	}
}

public void changeUsername(Object newname) {
	System.out.println("--------------------");
	username = newname;
	System.out.println("Updated information: ");
	retrieveDetails();
}



public static void main(String[] args) {
	
	influencer i1 = new influencer();
	i1.arraypopulated();
	i1.evaluateProfile();
	i1.retrieveDetails();
	System.out.print("Do you want to change username: ");
	String change = input.next();
	if (change.equals("Y")) {
		System.out.print("Please enter your new username: ");
		Object newuser = input.next();
		i1.changeUsername(newuser);
	}
}
}
