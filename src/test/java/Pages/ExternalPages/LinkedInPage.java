package Pages.ExternalPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedInPage extends BasePage {
    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "top-card__logo-container top-card__logo-container--desktop")
    public WebElement companyLogo;

}
