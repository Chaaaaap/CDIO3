package spil;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_resources.GUI;
import desktop_codebehind.Car;
import java.awt.Color;
public class GameManager 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private final int winnerScore = 3000;
	private Player playerOne;
	private Player playerTwo;
	private DiceCup diceCup;
	private boolean cointoss;
	private int sum;

	//GameManager constructor
	public GameManager()
	{
		this.diceCup = new DiceCup();
	}

	//Starting game handling and Rematch Handling
	public void manageGame()
	{
		boolean wantRematch = true;

		while(wantRematch)
		{
			startGameEngine();
			String userInput = GUI.getUserButtonPressed("Do you want a rematch?", "Yes", "No");
			if(userInput == "No")
			{
				wantRematch = false;
			}

			GUI.close();//Closing the GUI => Graphical User Interface
		}
		System.exit(0);//Terminates the currently running Java Virtual Machine - 0 means just to parse something into exit method.
	}

	//StartGameEngine method is a void method, which means 
	//it does not return any value.
	//StartGameEngine is the brain of this game-program
	public void startGameEngine()
	{
		createFields();
		Board.initGUI();
		initPlayers();
		boolean gameIsNotWon = true;


		while (gameIsNotWon)
		{			
			if (cointoss)
			{
				if(gameIsNotWon) gameIsNotWon = playerTurn(playerTwo);				
				if(gameIsNotWon) gameIsNotWon = playerTurn(playerOne);

			} 
			else 
			{
				if(gameIsNotWon) gameIsNotWon = playerTurn(playerOne);
				if(gameIsNotWon) gameIsNotWon = playerTurn(playerTwo);
			}
		}
		showWinnerScreen();
	}


	private void showWinnerScreen() 
	{
		if(playerOne.getPlayerAccount().getBalance() >= winnerScore)
			GUI.showMessage(playerOne.getPlayerName()+" won the game with "+playerOne.getPlayerAccount().getBalance()+" point!!");
		else if(playerTwo.getPlayerAccount().getBalance() >= winnerScore)
			GUI.showMessage(playerTwo.getPlayerName()+" won the game with "+playerTwo.getPlayerAccount().getBalance()+" point!!");
	}

	private void initPlayers() 
	{
		String playerOneNameTypedInByTheUser = GUI.getUserString("Please type in the name of player One");

		//Creating a new player object
		playerOne = new Player();
		playerOne.setPlayerName(playerOneNameTypedInByTheUser);
		Car car1 = new Car.Builder()
				.typeTractor()
				.patternHorizontalDualColor()
				.primaryColor(Color.RED)
				.secondaryColor(Color.BLUE)
				.build();
		GUI.addPlayer(playerOne.getPlayerName(), 1000,car1);		

		String playerTwoNameTypedInByTheUser = GUI.getUserString("Please type in the name of player Two");
		playerTwo = new Player();
		playerTwo.setPlayerName(playerTwoNameTypedInByTheUser);
		Car car2 = new Car.Builder()
				.typeTractor()
				.patternHorizontalDualColor()
				.primaryColor(Color.BLUE)
				.secondaryColor(Color.RED)
				.build();
		GUI.addPlayer(playerTwo.getPlayerName(), 1000,car2);

		GUI.getUserButtonPressed("Flip a coin to decide who starts!", "Flip Coin");

		Dice dice = new Dice(2,1);
		dice.roll();
		if (dice.getValue()==2) cointoss=true;
		else cointoss=false;

		if(cointoss==true)
			GUI.showMessage(playerTwo.getPlayerName() + " starts! "  + "\nLet the game between " + playerOne.getPlayerName() + " and " + playerTwo.getPlayerName() + " begin.");		
		else
			GUI.showMessage(playerOne.getPlayerName() + " starts! " + "\nLet the game between " + playerOne.getPlayerName() + " and " + playerTwo.getPlayerName() + " begin.");
	}

	private boolean playerTurn(Player player) 
	{
		return true;
	}

	private void initGUI() 
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