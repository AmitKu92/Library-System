package Controllers;




import java.util.Observable;
import java.util.Observer;

import Model.Book;
import Screens.MenuMain;
import Screens.MenuMainA;
import Model.Model;

public class CreateFileDocCon implements Observer{
	private Screens.CreateFileDoc page;
	private Model model;
	private Book cc;
	public CreateFileDocCon(Screens.CreateFileDoc page)
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
			cc=new Book((String)obj[1]);
			cc.set_author((String)obj[2]);
			cc.set_genre((String)obj[3]);
			cc.set_book_id(Integer.parseInt((String)obj[4]));
			cc.set_loctaion((String)obj[5]);
			cc.set_stat((String)obj[6]);
			cc.set_bof((String)obj[7]);
			cc.set_pages((String)obj[8]);
			cc.set_genre((String)obj[9]);
	        cc.newbook();
		}
		else if((String)obj[0] == "back")
		{
			//if((String)obj[1] == "book")
				page.jump(model.chekA());
			//else page2.jump(model.chekA());
			
			}
	}
}
