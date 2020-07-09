package Controllers;


import java.util.Observable;
import java.util.Observer;

import Model.User;
import Screens.Login;
import Screens.MenuMain;
import Screens.MenuMainA;
import Model.Model;

public class LoginCon implements Observer{
	private Login page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	
	public LoginCon(Screens.Login page)
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
			model.restartA();
			if(model.log((String)obj[1],(String)obj[2])) {
				page.jump(model.chekA());
		}
		else if((String)obj[0] == "back")
		{
		
				//page.jump(model.chekA());
			
			
			}
	}
}
}