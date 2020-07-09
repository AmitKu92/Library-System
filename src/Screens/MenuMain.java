package Screens;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.IsadminCon;
import Controllers.IslibrarianCon;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuMain extends JFrame {

	private JPanel contentPane;
	private ObservableView observableView = new ObservableView();
	private Controllers.IslibrarianCon controller = new IslibrarianCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMain frame = new MenuMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static int flag1=0;
	/**
	 * Create the frame.
	 */
	public MenuMain() {
		observableView.addObserver(controller);
		if(flag1==0) {
			observableView.notifyObs(new Object[] {"add"});
			flag1++;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(46, 28, 355, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    CreateBook ob=new CreateBook();
			    ob.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(46, 126, 150, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New File");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    CreateFileDoc ob=new CreateFileDoc();
			    ob.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(46, 254, 150, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New member");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    CreateMember ob=new CreateMember();
			    ob.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(46, 311, 150, 25);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add Book copie");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    CreateBCpy ob=new CreateBCpy();
			    ob.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(46, 185, 150, 25);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Lent Book/File");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			    LentM ob=new LentM();
			    ob.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(208, 126, 155, 25);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Return Book");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    RetM ob=new RetM();
			    ob.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(208, 254, 150, 25);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Add File copie");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    CreateFDCpy ob=new CreateFDCpy();
			    ob.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(208, 185, 150, 25);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Logout");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    Login ob=new Login();
			    ob.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(537, 126, 153, 25);
		contentPane.add(btnNewButton_9);
	}

}
