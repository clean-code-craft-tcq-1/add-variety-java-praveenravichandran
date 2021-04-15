package alert;

import Breach.BreachType;

public class ConsoleAlerter implements AlertStrategy {

	@Override
	public void sendAlert(BreachType breachType) {
		System.out.println("The temperature is \n" + breachType.toString());
	}

}
