package Instafamous;
import java.util.*;

public class post {
	Scanner input = new Scanner(System.in);
	private String description;
	private int likes;
	ArrayList<influencer> comments = new ArrayList<influencer>();

public post(String d, int l) {
	this.description = d;
	this.likes = l;
}

public int getLikes() {
	return likes;
}

public String getDescription() {
	return description;
}

	
public void updateDescription(String m) {
	description = m;
}
	
public void updateLikes(int l) {
	likes = l;
}
}


