package spil;

public class Territory extends Ownable {

	private int rent;
	private int pris;
	private String feltNavn;
	private String string2;
	private Player owner;

	public Territory(int pris, int rent, String feltNavn, String string2) {
		super(pris);
		this.rent = rent;
		this.feltNavn = feltNavn;
		this.string2 = string2;
		this.owner = null;
	}

	@Override
	public int getRent() {
		return rent;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getString1() {
		return feltNavn;
	}

	public void setString1(String string1) {
		this.feltNavn = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String getFeltBesked() {
		
		return null;
	}

	@Override
	public void setOwner(Player player) {
		owner = player;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Player getOwner() {	
		return owner;
	}

	@Override
	public void landOnField(Player player) {
		// TODO Auto-generated method stub
		
	}
	


}




