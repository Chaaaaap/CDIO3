package test;

import static org.junit.Assert.*;
import spil.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RefugeTest {
	
	private Player player;
	private Felt refuge200;
	private Felt refuge0;
	private Felt refugeNeg200;

	@Before
	public void setUp() throws Exception {
		this.player = new Player();
		player.setPlayerName("Søren");
		player.getPlayerAccount().setBalance(1000);
		this.refuge200 = new Refuge(200, "Refuge +200");
		this.refuge0 = new Refuge(0, "Refuge +0");
		this.refugeNeg200 = new Refuge(-200, "Refuge -200");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
		
		Assert.assertNotNull(this.refuge200);
		Assert.assertNotNull(this.refuge0);
		Assert.assertNotNull(this.refugeNeg200);
		
		Assert.assertTrue(this.refuge200 instanceof Refuge);
		Assert.assertTrue(this.refuge0 instanceof Refuge);
		Assert.assertTrue(this.refugeNeg200 instanceof Refuge);
	}

	@Test
	public void testLandOnField200() {
		int expected = 1000;
		int actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refuge200.landOnField(this.player);
		
		expected = 1000 + 200;
		actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLandOnField200Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refuge200.landOnField(this.player);
		this.refuge200.landOnField(this.player);
		
		expected = 1000 + 200 + 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		}
	
	@Test
	public void testLandOnField0() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refuge0.landOnField(this.player);
		
		expected = 1000 + 0;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLandOnField0Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refuge0.landOnField(this.player);
		this.refuge0.landOnField(this.player);
		
		expected = 1000;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void  testLandOnFieldNeg200() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refugeNeg200.landOnField(this.player);
		
		expected = 1000 - 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testLandOnFieldNeg200Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		this.refugeNeg200.landOnField(this.player);
		this.refugeNeg200.landOnField(this.player);
		
		expected = 1000 - 200 - 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
}
