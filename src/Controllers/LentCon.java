package Controllers;



import java.util.Observable;
import java.util.Observer;


import Model.BookCpy;
import Model.Lent;
import Screens.LentM;
import Model.Model;

public class LentCon implements Observer{
	private Screens.LentM page;
	private Model model;
	private BookCpy qq;
	private Lent aa;
	public LentCon(Screens.LentM page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "lent")
		{
			model=new Model();
			if(model.islent((String)obj[4])) {
				if(model.islent2((String)obj[5])) {
			aa=new Lent((String)obj[1]);
			aa.set_time(Integer.parseInt((String)obj[2]));
			aa.set_book_id(Integer.parseInt((String)obj[3]));
			aa.set_copyID(Integer.parseInt((String)obj[4]));
			aa.set_mname((String)obj[5]);
			aa.set_mid((String)obj[6]);
			aa.currdate();
			aa.returndate();
			 //JOptionPane.showMessageDialog(null,aa.get_lentdate());
			 //JOptionPane.showMessageDialog(null,aa.get_lentret());
			aa.issue();
			aa.ser1((String)obj[1]);
			aa.delb((String)obj[1]);
			aa.nbook2();
				}
			}
			
		}
		else if((String)obj[0]=="file")
		{
			
				model=new Model();
				 page.fillData(model.getInventory((String)obj[0]));
				 
			
		}
		
		else if((String)obj[0]=="instock")
		{
			
				model=new Model();
				if(model.islent((String)obj[1])) {
					 page.ins("yes");
				 }
				 else page.ins("no");
				
			
		}
		
		else if((String)obj[0]=="book")
		{
			
				model=new Model();
				 page.fillData(model.getInventory((String)obj[0]));
				
			
		}
		
		else if((String)obj[0]=="member")
		{
			 model=new Model();
			 page.fillMData(model.getMembers());
			
			 
		}
		else if((String)obj[0]=="cpy")
		{
			model=new Model();
			String name=(String)obj[1];
			 page.fillCData(model.getCpy(name));
		}
		else if((String)obj[0] == "back")
		{
		
				page.jump(model.chekA());
			
			
			}
	}
}
