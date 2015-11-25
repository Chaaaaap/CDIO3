package spil;

import desktop_resources.GUI;

public class Fleet extends Ownable {
	
	private Player player, owner;
	private String buy, feltNavn;
	private int price;
	
	
	public Fleet(int price, String feltNavn) {
		super(price);
		this.price = price;
		this.feltNavn = feltNavn;
		owner = null;
	}

	private int RENT_1=500, RENT_2=1000, RENT_3=2000, RENT_4=4000;

	@Override
	public int getRent(Player player) {
		if(owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return 0;
		else
			switch(owner.getFleetCounter(owner)) {
			case 1: return RENT_1;
			case 2: return RENT_2;
			case 3: return RENT_3;
			case 4: return RENT_4;
			default: return 0;
			}
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
		GUI.showMessage(getFeltBesked(player));
		if(owner == null)
			buyFieldOption(player);
		else
			//Her skal laves lidt kode til at se hvor mange FLEET en player ejer
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), getRent(player));
		
	}

	@Override
	public void buyFieldOption(Player player) {
		buy = GUI.getUserButtonPressed("Do you want to buy this field for "+price+"$?", "Yes","No");
		if(buy.equals("Yes")) {
			player.getPlayerAccount().adjustBalance(-price);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			this.owner = player;
			player.addFleetCounter();
		}
		
	}

}
