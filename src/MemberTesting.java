import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//import static org.junit.jupiter.api.Assertions.*;
//import Model.Model;
//import Model.Member;

//import org.junit.jupiter.api.Test;
import Model.Model;

import Model.Member;
class MemberTesting {
Model javmodel=new Model();
Model javmodelcopy=new Model();
	@Test
  void CannotCreateNewMemberAlreadyExists() {
        Member junit=new Member("Hanna Lev","333","Hagefen3","6/8/1985","0001122");
        javmodel.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));

   try {
       Member junitcopy=new Member("Hanna Lev","333","Hagefen3","6/8/1985","0001122");		
       javmodelcopy.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));
       fail("An error occur program should not allow following actions");
      javmodelcopy.delM("333");
   }catch(Exception e) {
       assertEquals("Member exist ",e.getMessage()); 
	 
 }
	}
	@Test
	void CannotCreateNewMemberMemberNameIsNull(){
		try {
			
			Member junit=new Member(null,"444","Tirush4","6/8/1985","0001122");
	        javmodel.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));
	        fail("An error occur program should not allow following actions");
	        javmodelcopy.delM("444");
		}catch(Exception e) {
			
		       assertEquals("Member exist ",e.getMessage()); 			
			
		}		
	}
	
	@Test
	void CannotCreateNewMemberAdressIsNull(){
		try {
			
			Member junit=new Member("Miri Aharon","512",null,"6/8/1985","0001122");
	        javmodel.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));
	        fail("An error occur program should not allow following actions");
	        javmodelcopy.delM("512");
		}catch(Exception e) {
			
		       assertEquals("Member exist ",e.getMessage()); 			
		}		
	}
	@Test
	void CannotCreateNewMemberBirthDateIsNull(){
		try {
			
			Member junit=new Member("Hanna Lev","333","Hagefen3",null,"0001122");
	        javmodel.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));
	        fail("An error occur program should not allow following actions");	
	        javmodelcopy.delM("333");
		}catch(Exception e) {
			
		       assertEquals("Member exist ",e.getMessage()); 					
		}		
	}
	
	@Test
	void CannotCreateNewMemberPhoneIsNull(){
		try {
			
			Member junit=new Member("Hanna Lev","333","Hagefen3","6/8/1985",null);
	        javmodel.addmember(junit.get_name("Hanna Lev"),junit.get_id_num("333"),junit.get_address("Hagefen3"),junit.get_birth_date("6/8/1985"),junit.get_phone_num("0001122"));
	        fail("An error occur program should not allow following actions");
	        javmodelcopy.delM("333");
		}catch(Exception e) {
			
		       assertEquals("Member exist ",e.getMessage()); 			
		}
		
		
	}	

}

//all tests approved


