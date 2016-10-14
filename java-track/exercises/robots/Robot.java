package robots;

public class Robot {
        
    // robot attributes
    // three fields
    //private String name;
    private int speed;
    protected int positionX;
    protected int positionY;
    private int orientation;
    protected int health;
    protected int attackStrength;
	protected int defenseStrength;    
   
        
    //methods to make:
    
    //constructor
    
    // robot class constructor
    public Robot (int positionX, int positionY, int orientation, int speed, int attackStrength, int defenseStrength) {
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
        this.health = 10;
		this.attackStrength = attackStrength;
		this.defenseStrength = defenseStrength;
    }
    
    //get positionX, positionY, orientation, speed
    
    
    public int getDefenseStrength()
	{
		return this.defenseStrength;
	}
	
    
    public int getSpeed()
    {
    	return this.speed;
    }
    public int getX()
    {
    	return this.positionX;
    }
    public int getY()
    {
    	return this.positionY;
    }
    public int getOrientation()
    {
    	return this.orientation;
    }
    public int getHealth()
    {
    	return this.health;
    }
    public void setHealth(int amount)
    {
    	this.health = amount;
    }
    
    public void setSpeed(int amount)
    {
    	this.speed = amount;
    }
   
    //rotate
    
    public void rotate(int rotationAmount) 
    {
    	if (rotationAmount%90 != 0)
    	{
    		System.out.println("invalid rotationAmount");
    	} 
    	else 
    	{
    	this.orientation = (this.orientation + rotationAmount)%360;
    	}
    }
    
    //move method
    public void move ()
    {
    	if (orientation == 0)
    	{
    		this.positionY = this.positionY + this.speed;
    	}
    	else if (orientation == 90)
    	{
        	this.positionX = this.positionX + this.speed;
    	}
    	else if (orientation == 180)
    	{
        	this.positionY = this.positionY - this.speed;
    	}
    	else if (orientation == 270)
    	{
        	this.positionX = this.positionX - this.speed;
    	}
    	
    }
    
    //to string method
    
    public String toString()
    {
    	return "Speed: " + this.speed + " Orientation: " + this.orientation + " PositionX: " + this.positionX + " PositionY: " + this.positionY + " Health: " + this.health;
    }
    
    //distance from another point
    public double distanceFrom (Robot robotB)
    {
    	double dX = (this.getX() - robotB.getX());
    	double dY = (this.getY() - robotB.getY());
    	double d = Math.sqrt(dX*dX + dY*dY);
    	return d;
    	
    }
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		Robot myRobot = new Robot(5, 4, 90, 2, 0, 0);
		Robot yourRobot = new Robot(0, 0, 90, 2, 0, 0);
		
		System.out.println(myRobot.toString());
		myRobot.rotate(540);
		myRobot.setSpeed(5);
		myRobot.move();
		System.out.println(myRobot.toString());
		System.out.println(myRobot.distanceFrom(yourRobot));
	}
    }


	
