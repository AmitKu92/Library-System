
package Controllers;


import java.util.Observable;
import java.util.Observer;

import Model.User;
import Screens.Forgot;
import Model.Model;

public class ForgotCon implements Observer{
	private Forgot page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	
	public ForgotCon(Screens.Forgot page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "search")
		{
			model.restartA();
			String a=model.Searchq1((String)obj[1]);
			String b=model.Searchq2((String)obj[1]);
			page.Search(a,b);
		}
		else if((String)obj[0] == "retrive")
		{
			String c;
			c=model.Retrive((String)obj[1],(String)obj[2]);
			page.Retrive(c);
				//page.jump(model.chekA());
			
			
			}
	}
}
