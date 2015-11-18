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
//	private final int winnerScore = 3000;
	private final int bankrupt = 0;
	private final int startingBalance = 30000;
	private Player[] players;
	private int currentPlayerNumber = 0;
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
		GameBoard.createFields();
		GameBoard.initFields();
		GameBoard.initGUI();
		initPlayers();
		boolean gameIsNotWon = true;


		while (gameIsNotWon)
		{			
//			if (cointoss)
//			{
//				if(gameIsNotWon) gameIsNotWon = playerTurn(playerTwo);				
//				if(gameIsNotWon) gameIsNotWon = playerTurn(playerOne);
//
//			} 
//			else 
//			{
//				if(gameIsNotWon) gameIsNotWon = playerTurn(playerOne);
//				if(gameIsNotWon) gameIsNotWon = playerTurn(playerTwo);
//			}
		}
		showWinnerScreen();
	}


	private void showWinnerScreen() 
	{
//		if(playerOne.getPlayerAccount().getBalance() >= winnerScore)
//			GUI.showMessage(playerOne.getPlayerName()+" won the game with "+playerOne.getPlayerAccount().getBalance()+" point!!");
//		else if(playerTwo.getPlayerAccount().getBalance() >= winnerScore)
//			GUI.showMessage(playerTwo.getPlayerName()+" won the game with "+playerTwo.getPlayerAccount().getBalance()+" point!!");
	}

	//
	private void initPlayers() 
	{	
		String playersCountChoosenByUser = GUI.getUserButtonPressed("Please select the number of players.", "2", "3", "4", "5", "6");
		int playerCount = Integer.parseInt(playersCountChoosenByUser);
		players = new Player[playerCount];
		Car[] car = new Car[playerCount];

		for(int i = 0; i < playerCount; i++)
		{
			int playerNumber = i + 1; 
			String playerNameTypedInByTheUser = GUI.getUserString("Please type in the name of player " + playerNumber);
			Player player = new Player();
			player.setPlayerName(playerNameTypedInByTheUser);
			players[i] = player;
			car[i] = new Car.Builder()
					.typeTractor()
					.patternHorizontalDualColor()
					.primaryColor(Color.lightGray)
					.secondaryColor(getChangedColor(playerNumber))
					.build();
			GUI.addPlayer(player.getPlayerName(), startingBalance, car[i]);	

		}

		GUI.getUserButtonPressed("Flip a coin to decide who starts!", "Flip Coin");

		Dice dice = new Dice(playerCount,2);
		int rollResult = dice.roll();
		currentPlayerNumber = rollResult;
//		GUI.showMessage(players[currentPlayerNumber].getPlayerName() + " starts! "  + "\nLet the game begin.");
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

	private Color getChangedColor(int playerNumber)
	{
		switch (playerNumber)
		{
		case 1:
			return Color.BLUE;
		case 2:
			return Color.RED;
		case 3:
			return Color.ORANGE;
		case 4:
			return Color.GRAY;
		case 5:
			return Color.YELLOW;
		default:
			return Color.MAGENTA;
		}
	}
}