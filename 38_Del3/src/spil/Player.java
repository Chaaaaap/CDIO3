package spil;

public class Player 
{
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private PlayerAccount playerAccount;
	private int currentField=1, fleetCounter;

	public Player() 
	{
		playerAccount = new PlayerAccount(30000);
		fleetCounter = 0;
	}

	//Setter method for setting player name.
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	//It simply returns the player name
	public String getPlayerName()
	{
		return playerName;
	}

	public PlayerAccount getPlayerAccount()
	{
		return playerAccount;
	}
	
	public int getCurrentField() {
		return currentField;
	}
	
	public void setCurrentField(int currentField) {
		this.currentField = currentField;
	}
	
	public void addFleetCounter() {
		fleetCounter++;
	}
	
	public int getFleetCounter(Player player) {
		return fleetCounter;
	}
}
