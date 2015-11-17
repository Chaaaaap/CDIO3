package spil;

import java.awt.Color;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.iBuilder;
import desktop_fields.Start.Builder;
import desktop_resources.GUI;

public class Board {
	
	private static Field[] fields = new Field[22];
	
	public static void createFields(){
		// Creating fields for emptying them on the GUI.
				
				fields[0] = new Start.Builder().setBgColor(Color.RED).build();
				for(int i=1; i < fields.length ; i++)
				{
					Field greyField = new Start.Builder().setBgColor(Color.GRAY).build();
					fields[i] = greyField;
				
				}
	}
	
	public void initFields() {
		Board.fields[0].setTitle("Start"); Board.fields[0].setDescription("All players start here.");
		Board.fields[1].setTitle("Tribe Encampment"); Board.fields[1].setDescription("Territory\nPrice: 1000");
		Board.fields[2].setTitle("Crater"); Board.fields[2].setDescription("Territory\nPrice: 1500");
		Board.fields[3].setTitle("Mountain"); Board.fields[3].setDescription("Territory\nPrice: 2000");
		Board.fields[4].setTitle("Cold Desert"); Board.fields[4].setDescription("Territory\nPrice: 3000");
		Board.fields[5].setTitle("Black Cave"); Board.fields[5].setDescription("Territory\nPrice: 4000");
		Board.fields[6].setTitle("The Werewall"); Board.fields[6].setDescription("Territory\nPrice: 4300");
		Board.fields[7].setTitle("Mountain Village"); Board.fields[7].setDescription("Territory\nPrice: 4750");
		Board.fields[8].setTitle("South Citadel"); Board.fields[8].setDescription("Territory\nPrice: 5000");
		Board.fields[9].setTitle("Palace gates"); Board.fields[9].setDescription("Territory\nPrice: 5500");
		Board.fields[10].setTitle("Tower"); Board.fields[10].setDescription("Territory\nPrice: 6000");
		Board.fields[11].setTitle("Castle"); Board.fields[11].setDescription("Territory\nPrice: 8000");
		Board.fields[12].setTitle("Walled City"); Board.fields[12].setDescription("Refuge\nYou receive 5000");
		Board.fields[13].setTitle("Monastery"); Board.fields[13].setDescription("Refuge\nYou receive 500");
		Board.fields[14].setTitle("Huts in the mountain"); Board.fields[14].setDescription("Labor camp\nPrice: 2500");
		Board.fields[15].setTitle("The pit"); Board.fields[15].setDescription("Labor camp\nPrice: 2500");
		Board.fields[16].setTitle("Goldmine"); Board.fields[16].setDescription("Tax\nChoose between paying 2000 or 10% of your total assets");
		Board.fields[17].setTitle("Caravan"); Board.fields[17].setDescription("Tax\nChoose between paying 4000 or 10% of your total assets");
		Board.fields[18].setTitle("Second Sail"); Board.fields[18].setDescription("Fleet\nPrice: 4000");
		Board.fields[19].setTitle("Sea Grover"); Board.fields[19].setDescription("Fleet\nPrice: 4000");
		Board.fields[20].setTitle("The Buccaneers"); Board.fields[20].setDescription("Fleet\nPrice: 4000");
		Board.fields[21].setTitle("Privateer armade"); Board.fields[21].setDescription("Fleet\nPrice: 4000");
	
	}
	
	public static void initGUI() 
	{

		GUI.create(fields);
		GUI.showMessage("Welcome to Monopoly Jr!\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	

	}

}
