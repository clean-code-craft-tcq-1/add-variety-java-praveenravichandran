package Breach;

public enum BreachType {
	NORMAL {
		@Override
		public void printMailContent(String recepient) {

		}
	},
	TOO_LOW {
		@Override
		public void printMailContent(String recepient) {
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too low\n");
		}
	},
	TOO_HIGH {
		@Override
		public void printMailContent(String recepient) {
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too high\n");
		}
	};

	public abstract void printMailContent(String recepient);
}
