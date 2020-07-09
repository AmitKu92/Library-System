package Model;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Lent extends BookCpy{
	private Model javmodel;
	private String lentdate;
	private String lentret;
	private Calendar c;
	private int time;
	private String mname;
	private String mid;
	
public Lent(String name) {
		
		super(name);
	}
	
public String get_mname()
{
	return mname;
}

public void set_mname(String mname)
{
	this.mname= mname;
}
public String get_mid()
{
	return mid;
}

public void set_mid(String mid)
{
	this.mid= mid;
}

	
public String get_lentdate()
{
	return lentret;
}

public void set_lentdate(String lentdate)
{
	this.lentdate= lentdate;
}


public String get_lentret()
{
return lentret;
}

public void set_lentret(String lentret)
{
this.lentret = lentret;
}
public int get_time()
{
return time;
}

public void set_time(int time)
{
this.time = time;
}


	
	
	public void currdate()
	{
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		lentdate=formatter.format(date);
		
		
			
		
	}
	

	
	
	
	public void returndate() {
		//String tod=lentdate;
		Date date=new Date();
		c=Calendar.getInstance();
		
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		c.setTime(date);
		c.add(Calendar.DATE,time);
		 lentret=formatter.format(c.getTime());
		
		
	}
	
	
	public void issue() {
		String v="Classified";
		javmodel=new Model();
		if(javmodel.isrented(get_copyID())) {
		if(javmodel.issecret(get_name(),v)) {
			javmodel.lentbook(get_name(),get_bookID(),get_copyID(),mname,mid,lentdate,lentret);
		}
		}
	}
	
	public void nbook2() {
		javmodel=new Model();
		javmodel.newtext(get_name(), get_author(), get_bookID(),get_genre(),get_pages(),get_location(),get_qnt()-1,get_aqnt(),get_lentcount()+1,get_stat(),get_bof());
	
}
	public void nbook3() {
		javmodel=new Model();
		javmodel.newtext(get_name(), get_author(), get_bookID(),get_genre(),get_pages(),get_location(),get_qnt()+1,get_aqnt(),get_lentcount(),get_stat(),get_bof());
	
}
	public void removeloan(int cpyid) {
		javmodel=new Model();
		javmodel.delloan(cpyid);
	}
	public void islate(String IDNum,String name) {
		javmodel=new Model();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		currdate();
		try {
		//System.out.println(formatter.parse(lentret).before(formatter.parse(lentdate)));
			if(formatter.parse(lentdate).before(formatter.parse(lentret))) {
				javmodel.fine(IDNum,lentdate,name);
			}
		}catch (Exception e) {
			
			
		}
	}
	
}

