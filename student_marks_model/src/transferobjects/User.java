package transferobjects;

public class User {
	private boolean present;
	String name,email,password,username;
	public User(boolean present){
		this.present=present;
	}
	
	public boolean getPresent() {
		return present;
	}
}
