package spil;

import desktop_resources.GUI;

public class Tax extends Felt {
	
	public Tax() {

	}

	private int taxAmount, taxRate = -1;

	@Override
	public void landOnField(Player player) {
		GUI.showMessage("Du landede på Tax");
	}

}
