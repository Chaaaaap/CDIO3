package spil;

import desktop_resources.GUI;

public class Territory extends Ownable {

	private int rent;
	private int price;
	private String feltNavn, string2, buy;
	private Player owner;

	public Territory(int price, int rent, String feltNavn, String string2) {
		super(price);
		this.rent = rent;
		this.feltNavn = feltNavn;
		this.string2 = string2;
		this.owner = null;
	}

	@Override
	public int getRent() {
		return rent;
	}

	public int getPris() {
		return price;
	}

	public void setPris(int pris) {
		this.price = pris;
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
		if(owner == null)
			buyFieldOption(player);
		else 
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), rent);
		
		
	}

	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+price+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-price);
			this.owner = player;
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
		}
	}
	


}




