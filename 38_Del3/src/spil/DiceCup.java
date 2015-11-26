package spil;

public class DiceCup 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.	
	private Dice diceOne;
	private Dice diceTwo;

	//DiceCup class constructor
	//which takes two class of Dice
	public DiceCup() 
	{
		this.diceOne = new Dice();
		this.diceTwo = new Dice();
	}

	//This Shake method is used for randomly choose
	//a random number between the numbers of the dice.
	//Shake method returns a Dice[] => which is a Dice array.
	public void shake()
	{
		diceOne.roll();
		diceTwo.roll();
	}
	
	//Lets us get the sum of the two dies.
	public int getSumResult()
	{
		int sum = diceOne.getValue()+ diceTwo.getValue(); 
		return sum;
	}

	//Lets us get the value of diceOne for plotting it into the GUI
	public int getDiceOne() 
	{
		return diceOne.getValue();
	}

	//Lets us get the value of diceTwo for plotting it into the GUI
	public int getDiceTwo() 
	{
		return diceTwo.getValue();
	}
}
