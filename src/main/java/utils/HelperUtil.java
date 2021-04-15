package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HelperUtil {

	private HelperUtil() {
	}

	public static String getValueFromProperty(String key, String type) throws IOException {
		FileReader reader = null;
		String value = "";

		reader = new FileReader(type + ".properties");
		Properties properties = new Properties();
		properties.load(reader);
		value = properties.getProperty(key);
		return value;
	}

}
