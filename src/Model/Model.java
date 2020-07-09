package Model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Model {
	
	private Connection conn;
    private	ResultSet rs;
	private PreparedStatement pst;
	private String sql;
	
	
	public Model()
	{
		
		
	}
	///////////////////////////////////////////////////////////////
    public void newUser(String username,String name,String password,String q,String a,String admin,String workID)
  	{
    
	
	if(usernameAV(name)==true)
	{
		conn=javaconnect.ConnecrDb();
		try {
		
			sql="Insert into Account (Username,Name,Password,Sec_Q,Answer,Admin,work_ID) values (?,?,?,?,?,?,?)";
		pst=conn.prepareStatement(sql);
		pst.setString(1,username);
		pst.setString(2,name);
		pst.setString(3,password);
		pst.setString(4,q);
		pst.setString(5,a);
		pst.setString(6,admin);
		pst.setString(7,workID);
		
		pst.execute();
		JOptionPane.showMessageDialog(null, "New Account Created");
		pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Username taken");
	}
   	}
    /////////////////////////////////////////////////////
   	public boolean usernameAV(String name) {
   		conn=javaconnect.ConnecrDb();
        sql="select * from Account where Username=? ";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(1,name);
    		rs=pst.executeQuery();
    		if(rs.next()) {
    			rs.close();
    		    pst.close(); 
    		    return false;
    	    }
    		else {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return true;
    		}
   			
    	}
//////////////////////////////////////////////////////////////
   	public boolean log(String a,String b)
   	{ 
   		conn=javaconnect.ConnecrDb();
   		sql="select * from Account where Username=? and Password=?";
   		try {
   			pst=conn.prepareStatement(sql);
   			
   			pst.setString(1,a);
   			pst.setString(2,b);
   			rs = pst.executeQuery();
   			if(rs.next()) {
   				String ab=rs.getString(6);
   				rs.close();
   			    pst.close();
   			 setA(ab);
   			return true;    
   			}
   			else {
   				JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
   			}
   			
   		}catch(Exception e) {
   			JOptionPane.showMessageDialog(null, e);
   			}
   	finally 
   	{
   		try
   	{
   	rs.close();
   	pst.close();

   	}catch(Exception e) {
   		
   	}
   	}

   	return false;	
   	}
   	
   	//////////////////////////////////////////////////////////
   	public void newtext(String name,String author,int textID,String cata,String page,String loc,int qnt,int aqnt,int count,String stat,String bof) {

		if(bookAV(name,1)==true)
		{
			conn=javaconnect.ConnecrDb();
			try {
				
				String sql="Insert into Book (Name,Author,Book_ID,Genre,Pages,Location,qnt,avla,lentcount,stat,bof) values (?,?,?,?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,author);
			pst.setInt(3,textID);
			pst.setString(4,cata);
			pst.setString(5,page);
			pst.setString(6,loc);
			pst.setInt(7,qnt);
			pst.setInt(8,aqnt);
			pst.setInt(9,count);
			pst.setString(10,stat);
			pst.setString(11,bof);
			
			pst.execute();
			//JOptionPane.showMessageDialog(null, "New Book Created");
			pst.close();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Book exist taken");
		}
   	}
		////////////////////////////////////////////////////
		public void newtext(String name,String author,String textID,String cata,String page,String loc,int qnt,int aqnt,String deg,int count) {

			if(bookAV(name,0)==true)
			{
				conn=javaconnect.ConnecrDb();
				try {
					
					sql="Insert into FileDoc (Name,Author,Book_ID,Cata,pages,Location,qnt,avla,deg,lentcount) values (?,?,?,?,?,?,?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1,name);
				pst.setString(2,author);
				pst.setString(3,textID);
				pst.setString(5,page);
				pst.setString(6,loc);
				pst.setString(4,cata);
				pst.setInt(7, qnt);
				pst.setInt(8, aqnt);
				pst.setString(9,deg);
				pst.setInt(10, count);
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "New File Created");
				pst.close();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "File exist");
			}
		
		}
		
//////////////////////////////////////////////
		
       	
       	public boolean bookAV(String name,int flag) {
       		conn=javaconnect.ConnecrDb();
       		if(flag==1)
	    	sql="select * from Book where Name=? ";
       		else
       		sql="select * from FileDoc where Name=? ";
	    	try {
	    		pst=conn.prepareStatement(sql);
	    		pst.setString(1,name);
	    		rs=pst.executeQuery();
	    		if(rs.next()) {
	    			rs.close();
	    		    pst.close(); 
	    		    return false;
	    	    }
	    		else {
	    			return true;
	    		}
	    		
	    	}catch(Exception e) {
	    		return true;
	    		}
	}

	///////////////////////////////////////////////////
	public void restartA() {
		
		conn=javaconnect.ConnecrDb();
String sql="delete  from IsAdmin where isA=?" ;
		
		try {
			pst=conn.prepareStatement(sql);
		    pst.setInt(1,1);
		    pst.execute();
		    pst.setInt(1,0);
			pst.execute();
		
				pst.close();
				
		
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, "missed");
		}
	}
	
	public boolean chekA()
	{
		
		conn=javaconnect.ConnecrDb();
   		sql="select * from IsAdmin where isA=?";
   		try {
   			pst=conn.prepareStatement(sql);
   			pst.setInt(1,1);
   			rs = pst.executeQuery();
   			if(rs.next()) {
   				rs.close();
   			    pst.close();
   			return true;    
   			}
   			else {
   				rs.close();
   			   	pst.close();
   			   	return false;
   			}
   			
   		}catch(Exception e) {
   			JOptionPane.showMessageDialog(null, e);
   			}
   		return false;
   	}
	//////////////////////////////////////////////////////////////////
	public void setA(int num)
	{ 
		conn=javaconnect.ConnecrDb();
		try {
			
			sql="Insert into IsAdmin (isA) values (?)";
		pst=conn.prepareStatement(sql);
		pst.setInt(1,num);
	
		
		pst.execute();
		pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	/////////////////////////////
	public void setA(String num)
	{
		//JOptionPane.showMessageDialog(null, num);

		conn=javaconnect.ConnecrDb();
		try {
			int num1=Integer.parseInt(num);
			//JOptionPane.showMessageDialog(null, num1);
			
			sql="Insert into IsAdmin (isA) values (?)";
		pst=conn.prepareStatement(sql);
		pst.setInt(1,num1);
	
		
		pst.execute();
		pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	//////////////////////////////

	public void IncQ(String a2) {
		conn=javaconnect.ConnecrDb();
		
		String sql="delete from Book where Name=?" ;
		
		try {
			pst=conn.prepareStatement(sql);
		    pst.setString(1,a2);
			pst.execute();
		
				pst.close();
				
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null, "missed");
		}
		
		
	}
	///////////////////////////////////////////////////////////////////////////
	public String search1(String a1)//author
	{
		conn=javaconnect.ConnecrDb();
		String ret;
		String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		if(rs.next()) {
			ret=rs.getString(2);
		rs.close();
		pst.close();
		return ret;
		}
	else {
		JOptionPane.showMessageDialog(null, "No book found");
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"miss");
	}

		return " ";
	}
	public int search2(String a1)//Book id
	{
		conn=javaconnect.ConnecrDb();
		int ret;
		String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		if(rs.next()) {
			ret=rs.getInt(3);
		rs.close();
		pst.close();
		return ret;
		}
	else {
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"miss");
	}

		return 0;
	}
	
	public String search3(String a1)//genre
	{
		conn=javaconnect.ConnecrDb();
		String ret;
		String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		if(rs.next()) {
			ret=rs.getString(4);
		rs.close();
		pst.close();
		return ret;
		}
	else {
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"miss");
	}

		return " ";
	}
		
	public String search4(String a1)//pages
	{
		conn=javaconnect.ConnecrDb();
		String ret;
		String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		if(rs.next()) {
			ret=rs.getString(5);
		rs.close();
		pst.close();
		return ret;
		}
	else {
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"miss");
	}

		return " ";
	}

	public String search5(String a1)//location
	{
		conn=javaconnect.ConnecrDb();
		String ret;
		String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
		if(rs.next()) {
			ret=rs.getString(6);
		rs.close();
		pst.close();
		return ret;
		}
	else {
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"miss");
	}
		return " ";
	}


