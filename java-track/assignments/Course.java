
public class Course {

//class properties
	
	private String name;
	private int	credits;
	private int seatsRemaining;	
	private Student[] roster;
		
		
//constructor
		
	public Course (String name, int credits, int seats) {
		    this.name = name;
		    this.credits = credits;
		    this.roster = new Student[seats];
		    this.seatsRemaining = seats;
		    }

//getters
	public String getName() 
	{
		return this.name;
	}
	public int getCredits()
	{
		return this.credits;
	}
	public int getRemainingSeats()
	{
		return this.seatsRemaining;
	}	
	
	
//special methods
	public Boolean addStudent(Student s)
	{
		Boolean newStudent = true;
		Boolean added = false;
		for (int i=0; i < this.roster.length; i++)
		{
			if (this.roster[i] != null) {
				if (this.roster[i].getName()==s.getName()) {
				newStudent = false; }
			}
		}
			
		if (newStudent == true && this.seatsRemaining != 0) 
		{
			added = true;
			this.seatsRemaining --;
			for (int i=0; i < this.roster.length; i++)
			{
				if (this.roster[i]==null)
				{
					this.roster[i]=s;
					return added;
				}
			}
		}
		return added;
	}
	
	public String generateRoster()
	{
	String studentRoster = "";
	for (int i=0; i < this.roster.length; i++)
	{
		if (this.roster[i]!= null)
		{
			studentRoster += this.roster[i].getName();
		}
	}
		return studentRoster;	
	}
	
	//generateGPA
	public double averageGPA()
	{
	double average = 0.0;
	int classSize = 0;
		for (int i=0; i < this.roster.length; i++)
		{
		if (this.roster[i]!= null)
		{
			average += this.roster[i].getGPA();
			classSize ++;
		}
		}
		average = average/classSize;
		return average;
	}
	
	//course to string
	public String toString()
	{
		return (this.name + " " + this.credits);
	}	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
