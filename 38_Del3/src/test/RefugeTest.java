package test;

import static org.junit.Assert.*;
import spil.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		fail("Not yet implemented");
	}

}
