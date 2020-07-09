package Model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Member {
	Connection conn;//=javaconnect.ConnecrDb();
	ResultSet rs;
	PreparedStatement pst;
	private Model javmodel;
private String name;
private String address;
private String birth_date;
private String phone_num;
private String id_num;
private String t_book;
	
public Member(String name,String id_num,String address,String birth_date,String phone_num) {
	this.name=name;
	this.address=address;
			this.birth_date=birth_date;
			this.phone_num=phone_num;
			this.id_num=id_num;
}

	public void set_name()
	{
		this.name=name;
	}
	public void set_address()
	{
		this.address=address;
	}
	public void set_birth_date()
	{
		this.birth_date=birth_date;
	}
	public void set_phone_num()
	{
		this.phone_num=phone_num;
	}
	public void set_id_num()
	{
		this.id_num=id_num;
	}
	public void set_t_book()
	{
		this.t_book=t_book;
	}
	public String get_name(String name)
	{
		return name;
	}
	public String get_address(String address)
	{
		return address;
	}
	public String get_birth_date(String birth_date)
	{
		return birth_date;
	}
	public String get_phone_num(String phone_num)
	{
		return phone_num;
	}
	public String get_id_num(String id_num)
	{
		return id_num;
	}
	public String get_t_book(String t_book)
	{
		return t_book;
	}
	
	
	public void newmember() {
      javmodel=new Model();
      javmodel.addmember(name,id_num,address,birth_date,phone_num);
		
	    		            }
	
}

