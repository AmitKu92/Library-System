package Model;



import javax.swing.JOptionPane;

public abstract class Text_prof {
	private String name;//name of the book
	private int qnt;//number of overall stock of copies of the book
	private int aqnt;//number of instock copies of the book
	private String author;//name of the author of the book
	
	private String pages;//number of pages inside the book
	private String location;//location in the library
	private int lentcount;//number of time the text was lent
	private String stat;//book,classified,public
	private String bof;//if its a book or file
//// constractor
	public Text_prof(String name){
		this.name = name;
	}
///////lentcount	
	public int get_lentcount()
	{
	return lentcount;	
	}
    public void set_lentcount(int lentcount)
    {
    	this.lentcount=lentcount;
    }
////////////name
	 public String get_name()
	{
		return name;
	}
	
	public void set_name(String name)
	{
		this.name = name;
	}
/////////////////////author	
    public String get_author()
	{
    	return author;
	}
		
	public void set_author(String author)
	{
		this.author = author;
	}
		
//////////////////////////////pages			
	public String get_pages()
	{
		return pages;
	}
				
	public void set_pages(String pages)
	{
		this.pages = pages;
	}
///////////////////////////////////////location	
	public String get_location()
	{
		return location;
	}
					
	public void set_loctaion(String location)
	{
		this.location = location;
	}
////////////////////////////////////////////////////qnt					
	public int get_qnt()
	{
		return qnt;
	}
	public void set_qnt(int qnt)
	{
		this.qnt = qnt;
	}
///////////////////////////////////////////////////////////aqnt
						
	public void set_aqnt(int aqnt)
	{
	this.aqnt = aqnt;
	}
	public int get_aqnt()
	{
	return aqnt;
	}
////////////////////////////////////////////////////////////////stat
	
	public void set_stat(String stat)
	{
		this.stat=stat;
	}
	public String get_stat()
	{
		return stat;
	}
/////////////////////////////////////////////////////////////////////bof	
	public void set_bof(String bof)
	{
		this.bof=bof;
	}
	public String get_bof()
	{
		return bof;
	}
}
