package spil;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	
	public LaborCamp(int pris) {
		super(pris);
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

}
