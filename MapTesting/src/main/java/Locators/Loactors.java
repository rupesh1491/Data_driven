package Locators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Loactors {
	 private static Properties properties = new Properties();

	    static {
	        try {
	            properties.load(new FileInputStream("src/main/java/Locators/Locator.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String get(String key) {
	        return properties.getProperty(key);
	    }

}
