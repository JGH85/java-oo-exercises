package JavaBlogz;

public class Entity {

	private static int uidCounter = 1000;
	private final int uid;
	
	
	//can we just use java.util.UUID.randomUUID() for this??? 
	
	public Entity (){
		//make sure that uid is unique, positive, and final.
		this.uid = uidCounter;
		uidCounter++;
	}
	
	public int getUID(){
		return this.uid;
	}
}
