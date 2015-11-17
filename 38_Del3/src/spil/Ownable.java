package spil;

public abstract class Ownable extends Field {
	
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



