package dao;
import java.util.List;

import repository.*;
import transferobjects.*;

public class UserDAO {
	//repository -> to fetch data from database
	BaseRepository ur = new UserRepository(new MySQLRepository());
	BaseRepository mr = new MarksRepository(new MySQLRepository());
	
	
	public User checkUser(String username,String pass) {
		User ch=ur.check(username,pass);
		return ch;
	}
	
	public User searchdetails(String mail) {
		User ma=ur.verify(mail);
		return ma;
	}

	public void modifypass(String encrypted_pass, String mail) {
		ur.modifyP(encrypted_pass,mail);
	}

	public void store(String name, String email, String username, String encrypted_pass) {
		ur.storedata(name,email,username,encrypted_pass);
	}


}
