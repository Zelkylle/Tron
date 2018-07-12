package Tron.Tron;

import org.junit.Assert;
import org.junit.Test;
import Tron.Tron.Lightcycle;

public class LightcycleTest {
	
/**
 * Permet de tester si la fonction CheckCollision fonctionne bien
 */
	@Test
	public void CheckCollisionTest() {
		Lightcycle lightcycle = new Lightcycle();
		boolean result = lightcycle.CheckCollision(12, 2);
		Assert.assertTrue("devrait étre vraie", result);
	}
	
	@Test
	public void Test() {
		
	}
	
}
