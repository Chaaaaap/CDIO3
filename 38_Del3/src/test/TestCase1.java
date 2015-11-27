package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class TestCase1 {

	private Player player;
	private Ownable Territory2000;
	private GameBoard gb;
	
	
	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
		player.setPlayerName("Player");
		Territory2000 = new Territory(2000,0,"Territory 2000", gb);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int playerExpected = 1000;
		int playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
		
		Territory2000.buyFieldOption(player);
		
		playerExpected = -1000;
		playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
		
	}

}
