package Model;



import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;


	public class javaconnect {
	static Connection conn=null;
	
	public static Connection ConnecrDb() {
		try {
		if(conn==null) {
			Class.forName("org.sqlite.JDBC");
			//Connection conn=DriverManager.getConnection("jdbc:sqlite:sqlproj.sqlite");
			conn=DriverManager.getConnection("jdbc:sqlite:sqlproj2.sqlite");
		}
			return conn;
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
		 
		
	}
	
	
}
 