package spil;

import desktop_resources.GUI;

public class LaborCamp extends Ownable {

	private int baseRent, price, sum;
	private String buy, feltNavn;
	private Player owner, player;
	private DiceCup diceCup;

	public LaborCamp(int price, String feltNavn) {
		super(price);
		this.price = price;
		this.feltNavn = feltNavn;
		owner = null;
		diceCup = new DiceCup();
	
	}

	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public String getFeltBesked(Player player) {

		return player.getPlayerName()+" landed on " + feltNavn + ".";
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
	}


	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void landOnField(Player player) {
		this.player = player;
		GUI.showMessage(getFeltBesked(player));
		if(owner == null) {
			buyFieldOption(player);
		} else if(owner.getPlayerName().equalsIgnoreCase(player.getPlayerName())) {
			GUI.showMessage(getFeltBesked(player));
		} else {
			GUI.getUserButtonPressed("Shake dice to determine how much you should pay!", "Shake Dice Cup!");
			diceCup.shake();
			sum = diceCup.getSumResult();
			player.getPlayerAccount().adjustBalance(sum*100);
		}

	}

	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+price+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-price);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
		}
	}

}