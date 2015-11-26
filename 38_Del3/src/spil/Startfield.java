package spil;

import desktop_resources.GUI;

public class Startfield extends Felt {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private Player player;
	private String feltNavn;

	//The Startfield contructor takes one parameter feltNavn.
	public Startfield(String feltNavn) {
		this.feltNavn = feltNavn;
	}

	//The landOnField method in this class, just shows 
	//the text from the getFeltBesked in the GUI.
	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
	}

	//Makes the string that is showed in the GUI.
	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+" landed on Start";
	}

}



