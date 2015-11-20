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
import desktop_fields.iBuilder;
import desktop_fields.Start.Builder;
import desktop_resources.GUI;

public class GameBoard {
	
	private static Field[] fields = new Field[40];
	
	public static void createFields(){
		//Creates the fields, making them ready to plot into the GUI.
				
				fields[0] = new Start.Builder().setBgColor(Color.RED).build();
				
				for(int i=1; i < 11 ; i++) {
					Field greyField = new Street.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				}
				
				for(int i=11; i < 13 ; i++) {
					Field greyField = new Refuge.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				}
				
				for(int i=13; i < 15 ; i++) {
					Field greyField = new Brewery.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				}
				
				for(int i=15; i < 17 ; i++) {
					Field greyField = new Tax.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				}
				
				for(int i=17; i < 40 ; i++) {
					Field greyField = new Shipping.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				}
				
	}
	
	public static void initFields() {
		GameBoard.fields[0].setTitle("Start"); GameBoard.fields[0].setDescription("All players start here.");
		GameBoard.fields[1].setTitle("Tribe Encampment"); GameBoard.fields[1].setDescription("Territory\nPrice: 1000");
		GameBoard.fields[2].setTitle("Crater"); GameBoard.fields[2].setDescription("Territory\nPrice: 1500");
		GameBoard.fields[3].setTitle("Mountain"); GameBoard.fields[3].setDescription("Territory\nPrice: 2000");
		GameBoard.fields[4].setTitle("Cold Desert"); GameBoard.fields[4].setDescription("Territory\nPrice: 3000");
		GameBoard.fields[5].setTitle("Black Cave"); GameBoard.fields[5].setDescription("Territory\nPrice: 4000");
		GameBoard.fields[6].setTitle("The Werewall"); GameBoard.fields[6].setDescription("Territory\nPrice: 4300");
		GameBoard.fields[7].setTitle("Mountain Village"); GameBoard.fields[7].setDescription("Territory\nPrice: 4750");
		GameBoard.fields[8].setTitle("South Citadel"); GameBoard.fields[8].setDescription("Territory\nPrice: 5000");
		GameBoard.fields[9].setTitle("Palace gates"); GameBoard.fields[9].setDescription("Territory\nPrice: 5500");
		GameBoard.fields[10].setTitle("Tower"); GameBoard.fields[10].setDescription("Territory\nPrice: 6000");
		GameBoard.fields[11].setTitle("Castle"); GameBoard.fields[11].setDescription("Territory\nPrice: 8000");
		GameBoard.fields[12].setTitle("Walled City"); GameBoard.fields[12].setDescription("Refuge\nYou receive 5000");
		GameBoard.fields[13].setTitle("Monastery"); GameBoard.fields[13].setDescription("Refuge\nYou receive 500");
		GameBoard.fields[14].setTitle("Huts in the mountain"); GameBoard.fields[14].setDescription("Labor camp\nPrice: 2500");
		GameBoard.fields[15].setTitle("The pit"); GameBoard.fields[15].setDescription("Labor camp\nPrice: 2500");
		GameBoard.fields[16].setTitle("Goldmine"); GameBoard.fields[16].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets");
		GameBoard.fields[17].setTitle("Caravan"); GameBoard.fields[17].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets");
		GameBoard.fields[18].setTitle("Second Sail"); GameBoard.fields[18].setDescription("Fleet\nPrice: 4000");
		GameBoard.fields[19].setTitle("Sea Grover"); GameBoard.fields[19].setDescription("Fleet\nPrice: 4000");
		GameBoard.fields[20].setTitle("The Buccaneers"); GameBoard.fields[20].setDescription("Fleet\nPrice: 4000");
		GameBoard.fields[21].setTitle("Privateer armade"); GameBoard.fields[21].setDescription("Fleet\nPrice: 4000");
		GameBoard.fields[22].setTitle("Tribe Encampment"); GameBoard.fields[22].setDescription("Territory\nPrice: 1000");
		GameBoard.fields[23].setTitle("Crater"); GameBoard.fields[23].setDescription("Territory\nPrice: 1500");
		GameBoard.fields[24].setTitle("Mountain"); GameBoard.fields[24].setDescription("Territory\nPrice: 2000");
		GameBoard.fields[25].setTitle("Cold Desert"); GameBoard.fields[25].setDescription("Territory\nPrice: 3000");
		GameBoard.fields[26].setTitle("Black Cave"); GameBoard.fields[26].setDescription("Territory\nPrice: 4000");
		GameBoard.fields[27].setTitle("The Werewall"); GameBoard.fields[27].setDescription("Territory\nPrice: 4300");
		GameBoard.fields[28].setTitle("Mountain Village"); GameBoard.fields[28].setDescription("Territory\nPrice: 4750");
		GameBoard.fields[29].setTitle("South Citadel"); GameBoard.fields[29].setDescription("Territory\nPrice: 5000");
		GameBoard.fields[30].setTitle("Palace gates"); GameBoard.fields[30].setDescription("Territory\nPrice: 5500");
		GameBoard.fields[31].setTitle("Tower"); GameBoard.fields[31].setDescription("Territory\nPrice: 6000");
		GameBoard.fields[32].setTitle("Castle"); GameBoard.fields[32].setDescription("Territory\nPrice: 8000");
		GameBoard.fields[33].setTitle("Walled City"); GameBoard.fields[33].setDescription("Refuge\nYou receive 5000");
		GameBoard.fields[34].setTitle("Monastery"); GameBoard.fields[34].setDescription("Refuge\nYou receive 500");
		GameBoard.fields[35].setTitle("Huts in the mountain"); GameBoard.fields[35].setDescription("Labor camp\nPrice: 2500");
		GameBoard.fields[36].setTitle("The pit"); GameBoard.fields[36].setDescription("Labor camp\nPrice: 2500");
		GameBoard.fields[37].setTitle("Goldmine"); GameBoard.fields[37].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets");
		GameBoard.fields[38].setTitle("Caravan"); GameBoard.fields[38].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets");
		GameBoard.fields[39].setTitle("Second Sail"); GameBoard.fields[39].setDescription("Fleet\nPrice: 4000");
	}
	
	public static void initGUI() 
	{

		GUI.create(fields);
		GUI.showMessage("Welcome to Monopoly Jr!\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	

	}

}

