package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BasePageObject {
    protected WebDriver driver;

    public BasePageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToLoad(){
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectMainTab(){
        ArrayList<String> availableBrowserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(availableBrowserTabs.get(availableBrowserTabs.size() - availableBrowserTabs.size()));
    }

    public void selectLastOpenedTab(){
        ArrayList<String> availableBrowserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(availableBrowserTabs.get(availableBrowserTabs.size() - availableBrowserTabs.size() + 1));
    }

    public void waitForElementToLoad(WebElement elementToWaitFor){
        WebDriverWait wait = new WebDriverWait(driver, 30); //here, wait time is 20 seconds
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }
}
