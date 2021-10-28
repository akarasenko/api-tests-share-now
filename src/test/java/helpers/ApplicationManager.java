package helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

    private Properties properties;

    public ApplicationManager() throws IOException {
        this.properties = new Properties();
        FileReader file = new FileReader(new File(String.format("src/test/resources/%s.properties", System.getProperty("target", "local"))));
        this.properties.load(file);
    }

    public String getProperty(String name) {
        return this.properties.getProperty(name);
    }
}
