package spil;

public class Fleet extends Ownable {
	
	private Player player;
	private String owner;
	
	public Fleet(int pris) {
		super(pris);
	}

	private int RENT_1=500, RENT_2=1000, RENT_3=2000, RENT_4=4000;

	@Override
	public int getRent() {
		
		return 0;
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
		return player;
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}

}
