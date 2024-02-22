package dao;
import repository.*;
import transferobjects.*;

public class UserDAO {
	//repository -> to fetch data from database
	BaseRepository ur = new UserRepository(new MySQLRepository());
	BaseRepository mr = new MarksRepository(new MySQLRepository());
	
	
	//transferobjects
	User user = new User();
}
