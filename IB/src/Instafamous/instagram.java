package Instafamous;
import java.util.ArrayList;
import java.util.Scanner;

public class instagram {
	ArrayList<influencer> users = new ArrayList<influencer>();

public static void main(String[] args) {
	instagram gagram = new instagram();
	for (int x = 0; x < 2; x++) {
		gagram.newUser();
		gagram.retrieveUserInfo();
	}
	
}

public void newUser() {
	System.out.print("Please enter your first name: ");
	Scanner input = new Scanner(System.in);
	String firstname = input.nextLine();
	System.out.print("Please enter your last name: ");
	String lastname = input.nextLine();
	String n = firstname+ " " +lastname;
	System.out.print("Please enter your country: ");
	String c = input.nextLine();
	System.out.print("Please enter your Instagram username: ");
	String u = input.nextLine();
	
	users.add(new influencer(n,c,u));
}

public void retrieveUserInfo() {
	if (users.isEmpty()) {
		System.out.println("Too bad so sad you have no people");
	}
	else {
		for(int i = 0; i < users.size(); i++) {
			influencer i1 = users.get(i);
			i1.retrieveDetails();
			i1.addPosts();
			i1.addPosts();
			i1.evaluateProfile();
			i1.retrieveDetails();
			i1.updateAllPost();
			i1.braggingRights();
		}
	}
}
}
