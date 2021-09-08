package Stonks;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;


import javax.swing.JButton;

public class menuScreen extends JFrame {

	private JPanel contentPane;
	private JFrame exiting;
	private JLabel lblshowUser;
	private boolean chooseFrame;



	//Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuScreen frame = new menuScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String showName(String str) {
		String s = str;
		String st = lblshowUser.getText();
		lblshowUser.setText(st+": "+str);
		return s;
	}
	
		
	public boolean time() {
		//Create a continuous running clock system
		Thread time = new Thread() {
			public void run() {
				try {
					for (;;) {
						//Create new object
					Date cal = new Date();
					}
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		};
		//Run the time
		time.start();
		Date cal = new Date();
		//Get the required information using the preset method getHours and getDay so the hour and the day of the week is retrieve to make a time interval
		int hour = cal.getHours();
		int day = cal.getDay();
		//Set up the interval by setting the day to not be Monday and the time to not be 16h to show the purchase fail screen
		if (day != 1 || hour < 16 || hour > 16) {
			return false;
		}
		else {
			return true;
		}
}
		
	//Create the frame.
	
	public menuScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblshowUser = new JLabel();
		lblshowUser.setText("Welcome: ");
		lblshowUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblshowUser.setBounds(31, 19, 578, 59);
		contentPane.add(lblshowUser);
		
		JButton btnPurchaseStocks = new JButton("Purchase Stocks");
		btnPurchaseStocks.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPurchaseStocks.setBounds(157, 96, 383, 49);
		contentPane.add(btnPurchaseStocks);
		btnPurchaseStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					chooseFrame = time();
					if (chooseFrame != true) {
					PurchaseFailScreen fail = new PurchaseFailScreen();
					fail.setVisible(true);
					}
					else {
						SuccessScreen success = new SuccessScreen();
						success.setVisible(true);
					}
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnRanking.setBounds(157, 201, 383, 49);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					rankingScreen rank = new rankingScreen();
					rank.setVisible(true);
				}
				catch(Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		
		JButton btnProgression = new JButton("Progression");
		btnProgression.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnProgression.setBounds(157, 304, 383, 49);
		contentPane.add(btnProgression);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnProfile.setBounds(157, 404, 383, 49);
		contentPane.add(btnProfile);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(522, 37, 138, 30);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Exit the program
				exiting = new JFrame("exit");
				if(JOptionPane.showConfirmDialog(exiting, "Confirm if you want to exit","Stonk Rush",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				
				}
				
			}
		});
		
	}

}
