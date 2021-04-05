package Instafamous;
import java.util.*;


public class influencer {
static Scanner input = new Scanner(System.in);
private String fullName;
private String country;
private String username;
private boolean instaFamous;
private ArrayList<post> PostInfo = new ArrayList<post>();



public influencer(String n, String c, String u) {
	instaFamous = false;
	username = u;
	country = c;
	fullName = n;
	
}

public void addPosts() {
	System.out.print("Please enter the description of your post: ");
	String description = input.next();
	System.out.print("Please enter the number of likes of your post: ");
	int likes = input.nextInt();
	PostInfo.add(new post(description,likes));
}



public void retrieveDetails() {
	System.out.println("User: " + fullName);
	System.out.println("Lives in: " + country);
	System.out.println("Username: " + username);
	System.out.println("InstaFamous: " + instaFamous);
}

public void evaluateProfile() {
	int total = 0;
	int number = PostInfo.size();
	for (int i = 0; i < PostInfo.size(); i++) {
		int likes = PostInfo.get(i).getLikes();
		total = total + likes;
	}
	int average = total/number;
	if (average >= 1000) {
		instaFamous = true;
	}
}

public void changeUsername(String newname) {
	System.out.println("--------------------");
	username = newname;
	System.out.println("Updated information: ");
	retrieveDetails();
}



public void compare(int m) {
	for (int i = 0; i < PostInfo.size(); i++) {
		if(PostInfo.get(i).getLikes() == m) {
			System.out.println(PostInfo.get(i).getDescription());
		}
	}
}

public boolean yesorno() {
	System.out.print("Please enter Y for yes, N for no: ");
	String choice = input.next();
	choice = choice.toUpperCase();
	while(!choice.equals("Y")&&!choice.equals("N")) {
		System.out.print("Input error, please enter again: ");
		choice = input.next();
		choice = choice.toUpperCase();
	}
	if (choice.equals("Y")) {
		return true;
	}
	else {
		return false;
	}
}

public void bestPost() {
	int max = 0;
	for (int i = 0; i < PostInfo.size(); i++) {
		if(PostInfo.get(i).getLikes() > max) {
			max = PostInfo.get(i).getLikes();
		}
	}
	System.out.println("List of the best post: ");
	compare(max);
}

public void worstPost() {
	int min = PostInfo.get(0).getLikes();
	for (int i = 0; i < PostInfo.size(); i++) {
		if(PostInfo.get(i).getLikes() < min) {
			min = PostInfo.get(i).getLikes();
		}
	}
	System.out.println("List of the worst post: ");
	compare(min);
}

public void updateSinglePost(int p, String d, int l) {
	PostInfo.get(p-1).updateDescription(d);
	PostInfo.get(p-1).updateLikes(l);
}

public void updateAllPost() {
	for(int i = 0; i < PostInfo.size(); i++) {
		int count = i+1;
		System.out.print("Please enter the description for new post #" +(i+1)+" : ");
		String newdes = input.next();
		System.out.print("Please enter the number of likes for new post #" +(i+1)+" : ");
		int newlike = input.nextInt();
		updateSinglePost(count,newdes,newlike);
	}
}

public boolean checkInt(String i) {
	try {
		Integer.parseInt(i);
		return true;
	}
	catch(NumberFormatException e) {
		return false;
	}
	
}

}
