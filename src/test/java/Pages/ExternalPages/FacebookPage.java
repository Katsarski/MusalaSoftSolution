package Pages.ExternalPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends BasePage {
    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "_6tay")
    public WebElement companyLogo;

}
