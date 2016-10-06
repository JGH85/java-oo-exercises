
public class Student {
	
//class properties
	
	private String nameFirst;
	private String nameLast;
	private int studentID;	
	private int credits;
	private double GPA;
	
	
//constructor
	
	public Student (String nameFirst, String nameLast, int studentID) {
	        this.nameFirst = nameFirst;
	        this.nameLast = nameLast;
	        this.studentID = studentID;
	     //   this.credits = 0;
	      //  this.GPA = 0.00
	    }


//getters
	public String getName() 
	{
		String name = this.nameFirst + " " + this.nameLast;
		return name;
	}
	public int getStudentID()
	{
		return this.studentID;
	}
	public int getCredits()
	{
		return this.credits;
	}
	public double getGPA()
	{
		return this.GPA;
	}
	
	
//setters
	public void setFirstName(String name) 
	{
		this.nameFirst = name;
	}
	public void setLastName(String name) 
	{
		this.nameLast = name;
	}
	public void setStudentID(int id)
	{
		this.studentID = id;
	}
	public void setCredits(int cred)
	{
		this.credits = cred;
	}
	public void setGPA(double gpa)
	{
		this.GPA = gpa;
	}
	
	
//advanced functionality
	//get class standing
	public String getClassStanding()
	{
		String classStanding;
		if (this.credits < 30)
		{
			classStanding = "Freshman";
		} 
		else if (this.credits < 60)
		{
			classStanding = "Sophomore";
		} 
		else if (this.credits < 90)
		{
			classStanding = "Junior";
		} 
		else 
		{
			classStanding = "Senior";
		}
		
		return classStanding;
	}
	//submit grade
	public void submitGrade(double grade, int cred)
	{
		double qualityRaw = this.GPA * this.credits;
		qualityRaw += (grade * cred);
		this.credits += cred;
		this.GPA = Math.round((qualityRaw / this.credits)*1000d)/1000d; 		
	}
	//compute tuition
	public double computeTuition()
	{
		double tPerCredit = 1333.33;
		int semesters = this.credits/15;
		int leftoverCredits = this.credits%15;		
		double tuition = semesters * 20000.0 +  leftoverCredits * tPerCredit;
		return tuition;
	}
	
//legacy student constructor
	public Student (Student s1, Student s2)
	{
		this(s1.getName(), s2.getName(), (s1.getStudentID()+ s2.getStudentID()));
		this.GPA = (s1.GPA + s2.GPA)/2; 
		this.credits = Math.max(s1.credits, s2.credits);
	}
	
	//create legacy
	public Student createLegacy(Student s1, Student s2)
	{
		return new Student(s1, s2);
				
	}
	//toString
	public String toString()
	{
		return (this.nameFirst + " " + this.nameLast + " " + this.studentID);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student A = new Student("Abe", "Lincoln", 1111);
		Student B = new Student("Babe", "Ruth", 2222);
		
		Student baby = A.createLegacy(A, B);
		
		System.out.println(baby.getName());
		System.out.println(baby.getGPA());

		System.out.println(A.getCredits());

		A.submitGrade(1,1);
		A.submitGrade(3.2,5);
		//Yadi.gameOver(2,1);
//		System.out.println(Yadi.toString());
		System.out.println(A.getGPA());
		System.out.println(A.getCredits());
		System.out.println(20000.0/15);

	}

}



