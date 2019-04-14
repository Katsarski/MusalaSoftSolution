package Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static ConfigurationReader instance;
    private static String configurationFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration.properties";
    
    private static String url;
    private static String wrongUsername;
    private static String wrongPassword;
    private static String wrongCredentialsErrorMessage;
    private static String footerCompanyLinkDestination;
    private static String linkedInLinkDestination;
    private static String facebookLinkDestination;

    private static String browserForTests;

    //We need only one ConfigurationReader at all times so we make it singleton
    public static ConfigurationReader getInstance () {
        if (instance == null) {
                instance = new ConfigurationReader();
                instance.loadData();
        }
        return instance;
    }

    //Read and assign fields from configuration file
    private void loadData() {
        Properties props = new Properties();

        //Attempt read from the configuration.properties file
        try {
            props.load(new FileInputStream(configurationFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file not found");
        }

        //Assign fields with the values from the configuration.properties file
        url = props.getProperty("url");
        wrongUsername = props.getProperty("wrongUsername");
        wrongPassword = props.getProperty("wrongPassword");
        wrongCredentialsErrorMessage = props.getProperty("wrongCredentialsErrorMessage");
        browserForTests = props.getProperty("browserForTests");
        footerCompanyLinkDestination = props.getProperty("footerCompanyLinkDestination");
        linkedInLinkDestination = props.getProperty("linkedInLinkDestination");
        facebookLinkDestination = props.getProperty("facebookLinkDestination");
    }

    //Expose the configuration values through Getters
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

    public String getBrowserForTests() {
        return browserForTests;
    }

    public String getCompanyLinkDestination(){ return footerCompanyLinkDestination; }

    public String getLinkedInLinkDestination() { return linkedInLinkDestination; }

    public String getFacebookLinkDestination() { return facebookLinkDestination; }
}
