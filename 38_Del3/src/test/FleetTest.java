package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;
public class FleetTest {
	
	//Creates our variables.
	private Player player, owner;
	private Ownable fleet1;
	private Ownable fleet2;
	private Ownable fleet3;
	private Ownable fleet4;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(20000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(20000);
		owner.setPlayerName("Owner");
		fleet1 = new Fleet(1500, "Fleet1");
		fleet2 = new Fleet(0, "Fleet2");
		fleet3 = new Fleet(0, "Fleet3");
		fleet4 = new Fleet(0, "Fleet4");
	}

	@After
	public void tearDown() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(20000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(20000);
		owner.setPlayerName("Owner");
		fleet1 = new Fleet(1500, "Fleet1");
		fleet2 = new Fleet(0, "Fleet2");
		fleet3 = new Fleet(0, "Fleet3");
		fleet4 = new Fleet(0, "Fleet4");
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.owner);
		
		Assert.assertNotNull(this.fleet1);
		Assert.assertNotNull(this.fleet2);
		Assert.assertNotNull(this.fleet3);
		Assert.assertNotNull(this.fleet4);
		
		Assert.assertTrue(this.fleet1 instanceof Fleet);
		Assert.assertTrue(this.fleet2 instanceof Fleet);
		Assert.assertTrue(this.fleet3 instanceof Fleet);
		Assert.assertTrue(this.fleet4 instanceof Fleet);
	}
	
	@Test
	public void testBuyFleet() {
		int expected = 20000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//IMPORTANT!! You have to click the "Yes" button in order to buy the field.
		fleet1.landOnField(player);
		
		expected = 20000 - 1500;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);		
	}
	
	@Test
	public void testRentOneFleet() {
		int expected = 20000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		fleet1.setOwner(owner);
		fleet1.landOnField(player);
		
		expected = 20000 - 500;
		actual = player.getPlayerAccount().getBalance();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentTwoFleet () {
		int expected = 20000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		fleet1.setOwner(owner);
		fleet2.setOwner(owner);
		fleet1.landOnField(player);
		
		expected = 20000 - 1000;
		actual = player.getPlayerAccount().getBalance();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}

}
