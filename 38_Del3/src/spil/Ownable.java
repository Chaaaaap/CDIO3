package spil;

public abstract class Ownable extends Felt {
	
	//This is an abstract class that extends from the abstract Felt class.
	//the class is abstract because other classes have to extend
	//from this class. Its the body of all classes, that are ownable.
	private Player owner;
	private int pris;

	public Ownable(int pris) {
		this.owner = null;
		this.pris = pris;
	}
	
	//Abstract methods. 
	//These methods are being overrided in the subclasses.
	public abstract int getRent(Player player);
	
	public abstract void setOwner(Player player);
	
	public abstract Player getOwner();
	
	public abstract void buyFieldOption(Player player);

	public abstract void landOnField(Player player);
	
	public abstract String getFeltBesked(Player player);

}



