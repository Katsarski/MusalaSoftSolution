package Pages.ExternalPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInPage extends BasePage {
    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "lazy-image org-top-card-primary-content__logo Elevation-0dp loaded")
    public WebElement companyLogo;

}
