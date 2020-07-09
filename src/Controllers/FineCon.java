
package Controllers;



import java.util.Observable;
import java.util.Observer;


//import Model.BookCpy;
//import Model.Fine;
import Screens.FineM;
import Model.Model;

public class FineCon implements Observer{
	private Screens.FineM page;
	private Model model;
	
	public FineCon(Screens.FineM page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "pay")
		{
			model=new Model();
			model.dellfine((String)obj[1]);
			
		}
		else if((String)obj[0]=="list")
		{
			
				model=new Model();
				 page.fillData(model.getFine());
				
			
		}
		
		else if((String)obj[0] == "back")
		{
		
				page.jump(model.chekA());
			
			
			}
	}
}

