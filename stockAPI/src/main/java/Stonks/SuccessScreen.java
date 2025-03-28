package Stonks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;

public class SuccessScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantity;
	private JLabel lblTimer;
	private String username;
	private ArrayList<String> storeStock;
	private double exchangerate;
	
	public void storeName(String str) {
		username = str;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccessScreen frame = new SuccessScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Get stocks from the database with selected country to put to array list
	private ArrayList<String> getStocks(int i) {
		ArrayList<String> stocks = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			Statement stmt = com.createStatement();
			//Retrieve marketID with where the name is matched on the combo box
				String retrieveStock = "Select Name FROM stock WHERE MarketID='"+i+"'";
				ResultSet rs2 = stmt.executeQuery(retrieveStock);
				while (rs2.next()) {
					String name = rs2.getString("Name");
					//Adding it to the array list
					stocks.add(name);
				}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return stocks;
	}
	
	private int getMarketID(Object Object) {
		int i = 0;
		String s = Object.toString();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			Statement stmt = com.createStatement();
			//Retrieve marketID with where the name is matched on the combo box
			String retrieveID = "SELECT MarketID FROM market WHERE marketName='"+s+"'";
			ResultSet rs = stmt.executeQuery(retrieveID);
			//Continue adding until there's non left
			while (rs.next()) {
				//Getting the ID from the market DB to query for the stock DB since the ID is essentially acting like a foreign key acessor
				i = rs.getInt("MarketID");
			}
		}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		return i;
	}
	
	
	
	private double getPrice(String s) {
		double price = 0.00;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			Statement stmt = com.createStatement();
			/**Retrieve the price of the selected stock by connecting to the database and using query name retrieveprice which will take the column value from the 
			chosen stockname on the table stock*/
			String retrieveprice = "SELECT Value FROM stock WHERE Name='"+s+"'";
			ResultSet rs = stmt.executeQuery(retrieveprice);
			while(rs.next()) {
				//Return value to the program
				price = rs.getDouble("Value");
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return price;
	}
	
	//Convert array list to array to put into combo box
	private String[] convertArray(ArrayList<String> a) {
		String[] array = a.toArray(new String[0]);
		return array;
	}
	
	public int getStockIDfromDB(String s) {
		 int ID = 0;
		 try{
	        	//Connect to database, and then a query will be make to retrieve the userID of the chosen user from the table user
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
	            String retrieveID = "SELECT StockID FROM stock WHERE Name='"+s+"'";
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(retrieveID);
	            while(rs.next()){
	            	//Turn it into variable types that could be read in Eclipse then adding into the array list
	            	ID = rs.getInt("StockID");
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
		 	return ID;
	}	
	
	private void pushtoDB(int noBought, double cost, String boughtDate, int user, int stock) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			Statement stmt = com.createStatement();
			String pushDB = "INSERT INTO transaction(noBought,Cost,boughtDate,UserID,StockID) values('"+noBought+"','"+cost+"','"+boughtDate+"','"+user+"','"+stock+"')";
			int x = stmt.executeUpdate(pushDB);
			if (x == 0) {
				System.out.println("Addition failed");
			} else {
				//Confirmation
				System.out.println("Added");
				}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

	
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
		
	private void timeuntilClosing() {
		Thread time = new Thread() {
			public void run() {
				try {
					for (;;) {
					//Get current time + Calculate time until purchase window close
					Date date = new Date();
					int second = 59-date.getSeconds();
					int minute = 59-date.getMinutes();
					int hour = 16-date.getHours();
					
				
					
					lblTimer.setText(hour+ " Hour "+ minute+ " Minute "+ second+ " Second ");
					}
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		};
		//Make time continuous
		time.start();
}
	
	

	/**
	 * Create the frame.
	 */
	public SuccessScreen() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox cmbStocks = new JComboBox();
		cmbStocks.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbStocks.setBounds(228, 108, 138, 34);
		contentPane.add(cmbStocks);
		
		JLabel lblNewLabel = new JLabel("Purchasing");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(25, 11, 234, 49);
		contentPane.add(lblNewLabel);
		
		final JComboBox cmbMarket = new JComboBox();
		cmbMarket.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbMarket.setModel(new DefaultComboBoxModel(new String[] {"", "USA", "France", "Australia"}));
		cmbMarket.setBounds(25, 106, 138, 34);
		contentPane.add(cmbMarket);
		cmbMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbStocks.removeAllItems();
				int marketID = getMarketID(cmbMarket.getSelectedItem());
				storeStock = getStocks(marketID);
				//Change it to an array since it is required to make the the model
				String[] stockname = convertArray(storeStock);
				final DefaultComboBoxModel Model = new DefaultComboBoxModel(stockname);
				cmbStocks.setModel(Model);
					
			}
		});
		
		JLabel lblStockName_1 = new JLabel("Quantity");
		lblStockName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockName_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStockName_1.setBounds(10, 268, 98, 24);
		contentPane.add(lblStockName_1);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(97, 270, 138, 24);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lbl = new JLabel("Total:");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl.setBounds(32, 233, 75, 24);
		contentPane.add(lbl);
		
		final JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.RED);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(87, 228, 490, 34);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel_2 = new JLabel("Window close in:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 321, 189, 34);
		contentPane.add(lblNewLabel_2);
		
		lblTimer = new JLabel("New label");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setForeground(Color.RED);
		timeuntilClosing();
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimer.setBounds(185, 318, 392, 41);
		contentPane.add(lblTimer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnMenu.setBounds(35, 417, 130, 34);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Change to menu screen
					setVisible(false);
					menuScreen menu = new menuScreen();
					menu.showName(username);
					menu.setVisible(true);
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		
		final JComboBox cmbCurrency = new JComboBox();
		cmbCurrency.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbCurrency.setModel(new DefaultComboBoxModel(new String[] {"", "USD", "CAD", "AUD", "EUR", "VND"}));
		cmbCurrency.setBounds(439, 106, 138, 34);
		contentPane.add(cmbCurrency);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.RED);
		btnConfirm.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnConfirm.setBounds(478, 417, 130, 34);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retrieve the price from the selected stocks by using the method getPrice
				String stockname = (String) cmbStocks.getSelectedItem();
				double stockprice = getPrice((String) cmbStocks.getSelectedItem());
				int ID = UserInfo.getIDfromDB(username);
				double balance = UserInfo.getBalancefromID(ID);
				//Get the quantity from user input
				String q = txtQuantity.getText();
				int quantity = Integer.valueOf(q);
				int stockID = getStockIDfromDB(stockname);
				//Calculate the total + Round it to 2 decimal places
				double total = quantity*stockprice;
				double currentBalance = balance - total;
				String time = getDate();
				//If the cost of the purchase is larger than the balance then there will be a pane telling that the purchase is not progressed
				if (total > balance) {
					JOptionPane.showMessageDialog(null, "Fund not sufficient, automatically return to menu");
				}
				else {
					//If the cost of the purchase is smaller, then all of the required information is being updated to the transaction table and update the balance in the ranking table(without changing the actual value of the rank)
					pushtoDB(quantity,total,time,ID,stockID);
					UserInfo.updateBalancetoRanking(ID,currentBalance);
					JOptionPane.showMessageDialog(null, "Congratz you bought some stonks!, automatically return to menu");
				}
				//Return to menu screen
				setVisible(false);
				menuScreen menu = new menuScreen();
				menu.showName(username);
				menu.setVisible(true);
			}
		});

		
		JLabel lblNewLabel_1 = new JLabel("Country");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 71, 125, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStockName= new JLabel("Stock Name");
		lblStockName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStockName.setBounds(241, 71, 125, 28);
		contentPane.add(lblStockName);
		
		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrency.setBounds(439, 71, 125, 28);
		contentPane.add(lblCurrency);
		
		JButton btnCheckPrice = new JButton("Check Price");
		btnCheckPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnCheckPrice.setBounds(246, 417, 130, 34);
		contentPane.add(btnCheckPrice);
		btnCheckPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retrieve the price from the selected stocks by using the method getPrice
				double stockprice = getPrice((String) cmbStocks.getSelectedItem());
				/**Get the currency from the selected currency, this is done manually because there is no free API that allows to constantly update the exchange rate, which will violate
				the legal feasibility of the project*/
				String currency = (String) cmbCurrency.getSelectedItem();
				if("USD".equals(currency)) {
					exchangerate = 1;
				} else {
					if("CAD".equals(currency)) {
						exchangerate = 1.26;
					} else {
						if("AUD".equals(currency)) {
							exchangerate = 1.38;
						} else {
							if("EUR".equals(currency)) {
								exchangerate = 0.85;
							} else {
								exchangerate = 22821;
							}
						}
					}
				}
				
				//Get the quantity from user input
				String q = txtQuantity.getText();
				int quantity = Integer.valueOf(q);
				
				//Calculate the total + Round it to 2 decimal places
				double t = quantity*exchangerate*stockprice;
				t = Math.round(t*100.0) / 100.0;
				//Change the total to a string to be able to labelled out 
				String total = Double.toString(t);
				lblPrice.setText(total+" "+currency);
				
				
				
				
			}
		});
		
	}
}
