package spil;

import desktop_resources.GUI;

public class Refuge extends Felt {
	
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private int bonus;
	private Player player;
	private String feltNavn;
	
	//The Refuge constructor takes two parameters, bonus and feltNavn.
	public Refuge(int bonus, String feltNavn) {
		this.bonus = bonus;
		this.feltNavn = feltNavn;
	}

	//The landOnField method shows the getFeltBesked in the GUI,
	// and add the bonus by the bonus metod.
	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		bonus();
	}

	//Makes the string that is showed in the GUI.
	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", you landed on "+feltNavn+"\nYou receive "+bonus+"$";
	}
	
	//The bonus method add the Refuge fields bonus to the given players account.
	private void bonus() {
		player.getPlayerAccount().adjustBalance(bonus);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
	}

}
