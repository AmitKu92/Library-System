import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//import static org.junit.jupiter.api.Assertions.*;
import Model.Model;
import Model.Librarian;




import org.junit.jupiter.api.Test;
import Model.Model;

import Model.Librarian;
class SignupLibrarianTesting {

		Model javmodel=new Model();
		Model javmodelcopy=new Model();
		@Test
		void CannotCreateNewUserUserDeatildAlreadyTaken() {
			Librarian junit=new Librarian("Anna","Anna Cohen","123","What is your pet name?","snow");
			javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	        try {
	        	Librarian junitcopy=new Librarian("Anna","Anna Cohen","123","What is your pet name?","snow");
	    		javmodelcopy.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	    	       fail("An error occur program should not allow following actions");
	        }catch(Exception e) {
	        	assertEquals("Cannot created new book:\n1.Book already exists\n2.One or more fields were empty",e.getMessage());
	        }
		
	     	}
		@Test
		void CreateNewUserAlthoghNameIsMissing() {
			try {
			Librarian junit=new Librarian(null,"Oleg Ahron","124","What is your pet name?","snowi");
			javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
		     fail
		     ("An error occur program should not allow following actions");

		}catch(Exception e) {
			assertEquals("Cannot created new book:\n1.Book already exists\n2.One or more fields were empty",e.getMessage());
		}
		}
		
		@Test
		void CreateNewUserAlthoghIdNumberIsMissing() {//
			try {
			Librarian junit=new Librarian("Lihi","Lihi Malca",null,"What is your pet name?","snowi");
			javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
		     fail
		     ("An error occur program should not allow following actions");

		}catch(Exception e) {
			assertEquals("Cannot created new book:\n1.Book already exists\n2.One or more fields were empty",e.getMessage());
		}

		}
		@Test
		void CreateNewUserAlthoghAnswerIsMissing() {
			try {
			Librarian junit=new Librarian("Maor","Maor Eliyahu","523","What is your pet name?",null);
			javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
		     fail
		     ("An error occur program should not allow following actions");

		}catch(Exception e) {
			assertEquals("Cannot created new book:\n1.Book already exists\n2.One or more fields were empty",e.getMessage());		
		}

		}
		
		
		
		

	}
//all tested approved
