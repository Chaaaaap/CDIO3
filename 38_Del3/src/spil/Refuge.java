package spil;

import desktop_resources.GUI;

public class Refuge extends Felt {
	
	private int bonus;
	
	public Refuge(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public void landOnField(Player player) {
		GUI.showMessage("Du er landet på Refuge");
	}

}
