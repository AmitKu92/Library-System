package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;



import java .util.Calendar;

public class BookCpy extends Book{
	private String cpystat;
	private  int copyID;
	private Model javmodel;
	private  String loanname;
	private int cpynum;
	private String lentdate;
	private String lentret;
	
	public BookCpy(String name) {
		
		super(name);
	}
   public void set_copyID(int copyID)
   {
	   this.copyID=copyID;
   }
   public int get_copyID()
   {
	   return copyID;
   }
   
	public void set_cpystat(String cpystat)
	{
		this.cpystat=cpystat;
	}
	
	public String get_cpystat()
	{
		return cpystat;
	}
	
	

	
	public void delb(String a) {
		javmodel=new Model();
		javmodel.IncQ(a);
	}
	public void ser1(String a)
	{
		javmodel=new Model();
		set_name(javmodel.search10(a));
		set_author(javmodel.search1(a));
		set_book_id(javmodel.search2(a));
		set_genre(javmodel.search3(a));
		set_pages(javmodel.search4(a));
		set_loctaion(javmodel.search5(a));
		set_qnt(javmodel.search6(a));
		set_aqnt(javmodel.search7(a));
		set_lentcount(javmodel.search8(a));
		set_stat(javmodel.search11(a));
		set_bof(javmodel.search12(a));
	}
	
	public void newcpy() {
		javmodel=new Model();
	javmodel.newbookcpy(get_name(),get_bookID(),get_genre(),copyID,get_cpystat(),get_bof());
	
	}
	public void nbook() {
			javmodel=new Model();
			javmodel.newtext(get_name(), get_author(), get_bookID(),get_genre(),get_pages(),get_location(),get_qnt()+1,get_aqnt()+1,get_lentcount(),get_stat(),get_bof());
		
	}
	
	
	
	
}
