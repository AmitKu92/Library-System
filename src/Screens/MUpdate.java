package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.CreateMemberCon;
import Controllers.MUpdateCon;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtPhoneNumber;
	private JTable table;
	private ObservableView observableView = new ObservableView();
	private Controllers.MUpdateCon controller = new MUpdateCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUpdate frame = new MUpdate();
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
	public MUpdate() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Member Info");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 25, 175, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(25, 90, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(26, 72, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(25, 149, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID Number");
		lblNewLabel_2.setBounds(26, 132, 81, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 209, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(26, 190, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(25, 280, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth");
		lblNewLabel_4.setBounds(26, 263, 81, 16);
		contentPane.add(lblNewLabel_4);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBounds(25, 335, 116, 22);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setBounds(25, 315, 110, 16);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 100, 346, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				
				
				
				
					
	
						String add1=table.getValueAt(row,0).toString();
						textField.setText(add1);
						String add2=table.getValueAt(row,1).toString();
						textField_1.setText(add2);
						String add3=table.getValueAt(row,2).toString();
						textField_2.setText(add3);
						String add4=table.getValueAt(row,3).toString();
						textField_3.setText(add4);
						String add5=table.getValueAt(row,4).toString();
						txtPhoneNumber.setText(add5);
						
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "ID", "Address", "Birth Date", "Phone"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"Enter",textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),txtPhoneNumber.getText() });
			}
		});
		btnNewButton.setBounds(333, 402, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMainA ob=new MenuMainA();
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(467, 402, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show Members");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"member"});
			}
		});
		btnNewButton_2.setBounds(303, 68, 261, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Member");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"delete",textField_1.getText()});
			}
		});
		btnNewButton_3.setBounds(211, 402, 97, 25);
		contentPane.add(btnNewButton_3);
	}
	
	public void fillMData(Object[][] data)
	{
		String[] colNames = {"Name","ID","Address","Birth Date","Phone"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table.setModel(dtm);
		//table.setEnabled(false);
	}

}
