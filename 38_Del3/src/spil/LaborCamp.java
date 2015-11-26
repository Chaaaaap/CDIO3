package spil;

import desktop_resources.GUI;

public class LaborCamp extends Ownable {

	private int baseRent, price, sum;
	private String buy, feltNavn;
	private Player owner, player;
	private DiceCup diceCup;

	//The LaborCamp constructor takes price and feltNavn as parameters.
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

	//This method makes the text, that are being showed in the GUI
	//when a player lands on the LaborCamp fields.
	@Override
	public String getFeltBesked(Player player) {
		if(owner == null)
			return  player.getPlayerName()+", you landed on "+feltNavn+".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", you already own this field! Nothing happens.";
	
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+
			", but "+owner.getPlayerName()+" is bankrupt, which means you don't have to pay anything!";
		
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

	//This method is used when a player lands on a LaborCamp field.
	//If the field is not owned by an player, then the player have the buyFieldOption,
	//but if the field is owned, then the player have to pay the rent to the owner.
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

	//This method gives the player the opportunity to buy the LaborCamp field,
	//the given player has landed on.
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