public int search6(String a1)//qnt
{
	conn=javaconnect.ConnecrDb();
	int ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getInt(7);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return 0;
}


public int search7(String a1)//aqnt
{
	conn=javaconnect.ConnecrDb();
	int ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getInt(8);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return 0;
}


public int search8(String a1)//lentcount
{
	conn=javaconnect.ConnecrDb();
	int ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getInt(9);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return 0;
}

public String search10(String a1)//name
{
	conn=javaconnect.ConnecrDb();
	String ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getString(1);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return " ";
}

public String search11(String a1)//stat
{
	conn=javaconnect.ConnecrDb();
	String ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getString(10);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return " ";
}

public String search12(String a1)//location
{
	conn=javaconnect.ConnecrDb();
	String ret;
	String sql="select * from Book where Name='"+a1+"' or Book_ID='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
		ret=rs.getString(11);
	rs.close();
	pst.close();
	return ret;
	}
else {
}
}catch(Exception e) {
	JOptionPane.showMessageDialog(null,"miss");
}
	return " ";
}


///////////////////////////////////////////////////
public void newbookcpy(String name,int bookid,String genre,int cpynum,String stat,String bop) {


	conn=javaconnect.ConnecrDb();
	try {
		
		String sql3="Insert into BookCpy (Name,Book_ID,Genre,CpyNum,member,LoanS,LoanR,stat,bof) values (?,?,?,?,?,?,?,?,?)";
	pst=conn.prepareStatement(sql3);
	pst.setString(1,name);
	pst.setInt(2,bookid);
	pst.setString(3,genre);
	pst.setInt(4,cpynum);
	pst.setString(5," ");
	pst.setString(6," ");
	pst.setString(7," ");
	pst.setString(8,stat);
	pst.setString(9,bop);
	pst.execute();
	pst.close();
	
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
	
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////

public void addmember(String name,String id_num,String address,String birth,String phone) {////add new member

	if(memberAV(id_num)==true)
	{
		conn=javaconnect.ConnecrDb();
		try {
			
			String sql3="Insert into Member (Name,ID_Number,Address,Date_Of_Birth,Phone) values (?,?,?,?,?)";
		pst=conn.prepareStatement(sql3);
		pst.setString(1,name);
		pst.setString(2,id_num);
		pst.setString(3,address);
		pst.setString(4,birth);
		pst.setString(5,phone);
		
		
		pst.execute();
		JOptionPane.showMessageDialog(null, "New Member Created");
		pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Member exist ");
	}
   	}
   	public boolean memberAV(String id_num) {///check if there is a member with the same id number
   		conn=javaconnect.ConnecrDb(); 
    	String sql="select * from Member where ID_Number=? ";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(2,id_num);
    		rs=pst.executeQuery();
    		if(rs.next()) {
    			rs.close();
    		    pst.close(); 
    		    return false;
    	    }
    		else {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return true;
    		}
}
   	
   	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	
   	public Object[][] getInventory(String bof)
	{
   		conn=javaconnect.ConnecrDb(); 
		sql = "select * from Book where bof='" + bof + "'";
		List<String[]> data = new ArrayList<String[]>();
		Object[][] result;
		int count = 0;
		int i = 0;
		
		try { 
			pst=conn.prepareStatement(sql);
    		rs=pst.executeQuery();
			while(rs.next()) 
			{
				data.add(new String[] {rs.getString("Name"),rs.getString("Author"),rs.getString("Book_ID"),rs.getString("Genre"),rs.getString("Pages"),rs.getString("qnt"),rs.getString("avla"),rs.getString("stat")});
				count++;
			}
			    pst.close(); 
			    rs.close();
		} catch (Exception e) {
		}
		try 
		{
		} 
		catch(Exception e)
		{
		}
		if(count==0) {
			result = new Object[count+1][];
			}
			else result = new Object[count][];
		//result = new Object[count][];
		result[i] = new Object[8];
		
		for (String[] strings : data) 
		{
			result[i] = new Object[strings.length];
			for(int j = 0; j < strings.length; j++)
			{
				result[i][j] = strings[j];
			}
			i++;
		}
		
		return result;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	public Object[][] getMembers()
	{
   		conn=javaconnect.ConnecrDb(); 
		sql = "select * from Member";
		List<String[]> data1 = new ArrayList<String[]>();
		Object[][] result1;
		int count = 0;
		int i = 0;
		
		try { 
			
			pst=conn.prepareStatement(sql);
    		rs=pst.executeQuery();
			
			while (rs.next()) 
			{
				
				data1.add(new String[] {rs.getString("Name"),rs.getString("ID_Number"),rs.getString("Address"),rs.getString("Date_Of_Birth"),rs.getString("Phone")});
				count++;
			}
			 pst.close(); 
			   rs.close();
		} catch (Exception e) {
		}
		try 
		{ 
		} 
		catch(Exception e)
		{
		}
		if(count==0) {
			result1 = new Object[count+1][];
			}
			else result1 = new Object[count][];
	//	result1 = new Object[count][];
		result1[i] = new Object[5];
		
		for (String[] strings : data1) 
		{
			result1[i] = new Object[strings.length];
			for(int j = 0; j < strings.length; j++)
			{
				result1[i][j] = strings[j];
			}
			i++;
		}
		
		return result1;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	public Object[][] getCpy(String name)
	{
   		conn=javaconnect.ConnecrDb(); 
		sql = "select * from BookCpy where name='" + name + "'";
		List<String[]> data1 = new ArrayList<String[]>();
		Object[][] result1;
		int count = 0;
		int i = 0;
		
		try { 
			
			pst=conn.prepareStatement(sql);
    		rs=pst.executeQuery();
			
			while (rs.next()) 
			{
				data1.add(new String[] {rs.getString("Name"),rs.getString("Book_ID"),rs.getString("CpyNum"),rs.getString("stat")});
				count++;
			}
			 pst.close(); 
			   rs.close();
		} catch (Exception e) {
		}
		try 
		{   
		} 
		catch(Exception e)
		{
		}
		if(count==0) {
		result1 = new Object[count+1][];
		}
		else result1 = new Object[count][];
		result1[i] = new Object[4];
		
		for (String[] strings : data1) 
		{
			result1[i] = new Object[strings.length];
			for(int j = 0; j < strings.length; j++)
			{
				result1[i][j] = strings[j];
			}
			i++;
		}
		
		return result1;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	public boolean isrented(int cpyid) {
   		conn=javaconnect.ConnecrDb();
        sql="select * from Loan where CpyID=? ";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setInt(3,cpyid);
    		rs=pst.executeQuery();
    		if(rs.next()) {
    			rs.close();
    		    pst.close(); 
    		    JOptionPane.showMessageDialog(null, "copy is taken");
    		    return false;
    	    }
    		else {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return true;
    		} 		
    	}	

	public boolean issecret(String bookname,String bookstat) {
   		conn=javaconnect.ConnecrDb();
        sql="select * from Book where CpyID=? and stat=? ";
    	try {
    		pst=conn.prepareStatement(sql);
    		pst.setString(10,bookstat);
    		pst.setString(1,bookname);
    		rs=pst.executeQuery();
    		if(rs.next()) {
    			rs.close();
    		    pst.close(); 
    		    JOptionPane.showMessageDialog(null, "file is classified");
    		    return false;
    	    }
    		else {
    			return true;
    		}
    		
    	}catch(Exception e) {
    		return true;
    		}
   		
    	
	}
	///////////////////////////////////////////////////////
	public void lentbook(String name,int bookID,int copyID,String mname,String mid,String lentdate,String lentret) {
		conn=javaconnect.ConnecrDb();
		try {
		
			sql="Insert into Loan (Name,BookID,CpyID,M_Name,M_ID,LoanS,LoanR) values (?,?,?,?,?,?,?)";
		pst=conn.prepareStatement(sql);
		pst.setString(1,name);
		pst.setInt(2,bookID);
		pst.setInt(3,copyID);
		pst.setString(4,mname);
		pst.setString(5,mid);
		pst.setString(6,lentdate);
		pst.setString(7,lentret);
		
		pst.execute();
		JOptionPane.showMessageDialog(null, "New Book has been lent");
		pst.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}	
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	public Object[][] getLents()
	{
   		conn=javaconnect.ConnecrDb(); 
		sql = "select * from Loan";
		List<String[]> data1 = new ArrayList<String[]>();
		Object[][] result1;
		int count = 0;
		int i = 0;
		
		try { 
			
			pst=conn.prepareStatement(sql);
    		rs=pst.executeQuery();
			
			while (rs.next()) 
			{
				data1.add(new String[] {rs.getString("Name"),rs.getString("BookID"),rs.getString("CpyID"),rs.getString("M_Name"),rs.getString("M_ID"),rs.getString("LoanS"),rs.getString("LoanR")});
				count++;
			}
			 pst.close(); 
			   rs.close();
		} catch (Exception e) {
		}
		try 
		{   
		} 
		catch(Exception e)
		{
		}
		if(count==0) {
			result1 = new Object[count+1][];
			}
			else result1 = new Object[count][];
		//result1 = new Object[count][];
		result1[i] = new Object[7];
		
		for (String[] strings : data1) 
		{
			result1[i] = new Object[strings.length];
			for(int j = 0; j < strings.length; j++)
			{
				result1[i][j] = strings[j];
			}
			i++;
		}
		
		return result1;
	}

///////////////////////////////////////////////////
public void delloan(int num) {
	
	conn=javaconnect.ConnecrDb();
String sql="delete  from Loan where CpyID='"+num+"'" ;
	
	try {
		pst=conn.prepareStatement(sql);
	    pst.execute();
			pst.close();
	}catch(Exception e) 
	{
		JOptionPane.showMessageDialog(null, "missed");
	}
}
/////////////////////////////////////////////////////////////////////////////////////////
public void fine(String idnum,String date,String name)
{
	conn=javaconnect.ConnecrDb();
	try {
		
		String sql="Insert into Book (Fine,Name,ID,Date) values (?,?,?,?)";
	pst=conn.prepareStatement(sql);
	pst.setInt(1,50);
	pst.setString(2,name);
	pst.setString(3,idnum);
	pst.setString(4,date);
	
	
	pst.execute();
	JOptionPane.showMessageDialog(null, "New Book Created");
	pst.close();
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Object[][] getFine()
{
		conn=javaconnect.ConnecrDb(); 
	sql = "select * from Fine";
	List<String[]> data1 = new ArrayList<String[]>();
	Object[][] result1;
	int count = 0;
	int i = 0;
	
	try { 
		
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) 
		{
			data1.add(new String[] {rs.getString("Fine"),rs.getString("Name"),rs.getString("ID"),rs.getString("Date")});
			count++;
		}
		 pst.close(); 
		   rs.close();
	} catch (Exception e) {
	}
	try 
	{ 
	} 
	catch(Exception e)
	{
	}
	if(count==0) {
		result1 = new Object[count+1][];
		}
		else result1 = new Object[count][];
	//result1 = new Object[count][];
	result1[i] = new Object[4];
	
	for (String[] strings : data1) 
	{
		result1[i] = new Object[strings.length];
		for(int j = 0; j < strings.length; j++)
		{
			result1[i][j] = strings[j];
		}
		i++;
	}
	
	return result1;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void dellfine(String idn) {
	
	conn=javaconnect.ConnecrDb();
String sql="delete  from Fine where ID='"+idn+"'" ;
	
	try {
		pst=conn.prepareStatement(sql);
	    pst.execute();
			pst.close();
			
	}catch(Exception e) 
	{
		JOptionPane.showMessageDialog(null, "missed");
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public String Searchq1(String a1) {
	String a;
	String sql="select * from Account where Username='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
	a=rs.getString(2);
		rs.close();
		pst.close();
	}
	else {
		JOptionPane.showMessageDialog(null, "Incorrect Username");
		 a=" ";
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,e);
		a=" ";
	}
	return a;
}

public String Searchq2(String a1) {
	String a;
	String sql="select * from Account where Username='"+a1+"'";
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
	if(rs.next()) {
	a=rs.getString(4);
		rs.close();
		pst.close();
	}
	else {
		JOptionPane.showMessageDialog(null, "Incorrect Username");
		 a=" ";
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,e);
		a=" ";
	}
	return a;
}


public String Retrive(String a1,String a2) {
	String sql="select * from Account where Answer='"+a2+"'and Username='"+a1+"'" ;
	String a;
	try {
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		if(rs.next()) {
		a=rs.getString(3);
			rs.close();
			pst.close();
			
		}
		else {JOptionPane.showMessageDialog(null, "Incorrect Answer");
		a=" ";}
	}catch(Exception e) 
	{
		JOptionPane.showMessageDialog(null, e);
		a=" ";
	}
	return a;
	
}
/////////////////////////////////////////

public boolean islent2(String b)
{
	conn=javaconnect.ConnecrDb();
    sql="select * from Loan where M_Name=? ";
	try {
		//String b=String.valueOf(a);
		pst=conn.prepareStatement(sql);
		pst.setString(4, b);
		rs=pst.executeQuery();
		if(rs.next()) {
			rs.close();
		    pst.close(); 
		    return false;
	    }
		else {
	//		return true;
		}
		
	}catch(Exception e) {
		
		}
	return true;
}

////////////////////////////////////////////////////////////////////////////////////////////////
public boolean islent(String a)
	{ 
		conn=javaconnect.ConnecrDb();
		sql="select * from Loan where CpyID=?";
		try {
			pst=conn.prepareStatement(sql);
			
			pst.setString(1,a);
			rs = pst.executeQuery();
			if(rs.next()) {
				rs.close();
			    pst.close();
			return false;    
			}
			else {
				//JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
	

	return true;	
	}


//////////////////////////////////////////////////////
public void delM(String a) {
	
	conn=javaconnect.ConnecrDb();
String sql="delete  from Member where ID_Number=?" ;
	
	try {
		pst=conn.prepareStatement(sql);
	    pst.setString(2,a);
	    pst.execute();
	
			pst.close();
			
	
	}catch(Exception e) 
	{
		JOptionPane.showMessageDialog(null, "missed");
	}
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Object[][] getUserlist()
{
		conn=javaconnect.ConnecrDb(); 
	sql = "select * from Account where Admin='"+"0"+"' ";
	List<String[]> data1 = new ArrayList<String[]>();
	Object[][] result1;
	int count = 0;
	int i = 0;
	
	try { 
		
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) 
		{
			data1.add(new String[] {rs.getString("Username"),rs.getString("Name"),rs.getString("Admin")});
			count++;
		}
		 pst.close(); 
		   rs.close();
	} catch (Exception e) {
	}
	try 
	{ 
	} 
	catch(Exception e)
	{
	}
	if(count==0) {
		result1 = new Object[count+1][];
		}
		else result1 = new Object[count][];
	//result1 = new Object[count][];
	result1[i] = new Object[3];
	
	for (String[] strings : data1) 
	{
		result1[i] = new Object[strings.length];
		for(int j = 0; j < strings.length; j++)
		{
			result1[i][j] = strings[j];
		}
		i++;
	}
	
	return result1;
}
	//////////////////////////////////////////////
public void delL(String a) {
	
	conn=javaconnect.ConnecrDb();
String sql="delete  from Account where Username=?" ;
	
	try {
		pst=conn.prepareStatement(sql);
	    pst.setString(1,a);
	    pst.execute();
	
			pst.close();
			
	
	}catch(Exception e) 
	{
		JOptionPane.showMessageDialog(null, "missed");
	}
}

	
	
}


