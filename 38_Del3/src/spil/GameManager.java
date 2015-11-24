package spil;

import desktop_resources.GUI;
import desktop_codebehind.Car;
import java.awt.Color;
public class GameManager 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private Player[] players;
	private int startingPlayer, playerCount, sum, bankruptCounter=0;
	private DiceCup diceCup;
	private GameBoard gameBoard;
	private boolean[] bankruptPlayers;

	//GameManager constructor
	public GameManager()
	{
		this.diceCup = new DiceCup();
		this.gameBoard = new GameBoard();
	}

	//Starting game handling and Rematch handling
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
		//Setup game
		initPlayers();
		boolean gameIsNotWon = true;

		//Decide starting player
		int i = startingPlayer;
		//Take turns until game won
		while (gameIsNotWon)
		{			
			for (;i < playerCount; i++){
				
				playerTurn(players[i]);
				isPlayersBankrupt(players);
				if(bankruptCounter == playerCount-1)
					gameIsNotWon = false;

			}
			i=0;
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

	private void initPlayers() 
	{	
		String playersCountChoosenByUser = GUI.getUserButtonPressed("Please select the number of players.", "2", "3", "4", "5", "6");
		playerCount = Integer.parseInt(playersCountChoosenByUser);
		players = new Player[playerCount];
		Car[] car = new Car[playerCount];
		bankruptPlayers = new boolean[playerCount];

		for(int i = 0; i < playerCount; i++)
		{
			int playerNumber = i + 1; 
			String playerNameTypedInByTheUser = GUI.getUserString("Please type in the name of player " + playerNumber);
			Player player = new Player();
			player.setPlayerName(playerNameTypedInByTheUser);
			players[i] = player;
			car[i] = new Car.Builder()
					.typeUfo()
					.patternHorizontalDualColor()
					.primaryColor(Color.lightGray)
					.secondaryColor(getChangedColor(playerNumber))
					.build();
			GUI.addPlayer(player.getPlayerName(), players[i].getPlayerAccount().getBalance(), car[i]);	
			GUI.setCar(1, player.getPlayerName());
			bankruptPlayers[i] = false;

		}

		GUI.getUserButtonPressed("Flip a coin to decide who starts!", "Flip Coin");
		
		//Decides who's starting
		if(playerCount > 2) {
			Dice dice = new Dice(playerCount,1
					
					);
			int rollResult = dice.roll();
			startingPlayer = rollResult;
		}
		else {
			Dice dice = new Dice(2,1);
			int rollResult = dice.roll();
			startingPlayer = rollResult;
		}
		if(playerCount > 2)
			GUI.showMessage(players[startingPlayer-1].getPlayerName() + " starts! "  + "\nLet the game begin.");
		else
			GUI.showMessage(players[startingPlayer].getPlayerName() + " starts! "+"\nLet the game begin.");
	}

	private void playerTurn(Player player) 
	{
		//Tests to see how many players are bankrupt
		isPlayersBankrupt(players);
		//Makes sure bankrupts players are skipped
		if(player.getPlayerAccount().isBankrupt() == false) {
			//
			GUI.getUserButtonPressed(player.getPlayerName() + "'s turn.", "Shake Dice Cup");
			diceCup.shake();
			sum = diceCup.getSumResult();
			GUI.setDice(diceCup.getDiceOne(), diceCup.getDiceTwo());
			GUI.removeAllCars(player.getPlayerName());
			player.setCurrentField((player.getCurrentField()+sum)%22);
			GUI.setCar((player.getCurrentField())+1, player.getPlayerName());
			player.setCurrentField((player.getCurrentField()));
			gameBoard.logicFields[player.getCurrentField()].landOnField(player);
		}		
	}
	
	private int isPlayersBankrupt(Player[] players) {
		bankruptCounter = 0;
		for(int i = 0; i < playerCount; i++)
			if(players[i].getPlayerAccount().isBankrupt() == true)
				bankruptCounter++;
		return bankruptCounter;
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