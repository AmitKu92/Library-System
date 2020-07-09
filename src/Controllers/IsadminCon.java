package Controllers;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Model.Admin;
import Model.BookCpy;
import Model.Model;
import Screens.MenuMainA;



public class IsadminCon implements Observer{
	private MenuMainA page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	private BookCpy qq;
	public IsadminCon(MenuMainA page)
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
			Admin admin_info=new Admin(null,null,null,null,null);
			JOptionPane.showMessageDialog(null,admin_info.classification());
			
		}
		
	}
}
