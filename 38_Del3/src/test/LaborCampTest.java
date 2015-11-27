package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class LaborCampTest {
	
	//Creates our variables.
	private Player player, owner;
	private Ownable laborCamp100;
	private Ownable laborCamp0;
	private Ownable laborCampNeg100;
	private DiceCup diceCup = new DiceCup();

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(2000);
		player.setPlayerName("Player");
		owner = new Player();
		owner.getPlayerAccount().setBalance(1000);
		owner.setPlayerName("Owner");
		laborCamp100 = new LaborCamp(100, "LaborCamp100", diceCup);
		laborCamp0 = new LaborCamp(0, "LaborCamp0", diceCup);
		laborCampNeg100 = new LaborCamp(-100, "LaborCampNeg100", diceCup);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test //This test just makes sure, that the objects have been created correctly.
	public void testEntities() {
		Assert.assertNotNull(this.player);
		Assert.assertNotNull(this.owner);
		
		Assert.assertNotNull(this.laborCamp100);
		Assert.assertNotNull(this.laborCamp0);
		Assert.assertNotNull(this.laborCampNeg100);
		
		//Tests to see if they are correctly initialized as a LaborCamp.
		Assert.assertTrue(this.laborCamp100 instanceof LaborCamp);
		Assert.assertTrue(this.laborCamp0 instanceof LaborCamp);
		Assert.assertTrue(this.laborCampNeg100 instanceof LaborCamp);
	}

	@Test
	public void testBuyLaborCamp100() {
		//This part just makes sures the player is initialized with the values is supposed to.
		int expected = 2000;
		int actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		//To test if the field can be bought
		laborCamp100.landOnField(player);
		
		//Tests to see if the player has paid the correct amount for the field.
		expected = 2000 - 100;
		actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentLaborCamp () {
		int expected = 2000;
		int actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		laborCamp100.setOwner(owner);
		laborCamp100.landOnField(player);
		
		expected = 2000 - ((LaborCamp)laborCamp100).getDiceCup().getSumResult();
		actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testRentLaborCampTwice() {
		int expected = 2000;
		int actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		laborCamp100.setOwner(owner);
		laborCamp100.landOnField(player);
		laborCamp100.landOnField(player);
		
		expected = 2000 - ((LaborCamp)laborCamp100).getDiceCup().getSumResult() - ((LaborCamp)laborCamp100).getDiceCup().getSumResult();
		actual = this.player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
}
