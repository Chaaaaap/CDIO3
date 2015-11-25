package spil;

import desktop_resources.GUI;

public class Territory extends Ownable {

	private int rent;
	private int price;
	private String feltNavn, string2, buy;
	private Player owner, player;

	public Territory(int price, int rent, String feltNavn, String string2) {
		super(price);
		this.price = price;
		this.rent = rent;
		this.feltNavn = feltNavn;
		this.string2 = string2;
		this.owner = null;
	}

	@Override
	public int getRent(Player player) {
		return rent;
	}


	@Override
	public String getFeltBesked(Player player) {
		if(owner == null)
			return  player.getPlayerName()+", you landed on "+feltNavn+".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", you already own this field! Nothing happens.";
	
		else 
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\nYou pay "+rent+" for staying the night.";
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
		if(owner == null) {
			buyFieldOption(player);
			
		}
		else {
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), rent);	
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
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




