package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchivePage extends BasePage {

    @FindBy(xpath = "//div[(@class='col-md-4 col-sm-6 event-box-mobile') and position()=last()]")
    public WebElement lastEvent;

    public ArchivePage(WebDriver driver) {
        super(driver);
    }

    public EventPage openLastEvent(){
        waitForElementToLoad(lastEvent);
        lastEvent.click();
        waitForPageToLoad();
        return new EventPage(driver);
    }
}
