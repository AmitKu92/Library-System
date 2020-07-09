package Screens;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.CreateBookCon;
import Controllers.LentCon;
//import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LentM extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_2;
	private JTextField textField_6;
	private ObservableView observableView = new ObservableView();
	private Controllers.LentCon controller = new LentCon(this);
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LentM frame = new LentM();
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
	public LentM() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 851);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			
			
		});
		scrollPane.setBounds(12, 129, 929, 268);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					//	JOptionPane.showMessageDialog(null, "wub");
						
						
						int row=table.getSelectedRow();
						
					
						
					//	String Table_click=(table.getModel().getValueAt(row,0).toString());
						
		
							String add1=table.getValueAt(row,0).toString();
							textField.setText(add1);
							String add2=table.getValueAt(row,1).toString();
							textField_1.setText(add2);
							String add3=table.getValueAt(row,2).toString();
							textField_2.setText(add3);
							
						
					
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Author", "Book ID", "Genre", "Pages", "Location", "Qnt", "Stock", "Stat"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Book List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"book"});
				/*
				Model model=new Model();
				 fillData(model.getInventory("book"));
				*/
			
			}
		});
		btnNewButton.setBounds(726, 448, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(25, 55, 56, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(12, 74, 144, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setBounds(181, 55, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(180, 74, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book ID");
		lblNewLabel_2.setBounds(308, 55, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(308, 74, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("File List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"file"});
				/*
				Model model=new Model();
				 fillData(model.getInventory("file"));
				*/
			}
		});
		btnNewButton_1.setBounds(844, 448, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 427, 338, 364);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row2=table_1.getSelectedRow();
							
      					String add4=table_1.getValueAt(row2,0).toString();
						textField_3.setText(add4);
						String add5=table_1.getValueAt(row2,1).toString();
						textField_4.setText(add5);
					
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "ID", "Address", "Birth Date", "Phone"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_2 = new JButton("Member List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"member"});
				/*
				Model model1=new Model();
				 fillMData(model1.getMembers());
				 */
				
			}
		});
		btnNewButton_2.setBounds(726, 541, 125, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(649, 55, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(643, 74, 144, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID Number");
		lblNewLabel_4.setBounds(808, 55, 107, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(799, 74, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"back"});
			}
		});
		btnNewButton_3.setBounds(844, 627, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 420, 352, 371);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/////////////////////////////////////////////////////////////////////////////////
				int row3=table_2.getSelectedRow();
				
					String add6=table_2.getValueAt(row3,2).toString();
					observableView.notifyObs(new Object[] {"instock",add6});
				textField_6.setText(add6);
			
			}
		});
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Book ID", "Copy ID", "Stat"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_4 = new JButton("Copy List");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"cpy",textField.getText()});
				/*
				Model model=new Model();
				String name=textField.getText();
				 fillCData(model.getCpy(name));
				 */
			}
		});
		btnNewButton_4.setBounds(726, 492, 125, 25);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("Book");
		lblNewLabel_5.setBounds(12, 109, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Member");
		lblNewLabel_6.setBounds(376, 398, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Copy");
		lblNewLabel_7.setBounds(12, 398, 56, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Time Lent");
		lblNewLabel_8.setBounds(726, 573, 115, 16);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(443, 74, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Copy ID");
		lblNewLabel_9.setBounds(443, 55, 56, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Loan's");
		lblNewLabel_10.setForeground(new Color(50, 205, 50));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(12, 13, 144, 16);
		contentPane.add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"7", "14", "21", "28"}));
		comboBox.setBounds(726, 593, 125, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_6 = new JButton("Lent");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aaa=(String)comboBox.getSelectedItem();
				observableView.notifyObs(new Object[] {"lent", textField.getText(),aaa,textField_2.getText(),textField_6.getText(),textField_3.getText(),textField_4.getText() });
			}
		});
		btnNewButton_6.setBounds(726, 627, 97, 25);
		contentPane.add(btnNewButton_6);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(735, 698, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Copy Instock");
		lblNewLabel_11.setBounds(736, 669, 84, 16);
		contentPane.add(lblNewLabel_11);
	}
	public void fillData(Object[][] data)
	{
		String[] colNames = {"Name","Author","Book_ID","Genre","Pages","qnt","avla","stat"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table.setModel(dtm);
		//table.setEnabled(false);
	}
	public void fillMData(Object[][] data)
	{
		String[] colNames = {"Name","ID","Address","Birth Date","Phone"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table_1.setModel(dtm);
		//table.setEnabled(false);
	}
	public void fillCData(Object[][] data)
	{
		//String[] colNames = {"Name", "Book ID", "Copy ID", "Loaner Name", "Start Date", "Return Date", "Stat"};
		String[] colNames = {"Name", "Book ID", "Copy ID", "Stat"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table_2.setModel(dtm);
		//table.setEnabled(false);
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

public void ins(String a)
{
	textField_5.setText(a);
}
}

