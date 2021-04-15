package coolingtype;

import Breach.BreachChecker;
import Breach.BreachType;

public class MediumCooling implements CoolingTypeStrategy {
	int lowerLimit = 0;
	int upperLimit = 40;

	@Override
	public BreachType checkTemperatureBreach(double temperatureInC) {
		return BreachChecker.inferBreach(temperatureInC, lowerLimit, upperLimit);
	}

}
