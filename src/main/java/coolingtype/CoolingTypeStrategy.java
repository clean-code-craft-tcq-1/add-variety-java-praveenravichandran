package coolingtype;

import Breach.BreachType;

public interface CoolingTypeStrategy {
	public abstract BreachType checkTemperatureBreach(double temperatureInC);
}
