package Model;



	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Date;

	import javax.swing.JOptionPane;

	public class Book extends Text_prof {
	    private  int bookID;
		private String genre;//genre of the book/file
		private Model javmodel;
		

		public Book(String name){
			super(name);
			}
		
		public int get_bookID()
		{
			return bookID;
		}
		
		public void set_book_id(int bookID)
		{
			this.bookID = bookID;
		}
		
		
		
		 public String get_genre()
			{
				return genre;
			}
			
			public void set_genre(String genre)
			{
				this.genre = genre;
			}
			
			public void newbook() {
				javmodel=new Model();
				javmodel.newtext(get_name(), get_author(), get_bookID(),get_genre(),get_pages(),get_location(),0,0,0,get_stat(),get_bof());
			}
			
			
		
		
	}



