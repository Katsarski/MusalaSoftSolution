package Pages;

import Pages.ExternalPages.FacebookPage;
import Pages.ExternalPages.LinkedInPage;
import Pages.ExternalPages.MusalaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[(@class='btn btn-nav') and text() = 'Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//img[(@src='/images/Musala-logo.png')]")
    public WebElement footerCompanyLink;
    @FindBy(xpath = "//img[(@src='/images/icon_linkedin.png')]")
    public WebElement footerLinkedInLink;
    @FindBy(xpath = "//img[(@src='/images/icon_facebook.png')]")
    public WebElement footerFacebookLink;
    @FindBy(xpath = "//a[(@class='btn btn-nav') and text() = 'Archive']")
    public WebElement archiveButton;

    public SignInPage navigateToSignInPage(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public ArchivePage navigateToArchivePage(){
        archiveButton.click();
        waitForPageToLoad();
        return new ArchivePage(driver);
    }

    public MusalaPage navigateToMusalaCompanyPage(){
        footerCompanyLink.click();
        selectLastOpenedTab();
        waitForPageToLoad();
        return new MusalaPage(driver);
    }

    public LinkedInPage navigateToMusalaLinkedInPage() throws InterruptedException {
        footerLinkedInLink.click();
        selectLastOpenedTab();
        //remove sleep and throws statement before submitting
        Thread.sleep(1000);
        waitForPageToLoad();
        return new LinkedInPage(driver);
    }

    public FacebookPage navigateToMusalaFacebookPage(){
        footerFacebookLink.click();
        selectLastOpenedTab();
        waitForPageToLoad();
        return new FacebookPage(driver);
    }

}
