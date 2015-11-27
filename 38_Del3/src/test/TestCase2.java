package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class TestCase2 {

	private Player player, owner;
	private Ownable territory2000;
	private GameBoard gb;
	private DiceCup diceCup;
	
	@Before
	public void setUp() throws Exception {
		gb = new GameBoard(diceCup);
		player = new Player();
		player.getPlayerAccount().setBalance(30000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(30000);
		owner.setPlayerName("Owner");
		territory2000 = new Territory(0,200,"Territory 2000", gb);
		territory2000.setOwner(owner);
		
	}

	@Test
	public void test() {
		int ownerExpected = 30000;
		int ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
		
		int playerExpected = 30000;
		int playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
		
		territory2000.landOnField(player);
		
		playerExpected = 30000 - 200;
		playerActual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(playerExpected, playerActual);
		
		ownerExpected = 30000 + 200;
		ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
	}
}
