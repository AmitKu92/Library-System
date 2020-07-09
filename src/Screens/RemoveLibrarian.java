package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controllers.RemoveLibrarianCon;
import Controllers.RetCon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RemoveLibrarian extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ObservableView observableView = new ObservableView();
	private RemoveLibrarianCon controller = new RemoveLibrarianCon(this);
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveLibrarian frame = new RemoveLibrarian();
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
	public RemoveLibrarian() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				observableView.notifyObs(new Object[] {"show" });
			}
		});
		btnNewButton.setBounds(199, 39, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"delete",textField.getText() });
			}
		});
		btnNewButton_1.setBounds(319, 39, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuMainA ob=new MenuMainA();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(428, 39, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Delete Librarian");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 13, 134, 16);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 73, 361, 382);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
               
				int row=table.getSelectedRow();
				String add=table.getValueAt(row,0).toString();
			textField.setText(add);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username", "Name", "Admin"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(581, 99, 194, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(582, 73, 103, 16);
		contentPane.add(lblNewLabel_1);
	}
	
	public void fillMData(Object[][] data)
	{
		String[] colNames = {"Username","Name","Admin"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table.setModel(dtm);
		//table.setEnabled(false);
	}
}
