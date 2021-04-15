package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import BatteryCharacter.BatteryCharacter;
import Breach.BreachChecker;
import Breach.BreachType;

public class TypewiseAlertTest {

	@Test
	public void infersBreachAsPerLimits() {
		assertTrue(BreachChecker.inferBreach(12, 20, 30) == BreachType.TOO_LOW);
		assertTrue(BreachChecker.inferBreach(25, 20, 30) == BreachType.NORMAL);
		assertTrue(BreachChecker.inferBreach(35, 20, 30) == BreachType.TOO_HIGH);
	}

	@Test
	public void passiveTemperatureLowBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("PASSIVE_COOLING", -1) == BreachType.TOO_LOW);
	}

	@Test
	public void passiveTemperatureHighBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("PASSIVE_COOLING", 30) == BreachType.NORMAL);
	}

	@Test
	public void passiveTemperatureNormal()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("PASSIVE_COOLING", 40) == BreachType.TOO_HIGH);
	}

	@Test
	public void medActiveTemperatureLowBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("MED_ACTIVE_COOLING", -1) == BreachType.TOO_LOW);
	}

	@Test
	public void medActiveTemperatureHighBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("MED_ACTIVE_COOLING", 30) == BreachType.NORMAL);
	}

	@Test
	public void medActiveTemperatureNormal()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("MED_ACTIVE_COOLING", 45) == BreachType.TOO_HIGH);
	}

	@Test
	public void hiActiveTemperatureLowBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("HI_ACTIVE_COOLING", -1) == BreachType.TOO_LOW);
	}

	@Test
	public void hiActiveTemperatureHighBreach()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("HI_ACTIVE_COOLING", 30) == BreachType.NORMAL);
	}

	@Test
	public void hiActiveTemperatureNormal()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		assertTrue(TypewiseAlert.classifyTemperatureBreach("HI_ACTIVE_COOLING", 50) == BreachType.TOO_HIGH);
	}

	@Test
	public void checkAndAlertPassiveTemperatureBreachEmail()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("PASSIVE_COOLING", "Passive_brand");
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertPassiveTemperatureBreachController()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("PASSIVE_COOLING", "Passive_brand");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertPassiveTemperatureBreachConsole()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("PASSIVE_COOLING", "Passive_brand");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertMedActiveTemperatureBreachEmail()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("MED_ACTIVE_COOLING", "Medium_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertMedActiveTemperatureBreachController()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("MED_ACTIVE_COOLING", "Medium_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertMedActiveTemperatureBreachConsole()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("MED_ACTIVE_COOLING", "Medium_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertHiActiveTemperatureBreachEmail()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("HI_ACTIVE_COOLING", "High_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_MAIL", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertHiActiveTemperatureBreachController()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("HI_ACTIVE_COOLING", "High_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONTROLLER", batteryCharacter, 20) == BreachType.NORMAL);
	}

	@Test
	public void checkAndAlertHiActiveTemperatureBreachConsole()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		BatteryCharacter batteryCharacter = new BatteryCharacter("HI_ACTIVE_COOLING", "High_Active");
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 50) == BreachType.TOO_HIGH);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, -1) == BreachType.TOO_LOW);
		assertTrue(TypewiseAlert.checkAndAlert("TO_CONSOLE", batteryCharacter, 20) == BreachType.NORMAL);
	}
}
