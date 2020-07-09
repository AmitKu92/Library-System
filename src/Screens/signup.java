package Screens;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controllers.signupCon;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ObservableView observableView = new ObservableView();
	private Controllers.signupCon controller = new signupCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(52, 51, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(52, 122, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(52, 185, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Security questin");
		lblNewLabel_3.setBounds(52, 247, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("answer");
		lblNewLabel_4.setBounds(52, 323, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"back"});
			/*	Model aa=new Model();
				if(aa.chekA()) {
					setVisible(false);
					MenuMainA ob=new MenuMainA();
					ob.setVisible(true);
				}
				else {
				setVisible(false);
			    MenuMain ob=new MenuMain();
			    ob.setVisible(true);
				}
		*/	}
		});
		btnNewButton_1.setBounds(231, 579, 97, 25);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(155, 51, 229, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 119, 229, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 182, 229, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is you mother name?", "What is your nick name?", "What is your pet name?", "What school did you go to?"}));
		comboBox.setBounds(155, 247, 229, 22);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 320, 229, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Authrize");
		lblNewLabel_5.setBounds(52, 395, 76, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Normal"}));
		comboBox_1.setBounds(155, 392, 173, 22);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboBox_1.getSelectedItem()=="Admin") {
					//Admin aa=new Admin(textField.getText(),textField_1.getText(),textField_2.getText(),(String)comboBox.getSelectedItem(),textField_3.getText());
					observableView.notifyObs(new Object[] {"Enter","Admin",textField.getText(),textField_1.getText(),textField_2.getText(),(String)comboBox.getSelectedItem(),textField_3.getText()});
			       // aa.newAdmin();
					}
				else 
				{
					observableView.notifyObs(new Object[] {"Enter","Librarian",textField.getText(),textField_1.getText(),textField_2.getText(),(String)comboBox.getSelectedItem(),textField_3.getText()});
				//Librarian bb=new Librarian(textField.getText(),textField_1.getText(),textField_2.getText(),(String)comboBox.getSelectedItem(),textField_3.getText()); 
				//bb.newLibrarian();
				}
					
			}
		});
		btnNewButton.setBounds(60, 579, 97, 25);
		contentPane.add(btnNewButton);
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
