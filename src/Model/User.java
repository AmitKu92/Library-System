package Model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class  User {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	
private String username;
private String name;
private String password;
private String sec_q;
private String answer;
public Authorization StakeholdersType;
public String classification() {
	
	return StakeholdersType.Stakeholders_type();
}
public void setStakeholders(Authorization newStakeholders_type) {
	
	StakeholdersType=newStakeholders_type;
}


public String get_username() {
	return username;
}
public String get_name() {
	return name;
}
public String get_password() {
	return password;
}
public String get_sec_q() {
	return sec_q;
}
public String get_answer() {
	return answer;
}
public void set_username(String username) {
this.username=username;	
}
public void set_name(String name) {
	this.name=name;
}
public void set_password(String password) {
	this.password=password;
}
public void set_sec_q(String sec_q) {
	this.sec_q=sec_q;
}
public void set_answer(String answer) {
	this.answer=answer;
}
public User(String username,String name,String password,String sec_q,String answer)
{
	this.username=username;
	this.name=name;
	this.password=password;
	this.sec_q=sec_q;
	this.answer=answer;
	
}
public User(String username,String password)
{
	this.username=username;
	this.password=password;
}

private void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}


}

