
import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {

	private ArrayList<Robot> robots;
	private Scanner s;
	
	
	public static void main (String[] args) {
		
		int x = 0;
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.startMenu();
			rm.processInput(x);
		} while (x!=6);
		
	}
	
	//constructor for menu
	public RobotMenu()
	{
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int startMenu()
	{
		System.out.println("Welcome to the Robot Control Panel");
		System.out.println("1. Create a Robot");
		System.out.println("2. Display a list of Robots");
		System.out.println("3. Move a Robot");
		System.out.println("4. Rotate a Robot");
		System.out.println("5. Calculate distance between 2 robots");
		System.out.println("6. Exit");
		System.out.println("Please select an option");
		
		int selection = s.nextInt();
		while (selection < 0 || selection > 6)
		{
			System.out.println("Invalid selection. Please try again.");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput (int selection)
	{
		if (selection == 1)
		{
			createRobot();
		}
		else if (selection == 2)
		{
			displayRobots();
		}
		else if (selection == 3)
			//move a selected robot
		{
			displayRobots();
			Robot r = selectRobot();
			r.move();
		}
		else if (selection == 4)
		{
			//rotate a robot
			displayRobots();
			Robot r = selectRobot();
			
			System.out.println("How many degrees would you like to rotate?");
			int rot = s.nextInt();
				while (rot % 90 != 0)
				{
					System.out.println("Invalid value. Please enter a multiple of 90.");
					rot = s.nextInt();
				}
				r.rotate(rot);
		}
		else if (selection == 5)
		{
			//calculate distance between robots
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Now pick another robot to calculate the distance between them.");
			Robot r2 = selectRobot();
			System.out.println("The distance between them is " + r.distanceFrom(r2));
		}
	}
	
	private void displayRobots()
	{
		for (int i = 0; i < robots.size(); i++)
		{
			System.out.println((i+1) + "."+ robots.get(i));
		}
	}
	
	private Robot selectRobot()
	{
		System.out.println("Please select a robot:");
		int selection = s.nextInt();
		while (selection < 1 || selection > robots.size())
		{
			System.out.println("Invalid selection. Try again.");
			selection = s.nextInt();
					
		}
		return robots.get(selection-1);
	}
	
	private void createRobot()
	{
		System.out.println("Please enter the robot's starting x position:");
		int x = s.nextInt();
		System.out.println("Please enter the robot's starting y position:");
		int y = s.nextInt();
		System.out.println("Please enter the robot's starting rotation:");
		int rot = s.nextInt();
			while (rot % 90 != 0)
			{
				System.out.println("Invalid value. Please enter a multiple of 90.");
				rot = s.nextInt();
			}
		System.out.println("Please enter the robot's starting speed:");
		int sp = s.nextInt();
		
		robots.add(new Robot(x, y, rot, sp));
		
	}
	
	
	
	
}
