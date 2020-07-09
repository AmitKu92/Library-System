package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.FineCon;
import Controllers.LentCon;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FineM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ObservableView observableView = new ObservableView();
	private Controllers.FineCon controller = new FineCon(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FineM frame = new FineM();
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
	public FineM() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(200, 375, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 35, 378, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row2=table.getSelectedRow();
				
			//		String add4=table.getValueAt(row2,1).toString();
			//	textField.setText(add4);
				//String add5=table.getValueAt(row2,3).toString();
				//textField_1.setText(add5);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fine", "Name", "ID", "Date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Fine");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"list"});
			}
		});
		btnNewButton.setBounds(224, 445, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pay Fine");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"pay",textField.getText()});
			}
		});
		btnNewButton_1.setBounds(333, 445, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ID Number");
		lblNewLabel.setBounds(201, 357, 115, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Pay Fine");
		lblNewLabel_2.setForeground(new Color(199, 21, 133));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 13, 158, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMainA ob=new MenuMainA();
				ob.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(466, 445, 97, 25);
		contentPane.add(btnNewButton_2);
	}
	
	public void fillData(Object[][] data)
	{
		String[] colNames = { "Fine","Name", "ID", "Date"};
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
