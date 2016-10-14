package cordillera;

public class Card {
	
	//values that need to be passed in to constructor
	private String race;
	private String name;
	private int cardValue;
	private int attackMod;
	private int defenseMod;
	private int movementMod;
	private int recruitMod;

	//values that will be calculated
	private int attackValue;
	private int defenseValue;
	private int movementCost;
	private int recruitCost;
	
	//values that control state of card
	private boolean inHand;
	private boolean onBoard;
	private boolean isAlive;
	private boolean abilityUsed;
	
	//values that are only needed once the card is played
	private int recruitmentStatus;
	private int positionX;
	private int positionY;
	
	public Card (String race, 
				 String name, 
				 int cardValue, 
				 int attackMod,
				 int defenseMod,
				 int movementMod,
				 int recruitMod)
	{
		this.race = race;
		this.name = name;
		this.cardValue = cardValue;
		this.attackMod = attackMod;
		this.defenseMod = defenseMod;
		this.movementMod = movementMod;
		this.recruitMod = recruitMod;
		
		//TODO add error checking for illicit number of modifications
			//sum of 4 mod values and check if they equal proper number based on card strength.
		
		//calculate actual values
		this.attackValue = this.cardValue + this.attackMod;
		this.defenseValue = this.cardValue + this.defenseMod;
		this.movementCost = this.cardValue - this.movementMod;
		this.recruitCost = this.cardValue + this.recruitMod;

		//set values that are not passed in as parameters
		this.inHand = true;
		this.onBoard = false;
		this.isAlive = true;
		this.abilityUsed = false;
		
	}
	
	
	
	
	//methods to make
	
	
	//get methods
	
	//set methods
	
	//recruit card
	
	//play card on board
	
	//check if space is empty
	
	//move card on board
	
	//attack another card
	
	//attack with 2 cards
	
	//speed up recruitment
	
	//swap cards
	
	
	
	//display hand
	
	//display recruitment
	
	//display board
	
	//preview of battle result
	
	//preview of movement cost
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
