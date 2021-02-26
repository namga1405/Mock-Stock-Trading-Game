package FileRead;
import java.io.*;
import java.util.*;

public class Running {
	//Declaration
	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<Float> meters = new ArrayList<Float>();
	static ArrayList<String> biglungs = new ArrayList<String>();
	static ArrayList<Float> bigmeters = new ArrayList<Float>();

	//Find the furthest distance
	public static float MostDistance(ArrayList<Float> m) {
		float big = m.get(0);
		for (int i = 1; i < m.size(); i++) {
			if(m.get(i) > big) {
				big = m.get(i);
			}
		}
		return big;
	}

	//Find the person who walked the furthest distance
	public static String winner(ArrayList<Float>m, ArrayList<String> n) {
		float big = m.get(0);
		String person = "";
		for (int i = 1; i < m.size(); i++) {
			if(m.get(i) > big) {
				big = m.get(i);
				person = n.get(i);
			}
		}
		return person;
	}
	
	//Find the list of people who walked over 70% of the furthest distance
	public static ArrayList<String> awardswinner(ArrayList<Float> m, ArrayList<String> n) {
		ArrayList<String> r = new ArrayList<String>();
		float highest = MostDistance(m);
		double standard = highest*0.7;
		for (int i = 0; i < m.size(); i++) {
			if(m.get(i) > standard) {
				r.add(n.get(i));
			}
		}
		return r;
		}
	
	public static ArrayList<Float> distanceofaward(ArrayList<Float> m) {
		ArrayList<Float> f = new ArrayList<Float>();
		float highest = MostDistance(m);
		double standard = highest*0.7;
		for (int i = 0; i < m.size(); i++) {
			if(m.get(i) > standard) {
				f.add(m.get(i));
			}
		}
		return f;
	}
		
	public static void main(String[] args)  {
		//Read the members.txt file
		try {
			File Obj = new File("/Users/Macos/Desktop/IB/Computer Science/Running/members.txt");
			Scanner read = new Scanner(Obj);
			while(read.hasNextLine()) {
				String data = read.nextLine();
				names.add(data.split(",")[0] + " " + data.split(",")[1]);
				meters.add(Float.parseFloat(data.split(",")[2]));
			}
			read.close();
		} catch (Exception e) {
			System.out.println("File error");
			e.printStackTrace();
		}
		
		//Find the person who walked the furthest distance + Finding people who walked over 70% 
		float furthest = MostDistance(meters);
		String name = winner(meters,names);
		biglungs = awardswinner(meters,names);
		bigmeters = distanceofaward(meters);
		
		//Write the info into new txt file
		try {
			FileWriter myWriter = new FileWriter("/Users/Macos/Desktop/IB/Computer Science/Reading File/awards.txt");
			myWriter.write("The person who walk the fastest is: "+"\n");
			myWriter.write(name + " with the distance of " + furthest+"\n\n");
			myWriter.write("The people who will receive award is: " +"\n");
			for (int i = 0; i < biglungs.size(); i++) {
				myWriter.write(biglungs.get(i) + "," + bigmeters.get(i) + "\n");
			}
			myWriter.flush();
			myWriter.close();
			System.out.println("Successfully written"); 
		} catch (Exception e) {
			System.out.println("File error");
			e.printStackTrace();
		}
	}
}