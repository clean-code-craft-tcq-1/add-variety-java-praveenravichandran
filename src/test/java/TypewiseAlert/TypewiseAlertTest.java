package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Breach.BreachType;
import CoolingTypes.CoolingTypeStrategy;

public class TypewiseAlertTest {
	@Test
	public void infersBreachAsPerLimits() {
		assertTrue(CoolingTypeStrategy.inferBreach(12, 20, 30) == BreachType.TOO_LOW);
	}
}
