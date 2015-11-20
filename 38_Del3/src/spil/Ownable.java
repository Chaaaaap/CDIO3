package spil;

public abstract class Ownable extends Felt {
	
	private Player owner;
	private int pris;

	public Ownable(int pris) {
		this.owner = null;
		this.pris = pris;
	}
	
	public abstract int getRent();


	@Override
	public void landOnField(Player player) {
		
		getRent();
	}
}



