import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


 

//import static org.junit.jupiter.api.Assertions.*;
import Model.Model;
import Model.Admin;
//import org.junit.jupiter.api.Test;

class SignupAdminTesting {
	Model javmodel=new Model();
	Model javmodelcopy=new Model();
	@Test
	void CannotCreateNewUserUserDeatildAlreadyTaken() {
		Admin junit=new Admin("Anna","Anna Cohen","123","What is your pet name?","snow");
		javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
		//javmodel.delL("Anna");
        try {
        	Admin junitcopy=new Admin("Anna","Anna Cohen","123","What is your pet name?","snow");
    		javmodelcopy.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
    	       fail("An error occur program should not allow following actions");
        }catch(Exception e) {

        }
	
     	}
	@Test
	void CreateNewUserAlthoghNameIsMissing() {
		try {
		Admin junit=new Admin(null,"Oleg Ahron","124","What is your pet name?","snowi");
		javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	     fail
	     ("An error occur program should not allow following actions");

	}catch(Exception e) {
				
	}
	}
	@Test
	void CreateNewUserAlthoghUserNameIsMissing() {
		try {
		Admin junit=new Admin("Lihi",null,"124","What is your pet name?","snowi");
		javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	     fail
	     ("An error occur program should not allow following actions");

	}catch(Exception e) {
				
	}

	}
	@Test
	void CreateNewUserAlthoghIdNumberIsMissing() {
		try {
		Admin junit=new Admin("Lihi","Lihi Malca",null,"What is your pet name?","snowi");
		javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	     fail
	     ("An error occur program should not allow following actions");

	}catch(Exception e) {
				
	}

	}
	@Test
	void CreateNewUserAlthoghAnswerIsMissing() {
		try {
		Admin junit=new Admin("Maor","Maor Eliyahu","523","What is your pet name?",null);
		javmodel.newUser(junit.get_username(),junit.get_name(),junit.get_password(),junit.get_sec_q(),junit.get_answer(),"1","0000");
	     fail
	     ("An error occur program should not allow following actions");

	}catch(Exception e) {
				
	}

	}
	
}

//all tested approved

