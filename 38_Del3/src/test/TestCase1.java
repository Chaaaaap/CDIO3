package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import spil.*;

public class TestCase1 {

	private Player player;
	private Ownable Territory2000;
	private GameBoard gb;
	private DiceCup diceCup;
	
	
	@Before
	public void setUp() throws Exception {
		gb = new GameBoard(diceCup);
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
		player.setPlayerName("Player");
		Territory2000 = new Territory(2000,0,"Territory 2000", gb);
	}

	@Test
	public void test() {
		int playerExpected = 1000;
		int playerActual = player.getPlayerAccount().getBalance();
		assertEquals(playerExpected, playerActual);
		
		Territory2000.buyFieldOption(player);
		
		playerExpected = 0;
		playerActual = player.getPlayerAccount().getBalance();
		assertEquals(playerExpected, playerActual);
		
	}

}
