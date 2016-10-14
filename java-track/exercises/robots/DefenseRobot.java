package robots;

import java.util.ArrayList;

public class DefenseRobot extends Robot implements RobotBehavior {
	
		
	public DefenseRobot (int positionX, int positionY, int orientation, int speed, int attackStrength, int defenseStrength){
		
		super(positionX, positionY, orientation, speed, attackStrength, defenseStrength);
		
	}
	
	public void heal(int amount)
	{
		this.health +=amount;
	}
	
	
	public String defend (Robot r2) 
	{
		String result;
		if (this.health == 0)
		{
			result = "0 Health. You're dead. Sorry.";
			return result;
		}
		if (this.distanceFrom(r2)>3.0)
		{
			
			if (this.health < 10)
			{
				this.health +=1;
				result = "No immediate threats detected. Healed up 1pt.";
			}
			else
			{
				result = "No immediate threats detected. At max health.";

			}
		}
		else 
		{
			this.rotate(90);
			this.move();
			result = "You tried to run away. Current health=" + this.health + ", threat distance=" + this.distanceFrom(r2);
		}
		return result;
	}
	
		
	@Override
	public String doNextMove(Robot r2) {
		// TODO Auto-generated method stub
		return this.defend(r2);
	}
	
	
	
	
	
	public static void main (String[] args) {
		
		
		System.out.println("hello");
		AttackRobot a1 = new AttackRobot (1, 2, 90, 2, 2, 2);
		DefenseRobot d1 = new DefenseRobot (0, 0, 90, 2, 2, 2);
		// 	AttackRobot attacker3 = new AttackRobot (5, 5, 90, 2, 3, 1);

		/*System.out.println(attacker1.toString());
		System.out.println(attacker1.distanceFrom(attacker2));
		System.out.println(attacker1.attack(attacker2));
		System.out.println(attacker1.attack(attacker3));
		System.out.println(attacker2.attack(attacker3));
		attacker2.move();
		attacker2.rotate(270);
		attacker2.move();*/

	//	ArrayList<RobotBehavior> fighters = new ArrayList<RobotBehavior>();
	//	fighters.add(a1);
	//	fighters.add(d1);
		
		while (d1.health > 0 && a1.health > 0)
		{
			System.out.println("Attack: " + a1.doNextMove(d1));
			System.out.println("Defense: " + d1.doNextMove(a1));
		}
		String victor = "";
		if (d1.health == 0 && a1.health == 0) {
			victor = "You are both dead. It's a tie.";
		}
		else if (d1.health == 0) {
			victor = "Attacker wins!";
		}
		else if (a1.health == 0) {
			victor = "Defender wins!";
		}
		
		System.out.println("The battle is over. " + victor );
		
		//System.out.println(attacker2.canAttack(attacker3));
		

	}

	
	
	
	
	
	
	

}
