package Alert;

import Breach.BreachType;

public enum AlertStrategy {

	TO_CONTROLLER {
		@Override
		public void sendAlert(BreachType breachType) {
			int header = 0xfeed;
			System.out.printf("%i : %i\n", header, breachType);
		}
	},
	TO_MAIL {
		@Override
		public void sendAlert(BreachType breachType) {
			String recepient = "a.b@c.com";
			BreachType breach = BreachType.valueOf(breachType.toString());
			breach.printMailContent(recepient);
		}
	};

	private AlertStrategy() {
	}

	public abstract void sendAlert(BreachType breachType);
}
