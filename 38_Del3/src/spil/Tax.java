package spil;

import desktop_resources.GUI;

public class Tax extends Felt {
	
	private String Tax, feltNavn;
	private int Pay, taxAmount, taxRate = -1;
	private Player player;
	private String[] strings;
	
	public Tax(int tax, String feltNavn) {
		taxAmount = tax;
		this.feltNavn = feltNavn;
	}

	

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		payTax();
		
	}

	private void payTax() {
		Tax = GUI.getUserButtonPressed("Choose between paying "+taxAmount+" or 10% of your assets.", "Pay "+taxAmount, "Pay "+tenPercent(player));
		Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
		player.getPlayerAccount().adjustBalance(-Pay);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
		
	}
	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+" landed on "+feltNavn+".";
	}

	private int tenPercent(Player player) {
		return player.getPlayerAccount().getBalance()/10;
	}


}
