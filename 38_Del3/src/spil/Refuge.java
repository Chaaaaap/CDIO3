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
		GUI.showMessage(getFeltBesked(player));
		pay();
	}

	@Override
	public String getFeltBesked(Player player) {
		return "You landed on "+feltNavn+"\nYou receive "+bonus+"$";
	}
	
	private void pay() {
		player.getPlayerAccount().adjustBalance(bonus);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
	}

}
