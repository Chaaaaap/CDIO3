package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import spil.*;

public class TaxTest {
	
	private Player player;
	private Felt tax200;
	private Felt tax0;
	private Felt taxNeg200;

	@Before
	public void setUp() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
		tax200 = new Tax(200, "TaxTest  +200");
		tax0 = new Tax(0, "TaxTest  +0");
		taxNeg200 = new Tax(-200, "TaxTest -200");
	}

	@After
	public void tearDown() throws Exception {
		player = new Player();
		player.getPlayerAccount().setBalance(1000);
	}

	@Test //Tests to see if the objects have been created and initializes correctly
	public void testEntities() {
		Assert.assertNotNull(this.player);
		
		Assert.assertNotNull(this.tax200);
		Assert.assertNotNull(this.tax0);
		Assert.assertNotNull(this.taxNeg200);
		
		Assert.assertTrue(this.tax200 instanceof Tax);
		Assert.assertTrue(this.tax0 instanceof Tax);
		Assert.assertTrue(this.taxNeg200 instanceof Tax);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTax200() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax200.landOnField(player);
		
		expected = 1000 - 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTax200Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax200.landOnField(player);
		tax200.landOnField(player);
		
		expected = 1000 - 200 - 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTax0() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax0.landOnField(player);
		
		expected = 1000;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTax0Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax0.landOnField(player);
		tax0.landOnField(player);
		
		expected = 1000;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTaxNeg200() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		taxNeg200.landOnField(player);
		
		expected = 1000 + 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the left button when the GUI opens!
	 * Otherwise you'll pay 10% of your assets instead which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTaxNeg200Twice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		taxNeg200.landOnField(player);
		taxNeg200.landOnField(player);
		
		expected = 1000 + 200 + 200;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the button to the right when the GUI opens!
	 * Otherwise you'll pay 200$ instead of 10% which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTaxTenPercent() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax200.landOnField(player);
		
		expected = 1000 - (expected/10);
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}
	
	/******************************************************************************
	 * IMPORTANT!!! You have to chose the button to the right when the GUI opens!
	 * Otherwise you'll pay 200$ instead of 10% which will cause an error!
	 ******************************************************************************/
	@Test
	public void testLandOnFieldTaxTenPercentTwice() {
		int expected = 1000;
		int actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
		
		tax200.landOnField(player);
		tax200.landOnField(player);
		
		expected = 1000 - 100 - 90;
		actual = player.getPlayerAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

}
