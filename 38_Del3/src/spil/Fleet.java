package spil;

import desktop_resources.GUI;

public class Fleet extends Ownable {
	
	private final int RENT_1=500, RENT_2=1000, RENT_3=2000, RENT_4=4000;
	private Player player, owner;
	private String buy, feltNavn;
	private int price, rent;
	
	
	public Fleet(int price, String feltNavn) {
		super(price);
		this.price = price;
		this.feltNavn = feltNavn;
		owner = null;
	}

	@Override
	public int getRent(Player player) {

			switch(owner.getFleetCounter(owner)) {
			case 1: rent = RENT_1; break;
			case 2: rent = RENT_2; break;
			case 3: rent = RENT_3; break;
			case 4: rent = RENT_4; break;
			
		}
		return rent;
	}

	@Override
	public String getFeltBesked(Player player) {
		if (owner == null)
			return player.getPlayerName()+" landed on " + feltNavn + ".";
		
		else if (owner.getPlayerName().equalsIgnoreCase(player.getPlayerName()))
			return player.getPlayerName()+", you already own this field! Nothing happens.";
		
		else if (owner.getPlayerAccount().isBankrupt() == true)
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+"\n"+
			owner.getPlayerName()+" is bankrupt, which means you don't have to pay anything!";
		
		else 
			return player.getPlayerName()+", you landed on "+feltNavn+", which is owned by "+owner.getPlayerName()+
			"\n"+owner.getPlayerName()+" owns "+owner.getFleetCounter(owner)+" fleet fields, therefore you have to pay "+
			getRent(owner)+".";
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
		else if (owner.getPlayerAccount().isBankrupt() == true){
			
		} else {
			//Her skal laves lidt kode til at se hvor mange FLEET en player ejer
			System.out.println(owner.getPlayerName()+" har "+owner.getFleetCounter(owner)+" fleets.");
			getRent(owner);
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
			player.addFleetCounter();
			System.out.println(player.getPlayerName()+" har "+player.getFleetCounter(player)+" fleets");
		}
		
	}

}
