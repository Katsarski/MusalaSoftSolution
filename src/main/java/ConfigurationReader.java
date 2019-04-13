import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static ConfigurationReader instance;
    private static String configurationFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.file";
    
    private static String url;
    private static String wrongUsername;
    private static String wrongPassword;
    private static String wrongCredentialsErrorMessage;

    //We need only one ConfigurationReader at all times so we make singleton
    public static ConfigurationReader getInstance () {
        if (instance == null) {
                instance = new ConfigurationReader();
                instance.loadData();
        }
        return instance;
    }

    //Populate the configuration fields with the values from the configuration.file
    private void loadData() {
        Properties props = new Properties();

        //Attempt read from the configuration.file properties
        try {
            props.load(new FileInputStream(configurationFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file not found");
        }

        //Assign fields with the properties from configuration.properties
        url = props.getProperty("url");
        wrongUsername = props.getProperty("wrongUsername");
        wrongPassword = props.getProperty("wrongPassword");
        wrongCredentialsErrorMessage = props.getProperty("wrongCredentialsErrorMessage");
    }

    public String getURL () {
        return url;
    }

    public String getWrongUsername () {
        return wrongUsername;
    }

    public String getWrongPassword () {
        return wrongPassword;
    }

    public String getWrongCredentialsErrorMessage () {
        return wrongCredentialsErrorMessage;
    }
}
