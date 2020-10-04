package ProjectMaven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReaderUtils {
	
	
	
	public static String getProperty(String property) {
		Properties props = new Properties();
		String propValue = null;
		
		try(InputStream input = PropertyReaderUtils.class.getClassLoader().
				getResourceAsStream("config.properties")){
			if(input == null) {
				System.out.println("File Unavailable");
				return "";
			}
			props.load(input);
			propValue = props.getProperty(property);
			
		} catch(IOException e) {
			
		}
		
		return propValue;
	}

}
