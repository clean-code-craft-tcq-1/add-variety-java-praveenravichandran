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
			switch (breachType) {
			case TOO_LOW:
				System.out.printf("To: %s\n", recepient);
				System.out.println("Hi, the temperature is too low\n");
				break;
			case TOO_HIGH:
				System.out.printf("To: %s\n", recepient);
				System.out.println("Hi, the temperature is too high\n");
				break;
			case NORMAL:
				break;
			}
		}
	};

	private AlertStrategy() {
	}

	public abstract void sendAlert(BreachType breachType);
}
