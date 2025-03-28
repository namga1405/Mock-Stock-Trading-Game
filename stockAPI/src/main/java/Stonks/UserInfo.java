package Stonks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class UserInfo {
	private int id;
	private String user;
	private int rank;
	private double balance;
	private String date;
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
           //Create an instance of class Userinfo
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
	
	public static int getStockIDfromDB(String stockname) {
		 int ID = 0;
		 try{
	        	//Connect to database, and then a query will be make to retrieve the userID of the chosen user from the table user
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT StockID FROM stock WHERE Name='"+stockname+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()){
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
	            	ID = rs.getInt("Name");
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
			//Connect to database, and then a query will be make to retrieve the number of stocks bought(unknown limit -> array list) by user with userID i to put on the table on profileScreen
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (noBought) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
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
			//Connect to database, and then a query will be make to buying price of stocks bought(unknown limit -> array list) by user with userID i to put on the table on profileScreen
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (Cost) FROM transaction WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
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
			//Connect to database, and then a query will be make to retrieve the current price of stocks bought(unknown limit -> array list) by user with userID i to put on the table on profileScreen
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
	   	         	//Turn it into variable types that could be read in Eclipse then adding into the array list
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
	        	//Connect to database, and then a query will be make to retrieve the stocks bought(unknown limit -> array list) by user with userID i to put on the table on profileScreen
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
	   	         	//Turn it into variable types that could be read in Eclipse then adding into the array list
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
	
	public static int getRankfromID(int i){
        int rank = 0;
        try{
        	//Connect to database, and then a query will be make to retrieve the ranking of user with userID i to put on proifle page
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
            String query = "SELECT Rank FROM ranking WHERE UserID='"+i+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            UserInfo user;
            while(rs.next()){
            	//Turn it into variable types that could be read in Eclipse then adding into the array list
            	rank = rs.getInt("Rank");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return rank;
    }
	
	public static double getBalancefromID(int i){
        double balance = 0;
        try{
        	//Connect to database, and then a query will be make to retrieve the balance from the table ranking to put on the profile page 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
            String query = "SELECT Balance FROM ranking WHERE UserID='"+i+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            UserInfo user;
            while(rs.next()){
            	//Turn it into variable types that could be read in Eclipse then adding into the array list
            	balance= rs.getInt("Balance");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return balance;
    }
	
	//Method to get the balance of userID i from the table progression
	public static ArrayList<Double> getBalancefromProgression(int i){
		 ArrayList<Double> storeBalance = new ArrayList<>();
		 try{
			//Connect to database, and then a query will be make to retrieve all the balance recorded(unknown limit -> array list) by user with userID i to put on the table on progressionScreen
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String query = "SELECT (Balance) FROM progression WHERE UserID ='"+i+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            while(rs.next()) {
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
	   	            	double balance = rs.getDouble("Balance");
	   	            	storeBalance.add(balance);
	            }
	}
		 catch(Exception exc) {
				exc.printStackTrace();
			}
		 return storeBalance;
	}
	
	//Method to get the updated date for the balance of userID i from the table progression
		public static ArrayList<String> getDatefromProgression(int i){
			 ArrayList<String> storeDate = new ArrayList<>();
			 try{
				//Connect to database, and then a query will be make to retrieve all the updated date(unknown limit -> array list) by user with userID i to put on the table on progressionScreen
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
		            String query = "SELECT (UpdatedDate) FROM progression WHERE UserID ='"+i+"'";
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(query);
		            while(rs.next()) {
		            	//Turn it into variable types that could be read in Eclipse then adding into the array list
		   	            	String date = rs.getString("UpdatedDate");
		   	            	storeDate.add(date);
		            }
		}
			 catch(Exception exc) {
					exc.printStackTrace();
				}
			 return storeDate;
		}
		
		public static ArrayList<Integer> UserIDlist() {
			ArrayList<Integer> IDList = new ArrayList<>();
			 try{
					//Connect to database, and then a query will be make to retrieve all the updated date(unknown limit -> array list) by user with userID i to put on the table on progressionScreen
			            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			            String query = "SELECT UserID FROM user";
			            Statement st = con.createStatement();
			            ResultSet rs = st.executeQuery(query);
			            while(rs.next()) {
			            	//Turn it into variable types that could be read in Eclipse then adding into the array list
			   	            	int ID = rs.getInt("UserID");
			   	            	IDList.add(ID);
			            }
			}
				 catch(Exception exc) {
						exc.printStackTrace();
					}
			return IDList;
		}
		
		public static void updateBalancetoRanking(int ID, double balance) {
			try {
				//Connect to the database
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
				Statement stmt = com.createStatement();
				//Update the balance in the ranking table of UserID ID
				String Update = "UPDATE ranking SET Balance='"+balance+"' WHERE UserID='"+ID+"'";
				PreparedStatement pat = com.prepareStatement(Update);
				pat.execute();
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}
		
		public static ArrayList<Double> collectAllBalance() {
			ArrayList<Double> balance = new ArrayList<>();
			try {
				//Connect to the database
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
				Statement stmt = com.createStatement();
				//Retrieve the current balance of all user in the database from the table ranking to an arraylist
				String getBalance = "SELECT Balance FROM ranking";
				ResultSet rs = stmt.executeQuery(getBalance);
				while (rs.next()) {
					double bal = rs.getDouble("Balance");
					balance.add(bal);
				}
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			return balance;
		}
}
