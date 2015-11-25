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
	public int getRent(Player player) {
		return baseRent;
	}

	@Override
	public String getFeltBesked(Player player) {
		if(owner == null)
			return  player.getPlayerName()+", you landed on "+feltNavn+".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", you already own this field! Nothing happens.";
	
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\n"+
			owner.getPlayerName()+" is bankrupt, which means you don't have to pay anything!";
		
		else
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\n"+
			player.getPlayerName()+", you rolled "+sum+", therefore you have to pay "+sum*100+" to "+owner.getPlayerName();
	
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
		if(owner == null) {
			buyFieldOption(player);
		} else if(owner.getPlayerName().equalsIgnoreCase(player.getPlayerName())) {
			GUI.showMessage(getFeltBesked(player));
		} else  if (owner.getPlayerAccount().isBankrupt() == true){
			
		} else {
			GUI.getUserButtonPressed("Shake dice to determine how much you should pay!", "Shake Dice Cup!");
			diceCup.shake();
			sum = diceCup.getSumResult();
			player.getPlayerAccount().transfer(owner.getPlayerAccount(), sum*100);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.setBalance(owner.getPlayerName(), owner.getPlayerAccount().getBalance());
		}
		GUI.showMessage(getFeltBesked(player));
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