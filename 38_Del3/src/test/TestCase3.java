package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class TestCase3 {
	
	private Player player;
	private Ownable Fleet4000;
	private GameBoard gb;
	private DiceCup diceCup;
	

	@Before
	public void setUp() throws Exception {
		gb = new GameBoard(diceCup);
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");
		Fleet4000 = new Fleet(4000, "Fleet 4000", gb);
	}

	@Test
	public void test() {
		int playerExpected = 30000;
		int playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
		
		Fleet4000.buyFieldOption(player);
		
		playerExpected = 30000 - 4000;
		playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
	}

}
