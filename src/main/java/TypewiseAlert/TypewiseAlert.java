package TypewiseAlert;

import Alert.AlertStrategy;
import Breach.BreachType;
import CoolingTypes.CoolingTypeStrategy;

public class TypewiseAlert {
	public class BatteryCharacter {
		public CoolingTypeStrategy coolingType;
		public String brand;

		public BatteryCharacter(CoolingTypeStrategy coolingType, String brand) {
			this.coolingType = coolingType;
			this.brand = brand;
		}
	}

	public static void checkAndAlert(AlertStrategy alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
		BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
		AlertStrategy alertStrategy = AlertStrategy.valueOf(alertTarget.toString());
		alertStrategy.sendAlert(breachType);
	}

	public static BreachType classifyTemperatureBreach(CoolingTypeStrategy coolingType, double temperatureInC) {
		CoolingTypeStrategy temperatureBreachStrategy = CoolingTypeStrategy.valueOf(coolingType.toString());
		return temperatureBreachStrategy.checkTemperatureBreach(temperatureInC);
	}

}
