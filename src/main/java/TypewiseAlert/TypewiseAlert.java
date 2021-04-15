package TypewiseAlert;

import java.io.IOException;

import BatteryCharacter.BatteryCharacter;
import Breach.BreachType;
import alert.AlertStrategy;
import coolingtype.CoolingTypeStrategy;
import utils.HelperUtil;

public class TypewiseAlert {

	private TypewiseAlert() {
	}

	public static BreachType checkAndAlert(String alertType, BatteryCharacter batteryChar, double temperatureInC)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
		String className = HelperUtil.getValueFromProperty(alertType, "Alert");
		AlertStrategy alertStrategy = (AlertStrategy) Class.forName(className).newInstance();
		alertStrategy.sendAlert(breachType);
		return breachType;
	}

	public static BreachType classifyTemperatureBreach(String coolingType, double temperatureInC)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String className = HelperUtil.getValueFromProperty(coolingType, "CoolingType");

		CoolingTypeStrategy temperatureBreachStrategy = (CoolingTypeStrategy) Class.forName(className).newInstance();
		return temperatureBreachStrategy.checkTemperatureBreach(temperatureInC);
	}

}
