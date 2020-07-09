

package Controllers;


import java.util.Observable;
import java.util.Observer;

import Model.Member;
import Model.Model;


public class  RemoveLibrarianCon   implements Observer{
	private Screens. RemoveLibrarian page;
	
	private Model model;
	private Member ee;
	public  RemoveLibrarianCon (Screens. RemoveLibrarian page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
	
		 if((String)obj[0]=="show")
		{
			 model=new Model();
			 page.fillMData(model.getUserlist());
			
			 
		}
		else if((String)obj[0]=="delete")
		{
			model=new Model();
			model.delL((String)obj[1]);
			
		}
		
		
	}
}

