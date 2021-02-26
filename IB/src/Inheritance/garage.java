package Inheritance;

import java.util.ArrayList;

public class garage  {
	ArrayList<car> cars = new ArrayList<car>();
	ArrayList<motorbike> motorbike = new ArrayList<motorbike>();
	
	public garage() {
		cars.add(new car("A123", "Peugeot", "208", "Silver", "Mr C", 2500,true, 5,5,false));
		cars.add(new car("B283", "Mercedes", "GLE", "Black", "Nam", 10000.32, true, 4,7,true));
		cars.add(new car("R910", "Audi", "A7", "Red", "Duc", 32456.3, false, 4,7,true));
		
		motorbike.add(new motorbike("VC1203", "Honda", "SuperBike","Blue","Nam", 1000,2, true));
		motorbike.add(new motorbike("VC1353", "Vinfast", "Ludo","Orange","Duc", 987,2, true));
		
		
		viewCars();
		viewMotorbike();
		
	}
	
	public void viewCars() {
		for (int i = 0; i < cars.size(); i++) {
			 int num = i + 1;
			 System.out.println("Cars: " + num);
	    	 System.out.println(cars.get(i).getRegistration());
	    	 System.out.println(cars.get(i).getMake());
	    	 System.out.println(cars.get(i).getModel());
	    	 System.out.println(cars.get(i).getOwner());
	    	 System.out.println(cars.get(i).getValue());
	    	 System.out.println(cars.get(i).crash());
		}
	}
	
	public void viewMotorbike() {
		for (int i = 0; i < motorbike.size(); i++) {
			 int num = i + 1;
			 System.out.println("Motorbikes: " + num);
	    	 System.out.println(motorbike.get(i).getRegistration());
	    	 System.out.println(motorbike.get(i).getMake());
	    	 System.out.println(motorbike.get(i).getModel());
	    	 System.out.println(motorbike.get(i).getOwner());
	    	 System.out.println(motorbike.get(i).getValue());
	    	 System.out.println(cars.get(i).crash());
		}
	}
	
	public static void main(String[] args) {
		garage g1 = new garage();
		
	}
}