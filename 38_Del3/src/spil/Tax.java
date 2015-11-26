package spil;

import desktop_resources.GUI;

public class Tax extends Felt {
	
	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String Tax, feltNavn;
	private int Pay, taxAmount, taxRate = -1;
	private Player player;
	private String[] strings;
	
	//The Tax constructor takes two parameters tax and feltNavn.
	public Tax(int tax, String feltNavn) {
		taxAmount = tax;
		this.feltNavn = feltNavn;
	}

	
	//This method is used when a player lands on a fleet field.
	//The method shows the getFeltBesked in the GUI and the player
	//pay the taxes. 
	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		payTax();	
	}

	//The payTax method gives the player the opportunity
	//to pay the taxamount of the given Tax field, or to 
	//pay ten percent of the players assets.
	private void payTax() {
		Tax = GUI.getUserButtonPressed("Choose between paying "+taxAmount+" or 10% of your assets.", "Pay "+taxAmount, "Pay "+tenPercent(player));
		Pay = Integer.parseInt(Tax.replaceAll("[\\D]", ""));
		player.getPlayerAccount().adjustBalance(-Pay);
		GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
	}
	
	//Makes the string which is showed in the GUI.
	@Override
	public String getFeltBesked(Player player) {
		return player.getPlayerName()+", you landed on "+feltNavn+".";
	}

	//Calculate ten percent of the current players assets.
	private int tenPercent(Player player) {
		return player.getPlayerAccount().getBalance()/10;
	}


}
