package crs;

public abstract class User {
	
	//Define constructors
	User() {}
//	
	
	private String firstName;
	private String lastName;
	
	private String username;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	
	public void setUsername(String usn) {
		this.username = usn;
	}
	public void setPassword(String psw) {
		this.password = psw;
	}
}

