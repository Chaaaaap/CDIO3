package spil;

public abstract class Ownable extends Felt {
	
	private Player owner;
	private int pris;

	public Ownable() {
		this.owner = null;
	}
	
	public abstract int getRent();


	@Override
	public void landOnField(Player player) {
		
		getRent();
	}
}



