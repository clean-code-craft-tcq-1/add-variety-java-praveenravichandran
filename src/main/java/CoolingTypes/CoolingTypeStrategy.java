package CoolingTypes;

import Breach.BreachType;

public enum CoolingTypeStrategy {
	PassiveCooling {
		int lowerLimit = 0;
		int upperLimit = 35;

		@Override
		public BreachType checkTemperatureBreach(double temperatureInC) {
			return inferBreach(temperatureInC, lowerLimit, upperLimit);
		};
	},
	HI_ACTIVE_COOLING {
		int lowerLimit = 0;
		int upperLimit = 45;

		@Override
		public BreachType checkTemperatureBreach(double temperatureInC) {
			return inferBreach(temperatureInC, lowerLimit, upperLimit);
		};
	},
	MED_ACTIVE_COOLING {
		int lowerLimit = 0;
		int upperLimit = 40;

		@Override
		public BreachType checkTemperatureBreach(double temperatureInC) {
			return inferBreach(temperatureInC, lowerLimit, upperLimit);
		};
	};

	public abstract BreachType checkTemperatureBreach(double temperatureInC);

	public static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		if (value < lowerLimit) {
			return BreachType.TOO_LOW;
		}
		if (value > upperLimit) {
			return BreachType.TOO_HIGH;
		}
		return BreachType.NORMAL;
	}
}
