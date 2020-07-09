
package Controllers;



import java.util.Observable;
import java.util.Observer;


import Model.BookCpy;
import Screens.CreateFDCpy;
import Model.Model;

public class CreateFDCpyCon implements Observer{
	private Screens.CreateFDCpy page;
	//private Screens.CreateFileDoc page2;
	private Model model;
	private BookCpy qq;
	public CreateFDCpyCon(Screens.CreateFDCpy page)
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
			String a=" ";
			BookCpy qq=new BookCpy(a);
			int c=Integer.parseInt((String)obj[3]);
			qq.set_cpystat((String)obj[2]);
			qq.ser1((String)obj[1]);
			qq.set_copyID(c);
			qq.set_bof((String)obj[4]);
			qq.newcpy();
			qq.delb((String)obj[1]);
			qq.nbook();
			page.filltwo(qq.get_qnt(),qq.get_aqnt());
			
			/*
			 String b=Random();
				String a=" ";
				int c=Integer.parseInt(b);
				BookCpy qq=new BookCpy(a);
				qq.set_copyID(c);
				qq.set_cpystat((String)comboBox.getSelectedItem());
				qq.ser1(textField.getText());
				qq.newcpy();
				qq.delb(textField.getText());
				qq.nbook();
				textField_1.setText(Integer.toString(qq.get_qnt()));
				textField_4.setText(Integer.toString(qq.get_aqnt()));
			 */
			
		}
		else if((String)obj[0]=="search")
		{
			String a="";
			qq=new BookCpy(a);
			qq.ser1((String)obj[1]);
			page.filltext(qq.get_qnt(), qq.get_location(), qq.get_genre(), qq.get_aqnt(), qq.get_name(), qq.get_bookID(), qq.get_pages(), qq.get_author(), qq.get_lentcount(),qq.get_stat());
			
			
			
		}
		else if((String)obj[0]=="file")
		{
			
				model=new Model();
				 page.fillData(model.getInventory((String)obj[0]));
				
			
		}
		else if((String)obj[0] == "back")
		{
		
				page.jump(model.chekA());
			
			
			}
	}
}
