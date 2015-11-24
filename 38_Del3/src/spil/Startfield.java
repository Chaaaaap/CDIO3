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
		
	}

	@Override
	public String getFeltBesked() {
		return "You landed on Start";
	}


}



