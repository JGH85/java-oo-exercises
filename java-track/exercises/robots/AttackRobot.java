package robots;

public class AttackRobot extends Robot implements RobotBehavior {
	
		
	public AttackRobot (int positionX, int positionY, int orientation, int speed, int attackStrength, int defenseStrength){
		
		super(positionX, positionY, orientation, speed, attackStrength, defenseStrength);
		
	}
	
	public void heal(int amount)
	{
		this.health +=amount;
	}
	
	
	public String attack (Robot r2) 
	{
		String result;
		if (this.distanceFrom(r2)>3.0)
		{
			this.rotate(90);
			this.move();
			result = "Sorry, you are too far away to attack. Repositioning. Now at X:" + this.positionX  + " Y:" + this.positionY;
		}
		else 
		{
			this.health -= r2.defenseStrength;
			r2.health -= this.attackStrength;
			result = "Attack successful. New health=" + this.health + ", opponent's health=" + r2.health;
		}
		return result;
	}
	
	public String canAttack (Robot r2) 
	{
		String result;
		double distance = this.distanceFrom(r2);
		if (distance > 3.0)
		{
			result = "Sorry, you are " + distance + " away, which is too far to attack.";
		}
		else 
		{
			result = "Yay! You are " + distance + " away, which is close enough to attack.";
		}
		return result;
	}
	
	@Override
	public String doNextMove(Robot r2) {
		// TODO Auto-generated method stub
		return this.attack(r2);
	}
	
	
	
	
	
	public static void main (String[] args) {
		
		System.out.println("hello");
		AttackRobot attacker2 = new AttackRobot (2, 2, 90, 2, 1, 3);
		AttackRobot attacker1 = new AttackRobot (0, 0, 90, 2, 2, 2);
		AttackRobot attacker3 = new AttackRobot (5, 5, 90, 2, 3, 1);

		System.out.println(attacker1.toString());
		System.out.println(attacker1.distanceFrom(attacker2));
		System.out.println(attacker1.attack(attacker2));
		System.out.println(attacker1.attack(attacker3));
		System.out.println(attacker2.attack(attacker3));
		attacker2.move();
		attacker2.rotate(270);
		attacker2.move();

		System.out.println(attacker2.canAttack(attacker3));

	}

	
	
	
	
	
	
	

}
