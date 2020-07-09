package Controllers;


import java.util.Observable;
import java.util.Observer;

import Model.Member;
import Model.Model;


public class MUpdateCon  implements Observer{
	private Screens.MUpdate page;
	
	private Model model;
	private Member ee;
	public MUpdateCon(Screens.MUpdate page)
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
			model=new Model();
			model.delM((String)obj[2]);
			 ee=new Member((String)obj[1],(String)obj[2],(String)obj[3],(String)obj[4],(String)obj[5]);
			 ee.newmember();	        
		}
		else if((String)obj[0]=="member")
		{
			 model=new Model();
			 page.fillMData(model.getMembers());
			
			 
		}
		else if((String)obj[0]=="delete")
		{
			model=new Model();
			model.delM((String)obj[2]);
			
		}
		
		
	}
}

