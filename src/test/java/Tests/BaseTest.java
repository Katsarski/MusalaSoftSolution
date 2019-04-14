package Tests;

import Helpers.ConfigurationReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Expose an instance of the static driver and the configuration reader so tests can use them
    protected static WebDriver driver;
    protected static ConfigurationReader configurationReader = new ConfigurationReader();

    @BeforeClass
    public static void setUp(){

        if (ConfigurationReader.getInstance().getBrowserForTests().equals("Firefox")){
            System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") +
                    "\\drivers\\firefoxdriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(ConfigurationReader.getInstance().getBrowserForTests().equals("Chrome")){
            System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") +
                    "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
       driver.quit();
    }

}
