package spil;

public class PlayerAccount 
{

	private int balance;

	public PlayerAccount(int balance) 
	{
		if(balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	public boolean isBankrupt() {
		if(this.balance == 0)
			return true;
		else 
			return false;
	}

	public void addBalance(int amount) 
	{
		this.balance = this.balance + amount;
	}

	public void subBalance(int amount) 
	{
		if((this.balance - amount)<0)
			this.balance = 0;
		else
			this.balance = this.balance - amount;
	}

	public void setBalance(int amount) 
	{
		if(amount < 0)
			this.balance = 0;
		else
			this.balance = amount;
	}

	public int getBalance() 
	{
		return this.balance;
	}
	
	public void transfer(PlayerAccount playerAccount, int amount) {
		
		playerAccount.addBalance(amount);
	}

}
