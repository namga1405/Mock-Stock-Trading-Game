package Stonks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class UserInfo {
	int id;
	String user;
	int rank;
	double balance;
	static ArrayList<UserInfo> User;
	
	//Create class
	  public UserInfo(int id, String user, int rank, double balance){
	        this.id = id;
	        this.user = user;
	        this.rank = rank;
	        this.balance = balance;
	        
	    }
	  
	  //Set accessor method
	  public int getId() {
		  return id;
	  }
	  
	  public String getUser() {
		  return user;
	  }
	  
	  public int getRank() {
		  return rank;
	  }
	  
	  public double getBalance() {
		  return balance;
	  }
	  
	//Method to set up a object to store the UserID, Username, Rank and Balance so it could be put on the table afterwards
	public static ArrayList<UserInfo> UserList(){
        ArrayList<UserInfo> UserList = new ArrayList<>();
        try{
        	//Connect to database, and then a query will be make to retrieve all information from the table ranking so it could be put into the ranking table via accessor methods
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
            String query = "SELECT * FROM ranking";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            UserInfo user;
            while(rs.next()){
            	//Turn it into variable types that could be read in Eclipse then adding into the array list
            	user = new UserInfo(rs.getInt("UserID"), rs.getString("Username"), rs.getInt("Rank"), rs.getDouble("Balance"));
            	UserList.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return UserList;
    }
	
	
	}
