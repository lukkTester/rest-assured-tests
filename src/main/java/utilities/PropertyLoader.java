package utilities;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String loadPathProperty(String property) throws IOException {

        Properties properties = new Properties();
        properties.load(PropertyLoader.class.getClassLoader().getResourceAsStream("paths.properties"));

        return properties.getProperty(property);
    }
}
