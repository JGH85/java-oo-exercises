package JavaBlogz;

import java.util.Date;

public class Post extends Entity{

	private String body;
	private String title;
	private String author;
	
	private Date lastModified;
	//this should be set to final when initialized
	private Date created;

	public Post(){
		super();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
