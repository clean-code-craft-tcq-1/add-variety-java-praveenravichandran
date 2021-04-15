package alert;

import Breach.BreachType;

public class ControllerAlerter implements AlertStrategy {

	@Override
	public void sendAlert(BreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%d : %s\n", header, breachType);
	}

}
