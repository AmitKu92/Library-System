package Screens;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controllers.CreateFDCpyCon;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateFDCpy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private ObservableView observableView = new ObservableView();
	private Controllers.CreateFDCpyCon controller = new CreateFDCpyCon(this);
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateFDCpy frame = new CreateFDCpy();
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
	public CreateFDCpy() {
		observableView.addObserver(controller);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find Book");
		lblNewLabel.setBounds(42, 47, 80, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 44, 211, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(Enter Book Name Or Book ID)");
		lblNewLabel_1.setBounds(140, 73, 211, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(12, 129, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(12, 179, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"First Draft", "Source", "Edited", "Copy"}));
		comboBox.setBounds(152, 367, 116, 22);
		contentPane.add(comboBox);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( textField.getText()!=" ") {
				observableView.notifyObs(new Object[] {"search", textField.getText() });
				}
				
			}
		});
		btnNewButton.setBounds(399, 43, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText()!=" ") {
				String b=Random();
				observableView.notifyObs(new Object[] {"add", textField.getText(),(String)comboBox.getSelectedItem(),b,"file" });
				}
				
				}
		});
		btnNewButton_1.setBounds(84, 431, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add File Copy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(66, 18, 202, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Location");
		lblNewLabel_3.setBounds(12, 164, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Number of copies");
		lblNewLabel_4.setBounds(12, 100, 110, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(12, 233, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("category");
		lblNewLabel_5.setBounds(12, 209, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"back"});}
		});
		btnNewButton_2.setBounds(235, 431, 97, 25);
		contentPane.add(btnNewButton_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(152, 129, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(152, 179, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Number of Copies in Stock");
		lblNewLabel_6.setBounds(150, 102, 151, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Book Name");
		lblNewLabel_7.setBounds(152, 164, 110, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Book_ID");
		lblNewLabel_8.setBounds(153, 209, 56, 16);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(152, 233, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pages");
		lblNewLabel_9.setBounds(12, 256, 56, 16);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(12, 276, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(152, 276, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Author");
		lblNewLabel_10.setBounds(153, 256, 56, 16);
		contentPane.add(lblNewLabel_10);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(12, 328, 116, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Lent Count");
		lblNewLabel_11.setBounds(12, 299, 80, 16);
		contentPane.add(lblNewLabel_11);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBounds(152, 328, 116, 22);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Classification");
		lblNewLabel_12.setBounds(152, 299, 80, 16);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Type");
		lblNewLabel_13.setBounds(95, 370, 56, 16);
		contentPane.add(lblNewLabel_13);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(472, 117, 357, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row=table.getSelectedRow();
				String add1=table.getValueAt(row,0).toString();
				observableView.notifyObs(new Object[] {"search",add1 });
				textField.setText(add1);
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
		
		JButton btnNewButton_3 = new JButton("File List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				observableView.notifyObs(new Object[] {"file", textField.getText() });
			}
		});
		btnNewButton_3.setBounds(527, 43, 97, 25);
		contentPane.add(btnNewButton_3);
		
		
	}
	public String Random() {
		String rar;
		java.util.Random rd=new java.util.Random();
		rar=(""+rd.nextInt(100000+1));
		return rar;
	}
	
	public void filltext(int a,String b,String c,int d,String e,int f,String g,String h,int i,String j) {
		textField_1.setText(Integer.toString(a));
		textField_2.setText(b);
		textField_3.setText(c);
		textField_4.setText(Integer.toString(d));
		textField_5.setText(e);
		textField_6.setText(Integer.toString(f));
		textField_7.setText(g);
		textField_8.setText(h); 
		textField_9.setText(Integer.toString(i));
		textField_10.setText(j);
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
	
	public void filltwo(int aa,int bb) {
		textField_1.setText(Integer.toString(aa));
		textField_4.setText(Integer.toString(bb));
		observableView.notifyObs(new Object[] {"search", textField.getText() });
		
	}
	public void fillData(Object[][] data)
	{
		String[] colNames = {"Name","Author","Book_ID","Genre","Pages","qnt","avla","stat"};
		DefaultTableModel dtm = new DefaultTableModel(data, colNames);
		table.setModel(dtm);
		//table.setEnabled(false);
	}
	
	
}
