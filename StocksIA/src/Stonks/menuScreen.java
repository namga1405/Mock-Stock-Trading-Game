package Stonks;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class menuScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public menuScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(64, 26, 344, 59);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Purchase Stocks");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton.setBounds(157, 96, 383, 49);
		contentPane.add(btnNewButton);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnRanking.setBounds(157, 201, 383, 49);
		contentPane.add(btnRanking);
		
		JButton btnProgression = new JButton("Progression");
		btnProgression.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnProgression.setBounds(157, 304, 383, 49);
		contentPane.add(btnProgression);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnProfile.setBounds(157, 404, 383, 49);
		contentPane.add(btnProfile);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(522, 37, 138, 30);
		contentPane.add(btnNewButton_1);
		
	}

}
