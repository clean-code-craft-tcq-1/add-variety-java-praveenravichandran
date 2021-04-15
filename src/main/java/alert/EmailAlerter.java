package alert;

import Breach.BreachType;

public class EmailAlerter implements AlertStrategy {

	@Override
	public void sendAlert(BreachType breachType) {
		String recepient = "a.b@c.com";
		System.out.printf("To: %s\n", recepient);
		System.out.println("Hi, the temperature is" + breachType.toString() + "\n");
	}

}
