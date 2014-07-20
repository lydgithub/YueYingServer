package yueying.util;



import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class CityConfiguration {
	private static final String CITY_PROPERTY = "city.properties";
	private Properties properties;
	
	public CityConfiguration(){
		this.loadProperties();
	}
	private Properties loadProperties() {
//		Properties properties;
		ClassLoader loader = JuheConfiguration.class.getClassLoader();
		URL url = loader.getResource(CITY_PROPERTY);
		properties = new Properties();
		try {
			FileInputStream inputFile = new FileInputStream(url.getFile());
			properties.load(inputFile);
			inputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public Properties getProperties(){
		return this.properties;
	}
}
