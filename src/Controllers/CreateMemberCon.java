package Controllers;

import java.util.Observable;
import java.util.Observer;

import Model.Member;
import Model.Model;


public class CreateMemberCon  implements Observer{
	private Screens.CreateMember page;
	
	private Model model;
	private Member ee;
	public CreateMemberCon(Screens.CreateMember page)
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
			 ee=new Member((String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5]);
			 ee.newmember();	        
		}
		else if((String)obj[0] == "back")
		{
		//	if((String)obj[1] == "book")
				page.jump(model.chekA());
			
			
			}
	}
}

