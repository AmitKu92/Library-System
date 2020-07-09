package Controllers;

 



import java.util.Observable;
import java.util.Observer;

import Model.User;
import Model.Librarian;
import Model.Admin;
import Screens.signup;
import Screens.MenuMain;
import Screens.MenuMainA;
import Model.Model;

public class signupCon implements Observer{
	private signup page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	private Admin aa;
	private Librarian bb;
	
	public signupCon(Screens.signup page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "Enter")
		{
			if((String)obj[1] == "Admin")
			{
				aa=new Admin((String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5],(String)obj[6]);
			}
			else if((String)obj[1] == "Librarian")
			{
				bb=new Librarian((String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5],(String)obj[6]);
			}
		}
		else if((String)obj[0] == "back")
		{
			page.jump(model.chekA());
				//page.jump(model.chekA());
			
			
			}
	}
}
