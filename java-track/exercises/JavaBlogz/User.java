package JavaBlogz;

import java.util.regex.Pattern;

public class User {

	private String userName;
	private String hashedPassword;
	
	
	
	
	//static method for hashing password
	private static String hashPassword(String password) {
		return password;
	}
	
	//constructor
	public User (String userName, String password) {
		this.userName = userName;
		this.hashedPassword = User.hashPassword(password);
	}
	
	//is valid password
	public boolean isValidPassword (String password){
		
	}
	
	
	//is valid username
	
	public boolean isValidUsername (String userName) {
		boolean b = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", userName);
		return b;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
