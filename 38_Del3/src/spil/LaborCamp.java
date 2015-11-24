package spil;

import desktop_resources.GUI;

public class LaborCamp extends Ownable {

	private int baseRent, price;
	private String buy;
	private Player owner;

	public LaborCamp(int price) {
		super(price);
		this.price = price;
		owner = null;
	}

	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public String getFeltBesked() {

		return null;
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public void landOnField(Player player) {
		if(owner == null) {
			buyFieldOption(player);
		} else {
			//Skal man rulle med én 6-sidet terning eller to?
			player.getPlayerAccount().adjustBalance(0);
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