package Stonks;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class signupScreen extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtReenter;


	//Launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupScreen frame = new signupScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}

	//Create the frame
	public signupScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign up");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(51, 37, 191, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(51, 121, 191, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(51, 191, 191, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Re-enter Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(51, 269, 191, 39);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(242, 121, 350, 39);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(242, 195, 350, 39);
		contentPane.add(txtPass);
		
		txtReenter = new JPasswordField();
		txtReenter.setBounds(242, 273, 350, 39);
		contentPane.add(txtReenter);
		
		JButton btnRegister = new JButton("Sign me up!");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Username type in data
				String username = txtUser.getText();
				String password = txtPass.getText();
				String reenter = txtReenter.getText();
				//Verify password to see the repeated password is the same as the original password by using boolean to give out true/false result
				boolean equal = password.equals(reenter);
				if (equal != true) {
					JOptionPane.showMessageDialog(null, "Please correctly re-enter your password");
					
				}
				else {
				try {
					/**Connect to the database by creating a connection. A statement is then given out alongside with a query which is checkUser to find whether the input value is already
					on the database on table user, which will show whether there is a duplication of username*/
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
					//Check to see whether the username has already been taken
					Statement stmt = com.createStatement();
					String checkUser = "SELECT * FROM user WHERE Username='"+username+"'";
					ResultSet usernametaken = stmt.executeQuery(checkUser);
					if(usernametaken.next()) {
						JOptionPane.showMessageDialog(null, "Username has been already taken");
					}
					else { 
						//If there is no duplicated username, then another query is being created to add the passwrod and username onto the table user on the database by INSERT
						String query = "INSERT INTO user(Username,Password) values('"+username+"','"+password+"')";
						Statement sta = com.createStatement();
						int x = sta.executeUpdate(query);
						if (x == 0) {
							JOptionPane.showMessageDialog(null, "This username is already taken");
						} else {
							JOptionPane.showMessageDialog(null, "New account made");
							/**Since the UserID is an auto-incremented value on the database, it will be retrieved via the query getID so it could be put in other tables, 
							essentially working as a foreign key*/
							String getID = "SELECT UserID FROM user WHERE Username='"+username+"'";
							Statement sta2 = com.createStatement();
							ResultSet rs = sta2.executeQuery(getID);
							while(rs.next()) {
								int id = rs.getInt("UserID");
								/**The query inserttoProg is made to insert the new user information into the table Progression so the data could be stored and show up when users want 
								to check their progression*/
								String sdf = getDate();
								String inserttoProg = "INSERT INTO progression(UserID,Balance,UpdatedDate) values ('"+id+"','"+10000+"','"+sdf+"') ";
								Statement sta3 = com.createStatement();
								int y = sta3.executeUpdate(inserttoProg);
								if (y == 0) {
									JOptionPane.showMessageDialog(null, "Error");
								}
								/**This is similar to the inserttoProg but it is added to the Ranking screen so all users will show up in the ranking, with their rank being the ID
								of the newest user also shows the number of users that they currently have*/
								String inserttoRank = "INSERT INTO ranking(Rank,UserID,Username,Balance) values ('"+id+"','"+id+"','"+username+"','"+10000+"') ";
								Statement sta4 = com.createStatement();
								int z = sta4.executeUpdate(inserttoRank);
								if (z == 0) {
									JOptionPane.showMessageDialog(null, "Error");
								}
							}	
								//After finish all, switch to login screen
								setVisible(false);
								loginScreen login = new loginScreen();
								login.frame.setVisible(true);
							
						}
				   }
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
				}
			}
		});
		
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnRegister.setBounds(51, 347, 143, 44);
		contentPane.add(btnRegister);
		;
	}
}
