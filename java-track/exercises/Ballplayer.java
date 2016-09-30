
public class Ballplayer {

	private String name;
	private int playerNumber;
	private String handed;
	private String team;
	private Integer runs;
	private Integer rbi;
	private Integer games;
	
	public Ballplayer (String name, int playerNumber, String handed, String team) {
		this.name = name;
		this.playerNumber = playerNumber;
		this.handed = handed;
		this.team = team;
		this.runs = 0;
		this.rbi = 0;
		this.games = 0;
	}
	
	
	public void gameOver(int runs, int rbi) {
		this.games ++;
		this.runs += runs;
		this.rbi += rbi;
	}
	
	
	public String toString(){
		return (this.name + ": Games:" + this.games + " Runs:"+ this.runs + " RBI:"+ this.rbi + ".");
	}
	
	
 	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ballplayer Yadi = new Ballplayer("Yadi", 4, "right", "Cardinals");
		
		System.out.println(Yadi.toString());
		Yadi.gameOver(2,1);
		System.out.println(Yadi.toString());

		
	}

}
