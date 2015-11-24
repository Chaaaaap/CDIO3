package spil;

public abstract class Ownable extends Felt {
	
	private Player owner;
	private int pris;

	public Ownable(int pris) {
		this.owner = null;
		this.pris = pris;
	}
	
	public abstract int getRent();
	
	public abstract void setOwner(Player player);
	
	public abstract Player getOwner();
	
	public abstract void buyFieldOption(Player player);

	public abstract void landOnField(Player player);
	
	public abstract String getFeltBesked(Player player);

}



