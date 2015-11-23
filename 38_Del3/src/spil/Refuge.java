package spil;

import desktop_resources.GUI;

public class Refuge extends Felt {
	
	private int bonus;
	private Player player;
	private String feltNavn;
	
	public Refuge(int bonus, String feltNavn) {
		this.bonus = bonus;
		this.feltNavn = feltNavn;
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked());
		pay();
	}

	@Override
	public String getFeltBesked() {
		return "Du landede på "+feltNavn+"\nDu modtager "+bonus+"$";
	}
	
	private void pay() {
		player.getPlayerAccount().adjustBalance(bonus);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
	}

	@Override
	public int getPrice() {
		return 0;
	}

}
