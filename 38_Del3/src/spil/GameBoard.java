package spil;

import java.awt.Color;

import desktop_fields.Empty;
import desktop_fields.Brewery;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Tax;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Street;
import desktop_resources.GUI;

public class GameBoard {
	Field[] guiFields;
	Felt[] logicFields;
	
	public GameBoard() {
		guiFields = createGUIFields();
		createGUIFields();
		initFields();
		logicFields = createLogicFields();
//		createLogicFields();
		initGUI();
	}
	
	
	private Felt[] createLogicFields() {
		
		return null;
	}


	private Field[] createGUIFields(){
		//Creates the fields, making them ready to plot into the GUI.
				Field[] newGuiFields = new Field[40];
				newGuiFields[0] = new Start.Builder().setBgColor(Color.RED).build();
				
				for(int i=1; i < 11 ; i++) {
					Field greyField = new Street.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				
				for(int i=11; i < 13 ; i++) {
					Field greyField = new Refuge.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				
				for(int i=13; i < 15 ; i++) {
					Field greyField = new Brewery.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				
				for(int i=15; i < 17 ; i++) {
					Field greyField = new Tax.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				
				for(int i=17; i <= 21 ; i++) {
					Field greyField = new Shipping.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				
				for(int i=22; i < 40; i++) {
					Field greyField = new Empty.Builder().setBgColor(Color.GRAY).build();
					newGuiFields[i] = greyField;
				}
				return guiFields;
				
	}
	//Plotting the title and descriptopn in to the fields.
	private void initFields() {
		guiFields[0].setTitle("Start"); guiFields[0].setDescription("All players start here.");
		guiFields[1].setTitle("Tribe Encampment"); guiFields[1].setDescription("Territory\nPrice: 1000");
		guiFields[2].setTitle("Crater"); guiFields[2].setDescription("Territory\nPrice: 1500");
		guiFields[3].setTitle("Mountain"); guiFields[3].setDescription("Territory\nPrice: 2000");
		guiFields[4].setTitle("Cold Desert"); guiFields[4].setDescription("Territory\nPrice: 3000");
		guiFields[5].setTitle("Black Cave"); guiFields[5].setDescription("Territory\nPrice: 4000");
		guiFields[6].setTitle("The Werewall"); guiFields[6].setDescription("Territory\nPrice: 4300");
		guiFields[7].setTitle("Mountain Village"); guiFields[7].setDescription("Territory\nPrice: 4750");
		guiFields[8].setTitle("South Citadel"); guiFields[8].setDescription("Territory\nPrice: 5000");
		guiFields[9].setTitle("Palace gates"); guiFields[9].setDescription("Territory\nPrice: 5500");
		guiFields[10].setTitle("Tower"); guiFields[10].setDescription("Territory\nPrice: 6000");
		guiFields[11].setTitle("Castle"); guiFields[11].setDescription("Territory\nPrice: 8000");
		guiFields[12].setTitle("Walled City"); guiFields[12].setDescription("Refuge\nYou receive 5000");
		guiFields[13].setTitle("Monastery"); guiFields[13].setDescription("Refuge\nYou receive 500");
		guiFields[14].setTitle("Huts in the mountain"); guiFields[14].setDescription("Labor camp\nPrice: 2500");
		guiFields[15].setTitle("The pit"); guiFields[15].setDescription("Labor camp\nPrice: 2500");
		guiFields[16].setTitle("Goldmine"); guiFields[16].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets");
		guiFields[17].setTitle("Caravan"); guiFields[17].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets");
		guiFields[18].setTitle("Second Sail"); guiFields[18].setDescription("Fleet\nPrice: 4000");
		guiFields[19].setTitle("Sea Grover"); guiFields[19].setDescription("Fleet\nPrice: 4000");
		guiFields[20].setTitle("The Buccaneers"); guiFields[20].setDescription("Fleet\nPrice: 4000");
		guiFields[21].setTitle("Privateer armade"); guiFields[21].setDescription("Fleet\nPrice: 4000");
		guiFields[22].setTitle("Tribe Encampment"); guiFields[22].setDescription("Territory\nPrice: 1000");
		guiFields[23].setTitle("Crater"); guiFields[23].setDescription("Territory\nPrice: 1500");
		guiFields[24].setTitle("Mountain"); guiFields[24].setDescription("Territory\nPrice: 2000");
		guiFields[25].setTitle("Cold Desert"); guiFields[25].setDescription("Territory\nPrice: 3000");
		guiFields[26].setTitle("Black Cave"); guiFields[26].setDescription("Territory\nPrice: 4000");
		guiFields[27].setTitle("The Werewall"); guiFields[27].setDescription("Territory\nPrice: 4300");
		guiFields[28].setTitle("Mountain Village"); guiFields[28].setDescription("Territory\nPrice: 4750");
		guiFields[29].setTitle("South Citadel"); guiFields[29].setDescription("Territory\nPrice: 5000");
		guiFields[30].setTitle("Palace gates"); guiFields[30].setDescription("Territory\nPrice: 5500");
		guiFields[31].setTitle("Tower"); guiFields[31].setDescription("Territory\nPrice: 6000");
		guiFields[32].setTitle("Castle"); guiFields[32].setDescription("Territory\nPrice: 8000");
		guiFields[33].setTitle("Walled City"); guiFields[33].setDescription("Refuge\nYou receive 5000");
		guiFields[34].setTitle("Monastery"); guiFields[34].setDescription("Refuge\nYou receive 500");
		guiFields[35].setTitle("Huts in the mountain"); guiFields[35].setDescription("Labor camp\nPrice: 2500");
		guiFields[36].setTitle("The pit"); guiFields[36].setDescription("Labor camp\nPrice: 2500");
		guiFields[37].setTitle("Goldmine"); guiFields[37].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets");
		guiFields[38].setTitle("Caravan"); guiFields[38].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets");
		guiFields[39].setTitle("Second Sail"); guiFields[39].setDescription("Fleet\nPrice: 4000");
	}
	
	private void initGUI() 
	{
		GUI.create(guiFields);
		GUI.showMessage("Welcome to Monopoly Jr!\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	
	}

	public void landOnField(int i, Player player){
		logicFields[i].landOnField(player);
	}
	
	public Felt[] getFields() {
		return logicFields;
	}

}

