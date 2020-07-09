package Screens;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.LoginCon;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPanel;
	private JTextField textField;
	private JPasswordField passwordField;
	private ObservableView observableView = new ObservableView();
	private Controllers.LoginCon controller = new LoginCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 499);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(50, 90, 56, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(50, 123, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(129, 87, 208, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 120, 208, 22);
		contentPanel.add(passwordField);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String password=String.copyValueOf(passwordField.getPassword());
				observableView.notifyObs(new Object[] {"Enter",textField.getText(),password});
				
			}
		});
		btnNewButton.setBounds(81, 245, 97, 25);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Forgot Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Forgot ob=new Forgot();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(236, 245, 148, 25);
		contentPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setBounds(28, 13, 285, 47);
		contentPanel.add(lblNewLabel_2);
	}
	public void jump(boolean k) {
		
		if(k) {
			setVisible(false);
			MenuMainA ob=new MenuMainA();
			ob.setVisible(true);
		}
		else {
		setVisible(false);
	    MenuMain ob=new MenuMain();
	    ob.setVisible(true);
		}
		}
}
