package alert;

import Breach.BreachType;

public interface AlertStrategy {
	public void sendAlert(BreachType breachType);
}
