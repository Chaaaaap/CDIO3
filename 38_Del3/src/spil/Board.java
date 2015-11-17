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
		Board.fields[2].setTitle("");
	}
	
	public static void initGUI() 
	{

		GUI.create(fields);
		GUI.showMessage("Welcome to the Money Making Dice Game\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	

	}

}
