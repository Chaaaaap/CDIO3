package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class TerritoryTest {
	
	//Creates our variables.
	private Player player, owner;
	private Ownable territory100;
	private Ownable territory0;
	private Ownable territoryNeg100;
	private GameBoard gb;
	private DiceCup diceCup;

	@Before
	public void setUp() throws Exception {
		gb = new GameBoard(diceCup);
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(1000);
		owner.setPlayerName("Owner");
		territory100 = new Territory(100, 50, "Territory100", gb);
		territory0 = new Territory(0, 0, "Territory0", gb);
		territoryNeg100 = new Territory(-100, -50, "TerritoryNeg100", gb);
	}

	@After
	public void tearDown() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(1000);
		owner.setPlayerName("Owner");
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.owner);
		
		Assert.assertNotNull(this.territory100);
		Assert.assertNotNull(this.territory0);
		Assert.assertNotNull(this.territoryNeg100);
		
		Assert.assertTrue(this.territory100 instanceof Territory);
		Assert.assertTrue(this.territory0 instanceof Territory);
		Assert.assertTrue(this.territoryNeg100 instanceof Territory);
	}
	
	@Test
	public void testBuyTerritory100() {
		int ownerExpected = 1000;
		int ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
		
		//IMPORTANT!! Press yes to buy the field!!
		territory100.landOnField(owner);
		
		ownerExpected = 1000 - 100;
		ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
	}
	
	@Test
	public void testBuyTerritory0() {
		int ownerExpected = 1000;
		int ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
		
		//IMPORTANT!! Press yes to buy the field!!
		territory0.landOnField(owner);
		
		ownerExpected = 1000;
		ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
	}
	
	@Test
	public void testBuyTerritoryNeg100() {
		int ownerExpected = 1000;
		int ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
		
		//IMPORTANT!! Press yes to buy the field!!
		territoryNeg100.landOnField(owner);
		
		ownerExpected = 1000 + 100;
		ownerActual = owner.getPlayerAccount().getBalance();
		Assert.assertEquals(ownerExpected, ownerActual);
	}
	
	@Test
	public void testRentTerritory100() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territory100.setOwner(owner);
		territory100.landOnField(player);
		
		expected = 1000 - 50;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTerritory1000Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territory100.setOwner(owner);
		territory100.landOnField(player);
		territory100.landOnField(player);
		
		expected = 1000 - 50 - 50;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTerritory0() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territory0.setOwner(owner);
		territory0.landOnField(player);
		
		expected = 1000;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTerritory0Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territory0.setOwner(owner);
		territory0.landOnField(player);
		territory0.landOnField(player);
		
		expected = 1000;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTerritoryNeg100() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territoryNeg100.setOwner(owner);
		territoryNeg100.landOnField(player);
		
		expected = 1000 + 50;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTerritoryNeg100Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);

		territoryNeg100.setOwner(owner);
		territoryNeg100.landOnField(player);
		territoryNeg100.landOnField(player);
		
		expected = 1000 + 50 + 50;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

}
