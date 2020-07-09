package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.LentCon;
import Controllers.RetCon;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RetM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private ObservableView observableView = new ObservableView();
	private Controllers.RetCon controller = new RetCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetM frame = new RetM();
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
	public RetM() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book/File Return");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 24, 140, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book/File Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(12, 73, 123, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(57, 102, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Book/File ID");
		lblNewLabel_2.setBounds(12, 137, 108, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(57, 166, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Copy ID ");
		lblNewLabel_3.setBounds(12, 201, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(57, 230, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Member name");
		lblNewLabel_4.setBounds(12, 265, 117, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(57, 294, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Member ID");
		lblNewLabel_5.setBounds(12, 329, 161, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(57, 358, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Date of Loan");
		lblNewLabel_6.setBounds(12, 393, 161, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(57, 422, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Date Of Return");
		lblNewLabel_7.setBounds(12, 457, 123, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(57, 486, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 74, 483, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				////////////
				int row=table.getSelectedRow();
				
				String add=table.getValueAt(row,0).toString();
			textField.setText(add);
			String add1=table.getValueAt(row,1).toString();
			textField_1.setText(add1);
			String add2=table.getValueAt(row,2).toString();
			textField_2.setText(add2);
			String add3=table.getValueAt(row,3).toString();
			textField_3.setText(add3);
			String add4=table.getValueAt(row,4).toString();
			textField_4.setText(add4);
			String add5=table.getValueAt(row,5).toString();
			textField_5.setText(add5);
			String add6=table.getValueAt(row,6).toString();
			textField_6.setText(add6);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"B/F Name", "B/F ID", "Copy ID", "Member Name", "Member ID", "Loan Date", "Return Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Loans");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"show" });
				/*
				Model model=new Model();
				//String name=textField.getText();
				 fillData(model.getLents());
				 */
			}
		});
		btnNewButton.setBounds(280, 485, 148, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return Book/File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"ret",textField.getText(),textField_2.getText(),textField_4.getText(),textField_3.getText() });
				/*
				Lent aa=new Lent(textField.getText());
				aa.ser1(textField.getText());
				aa.delb(textField.getText());
				aa.nbook3();
				aa.set_copyID(Integer.parseInt(textField_2.getText()));
				aa.islate(textField_4.getText(),textField_3.getText());
				aa.removeloan(Integer.parseInt(textField_2.getText()));
				*/
			}
		});
		btnNewButton_1.setBounds(440, 485, 176, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				observableView.notifyObs(new Object[] {"back" });
				
			}
		});
		btnNewButton_2.setBounds(651, 485, 97, 25);
		contentPane.add(btnNewButton_2);
	}
	
	
	public void fillData(Object[][] data)
	{
		String[] colNames = {"B/F Name", "B/F ID", "Copy ID", "Member Name", "Member ID", "Loan Date", "Return Date"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table.setModel(dtm);
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


}

