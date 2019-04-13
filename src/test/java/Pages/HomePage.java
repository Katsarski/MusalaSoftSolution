package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

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

    public void navigateToMusalaCompanyPage(){
        footerCompanyLink.click();
        selectLastOpenedTab();
        waitForPageToLoad();
    }

    public void navigateToMusalaLinkedInPage(){
        footerLinkedInLink.click();
        selectLastOpenedTab();
        waitForPageToLoad();
    }

    public void navigateToMusalaFacebookPage(){
        footerFacebookLink.click();
        selectLastOpenedTab();
        waitForPageToLoad();
    }

}
