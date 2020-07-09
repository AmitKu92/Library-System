package Model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Librarian extends User {
	
	private String worker_id;
	private Model javmodel;
	
	public Librarian(String username,String name,String password,String sec_q,String answer)
	{
		super(username,name,password,sec_q,answer);
		StakeholdersType=new Itlibrarian();
	}
	public void authorization_details(Authorization Itlibrarian) {
		
		JOptionPane.showMessageDialog(null,this);
	}
public void set_worker_id(String worker_id)
{
this.worker_id=worker_id;	
}
public String get_worker_id()
{
	return worker_id;
}


public void newLibrarian()
{
	javmodel=new Model();
	javmodel.newUser(get_username(),get_name(),get_password(),get_sec_q(),get_answer(),"0",Random());
}

	public String Random() {
		String rar;
		java.util.Random rd=new java.util.Random();
		rar=(""+rd.nextInt(1000+1));
		return rar;
	}
	


}
