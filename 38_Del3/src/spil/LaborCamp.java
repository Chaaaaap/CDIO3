package spil;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	private String owner;
	
	public LaborCamp(int pris) {
		super(pris);
		owner = null;
	}

	@Override
	public int getRent() {
		return baseRent;
	}

	@Override
	public String getFeltBesked() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOwner(Player player) {
		owner = player.getPlayerName();
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}

}
