package Model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;



public class Admin extends User {

	
	PreparedStatement pst;
	private int statues;
	private Model javmodel;
	
	public Admin(String username,String name,String password,String sec_q,String answer)
	{
		super(username,name,password,sec_q,answer);
		StakeholdersType=new Itadmin();
	}
	
	public void authorization_details(Authorization Itadmin) {
		JOptionPane.showMessageDialog(null,this);
	}
	
	
	public void set_statues(int statues)
	{
		this.statues=statues;
	}
	public int get_statues()
	  {
		return statues;
	   }
	
	
	public void newAdmin() {
		javmodel=new Model();
		javmodel.newUser(get_username(),get_name(),get_password(),get_sec_q(),get_answer(),"1","0000");
		
		
		
	}
	

		
      	  
         }


