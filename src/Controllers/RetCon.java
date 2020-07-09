package Controllers;

 





import java.util.Observable;
import java.util.Observer;


import Model.BookCpy;
import Model.Lent;
import Screens.RetM;
import Model.Model;

public class RetCon implements Observer{
	private Screens.RetM page;
	private Model model;
	private BookCpy qq;
	private Lent aa;
	public RetCon(Screens.RetM page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "ret")
		{
			aa=new Lent((String)obj[1]);
			aa.ser1((String)obj[1]);
			aa.delb((String)obj[1]);
			aa.nbook3();
			aa.set_copyID(Integer.parseInt((String)obj[2]));
			aa.islate((String)obj[3],(String)obj[4]);
			aa.removeloan(Integer.parseInt((String)obj[2]));
			
		}
		else if((String)obj[0]=="show")
		{
			
			 model=new Model();
			 page.fillData(model.getLents());
				
			
		}
		
		else if((String)obj[0] == "back")
		{
		
				page.jump(model.chekA());
			
			
			}
	}
}
