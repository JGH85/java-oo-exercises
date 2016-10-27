package JavaBlogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User extends Entity{

	private String username;
	private String hashedPassword;
	
	
	private static List<User> userList = new ArrayList<User>();
	
	//static method for hashing password
	private static String hashPassword(String password) {
		return password;
	}
	
	
	
	//constructor
	public User (String username, String password) {
		super();
		
		//use isValidUsername to check if username is valid.
		try {
			if (isValidUsername(username)){
				this.username = username;
			} 
			else {
				throw new IllegalArgumentException();
			}
		}
		catch (IllegalArgumentException ex){
			System.out.println("Invalid username.");
		}
		
		this.hashedPassword = User.hashPassword(password);
		userList.add(this);
	}
	
	//TODO - write this method
	//is valid password
	public boolean isValidPassword (String password){
		
		return true;
	}
	
	
	//is valid username
	public boolean isValidUsername (String username) {
		boolean b = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
		return b;
	}
	
	public String toString(){
		return ("UID: " + this.getUID() + "; Username: " + this.username + ".");
	}
	
	public static List<User> getUserList(){
		return userList;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User test = new User ("testname", "password");
		User test2 = new User ("test2", "password");
		User test3 = new User ("test3", "password");
		User test4 = new User ("test4", "password");
		
		System.out.println(test.toString());
		System.out.println(test2.toString());
		System.out.println(test3.toString());
		System.out.println(test4.toString());
		
	}

}
