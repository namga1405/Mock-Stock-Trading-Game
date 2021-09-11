package Stonks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class UserInfo {
	private int id;
	private String user;
	private int rank;
	private double balance;
	private String stockname;
	private int noBought;
	private double cost;
	private double value;
	static ArrayList<UserInfo> User;
	
	//Create class
	  public UserInfo(int id, String user, int rank, double balance){
	        this.id = id;
	        this.user = user;
	        this.rank = rank;
	        this.balance = balance;
	        
	    }
	  
	  public UserInfo(String stockname,int noBought, double cost, double value) {
		  this.stockname = stockname;
		  this.noBought = noBought;
		  this.cost = cost;
		  this.value = value;
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
	  
	  public String getStockname() {
		  return stockname;
	  }
	  
	  public int getNoBought() {
		  return noBought;
	  }
	  
	  public double getCost() {
		  return cost;
	  }
	  
	  public double getValue() {
		  return value;
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
	
	//Method to get the userID given the username 
	public static int getIDfromDB(String username) {
		 int ID = 0;
		 try{
	        	//Connect to database, and then a query will be make to retrieve the userID of the chosen user from the table user
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT UserID FROM user WHERE Username='"+username+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()){
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
	            	ID = rs.getInt("UserID");
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
		 	return ID;
	}
	
	//Method to get the number of stock bought in a transaction that a user with an ID i bought
	public static ArrayList<Integer> getnoBought(int i){
		 ArrayList<Integer> stocks = new ArrayList<>();
		 try{
	        	//Connect to database, and then a query will be make to retrieve required information in table transaction so it could be put into the ranking table via accessor methods
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (noBought) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	   	            	int noBought = rs.getInt("noBought");
	   	            	stocks.add(noBought);    
	            }
	}
		 catch(Exception exc) {
				exc.printStackTrace();
			}
		 return stocks;
	}
	
	//Method to get the cost of a transaction that a user with an ID i bought
	public static ArrayList<Double> getCost(int i){
		 ArrayList<Double> stocks = new ArrayList<>();
		 try{
	        	//Connect to database, and then a query will be make to retrieve required information in table transaction so it could be put into the ranking table via accessor methods
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (Cost) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	   	            	double cost = rs.getDouble("Cost");
	   	            	stocks.add(cost);    
	            }
	}
		 catch(Exception exc) {
				exc.printStackTrace();
			}
		 return stocks;
	}
	
	//Method to get the current value of a stock that a user with an ID i bought
	public static ArrayList<Double> getValue(int i){
		 ArrayList<Double> stocks = new ArrayList<>();
		 try{
	        	//Connect to database, and then a query will be make to retrieve required information in table transaction so it could be put into the ranking table via accessor methods
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (StockID) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	            	int ID = rs.getInt("StockID");
	            	String query2 = "SELECT (Value) FROM stock WHERE StockID ='"+ID+"'";
	   	            Statement st2 = con.createStatement();
	   	            ResultSet rs2 = st2.executeQuery(query2);
	   	            while(rs2.next()) {
	   	            	double value = rs2.getDouble("Value");
	   	            	stocks.add(value);    	
	   	            }
	            }
	}
		 catch(Exception exc) {
				exc.printStackTrace();
			}
		 return stocks;
	}
	
	//Method to get the stock name that a user with an ID i bought
	public static ArrayList<String> getStockname(int i){
		 ArrayList<String> stocks = new ArrayList<>();
		 try{
	        	//Connect to database, and then a query will be make to retrieve required information in table transaction so it could be put into the ranking table via accessor methods
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (StockID) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	            	int ID = rs.getInt("StockID");
	            	String query2 = "SELECT (Name) FROM stock WHERE StockID ='"+ID+"'";
	   	            Statement st2 = con.createStatement();
	   	            ResultSet rs2 = st2.executeQuery(query2);
	   	            while(rs2.next()) {
	   	            	String stockname = rs2.getString("Name");
	   	            	stocks.add(stockname);    	
	   	            }
	            }
	}
		 catch(Exception exc) {
				exc.printStackTrace();
			}
		 return stocks;
	}
	
	
}
