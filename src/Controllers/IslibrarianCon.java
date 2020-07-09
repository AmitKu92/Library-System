package Controllers;




import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.BookCpy;
import Model.Librarian;
import Model.Model;
import Screens.MenuMain;
import Screens.MenuMainA;



public class IslibrarianCon implements Observer{
	private MenuMain page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	private BookCpy qq;
	public IslibrarianCon(MenuMain page)
	{
		this.page = page;
		model = new Model();

	}
	


	@Override
	public void update(Observable o, Object arg1)
	{
		Object[] obj = (Object[])arg1;
		if((String)obj[0] == "add")
		{
			Librarian Librarian_info=new Librarian(null,null,null,null,null);
			JOptionPane.showMessageDialog(null,Librarian_info.classification());
			
		}
		
	}
}
