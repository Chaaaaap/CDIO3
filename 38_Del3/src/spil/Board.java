package spil;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_resources.GUI;

public class Board {
	
	public void initGUI() 
	{
		//Creating fields for emptying them on the GUI.
		Field[] fields = new Field[40];
		for(int i=0; i < fields.length ; i++)
		{
			Field emptyField = new Empty.Builder().build();
			fields[i] = emptyField;
		}

		GUI.create(fields);
		GUI.showMessage("Welcome to the Money Making Dice Game\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	

	}

}
