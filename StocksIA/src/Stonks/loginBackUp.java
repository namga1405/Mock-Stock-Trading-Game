package Stonks;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class loginBackUp extends JFrame {
	private JFrame login;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginBackUp frame = new loginBackUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**Connect SQL and return to query*/
	public void loginEnter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/stocks","root","root");
			Statement state = com.createStatement();
			@SuppressWarnings("deprecation")
			String sql = "Select * from user where Username ='"+txtUser.getText()+"' and Password ='"+txtPass.getText().toString()+"'";
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Login successful");
				/**Creating object to change frame*/
				login.dispose();
				menuScreen menu = new menuScreen();
				menu.setVisible(true);
			}
			else {
					JOptionPane.showMessageDialog(null, "Login unsuccessful");
					login.dispose();
					loginBackUp frame = new loginBackUp();
					frame.setVisible(true);
				}
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
	}

	/**
	 * Create the frame.
	 */
	public loginBackUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Stonk Rush");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(44, 33, 480, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnLogin.setBounds(512, 297, 123, 42);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginEnter();
		};
	});
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 129, 269, 51);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(173, 142, 360, 32);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(54, 224, 269, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnSignUp.setBounds(54, 297, 123, 42);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					signupScreen signup = new signupScreen();
					signup.setVisible(true);
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		
		txtPass = new JPasswordField();
		txtPass.setBounds(173, 237, 360, 32);
		contentPane.add(txtPass);
		

}
}
