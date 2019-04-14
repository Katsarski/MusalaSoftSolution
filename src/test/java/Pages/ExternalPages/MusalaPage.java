package Pages.ExternalPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MusalaPage extends BasePage {
    public MusalaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "brand")
    public WebElement companyLogo;

}
