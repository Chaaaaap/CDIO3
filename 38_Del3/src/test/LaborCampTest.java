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
	private Felt laborCamp100;
	private Felt laborCamp0;
	private Felt laborCampNeg100;
	private DiceCup diceCup;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(2000);
		owner = new Player();
		owner.getPlayerAccount().setBalance(1000);
		laborCamp100 = new LaborCamp(100, "LaborCamp100");
		laborCamp0 = new LaborCamp(0, "LaborCamp0");
		laborCampNeg100 = new LaborCamp(-100, "LaborCampNeg100");
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
		
		Assert.assertTrue(this.laborCamp100 instanceof LaborCamp);
		Assert.assertTrue(this.laborCamp0 instanceof LaborCamp);
		Assert.assertTrue(this.laborCampNeg100 instanceof LaborCamp);
	}

	@Test
	public void testLaborCamp100() {
		int expected = 2000;
		int actual = this.player.getPlayerAccount().getBalance();
		
		//To test if the field can be bought
		laborCamp100.landOnField(owner);
		//To test the landOnField method
		laborCamp100.landOnField(player);
		
		expected = 2000 - sum*100;
		
	}
}
