package spil;

import desktop_resources.GUI;

public class Startfield extends Felt {


	private Player player;
	private String feltNavn;

	public Startfield(String feltNavn) {
		this.feltNavn = feltNavn;
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
	}

	@Override
	public String getFeltBesked(Player player) {
		return "You landed on Start";
	}

}



