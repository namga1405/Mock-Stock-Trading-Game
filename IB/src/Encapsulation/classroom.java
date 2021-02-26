package Encapsulation;
import java.util.ArrayList;
//ArrayList import needed

public class classroom
{
 // Declare the name and data type for the arraylist
	ArrayList<Assignment> task;
 
 public classroom()
 {
     // Initialize the arraylist
	 task = new ArrayList<Assignment>();
     
 }

 
 // This method should accept a title and total mark,
 // create the object, then add this to the list.
 public void addAssignment(String title, int totalMark)
 {
     task.add(new Assignment(title,totalMark));
     
 }
 
 // This method should loop over the arraylist using the .size() method
 // printing the data in the format "title" : "mark".
 // It should also display the total marks available from all assignments.
 
 public void viewAssignments()
 {
     for (int i = 0; i < task.size(); i++) {
    	 System.out.println("Assignment " + i+1);
    	 System.out.println(task.get(i).getTitle());
    	 System.out.println(task.get(i).getTotal());
     }
 }
public static void main(String[] args) {
	classroom compsci = new classroom();
	compsci.addAssignment("Java", 20);
	
	classroom math = new classroom();
	math.addAssignment("Math", 50);
	
	System.out.println("Computer Science: ");
	compsci.viewAssignments();
	
	System.out.println("Maths: ");
	math.viewAssignments();
}
}
