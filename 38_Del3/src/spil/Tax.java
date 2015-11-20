package spil;

import desktop_resources.GUI;

public class Tax extends Felt {
	
	private String Tax;
	private int Pay;
	

	private int taxAmount, taxRate = -1;

	@Override
	public void landOnField(Player player) {
		GUI.showMessage("Du landede på Tax");
		payTax();
	}

	private void payTax() {
		Tax = GUI.getUserButtonPressed("Choose between paying 2000 or 10% of your assets.", "2000", "10%");
		Pay = Integer.parseInt(Tax);
	}
	@Override
	public String getFeltBesked() {
		// TODO Auto-generated method stub
		return null;
	}

}
