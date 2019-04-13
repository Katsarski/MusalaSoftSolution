package Pages;

import Helpers.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    String wrongUsernameConf = ConfigurationReader.getInstance().getWrongUsername();
    String wrongPasswordConf = ConfigurationReader.getInstance().getWrongPassword();
    String wrongCredentialsErrorMessageConf = ConfigurationReader.getInstance().getWrongCredentialsErrorMessage();

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "btn-sign-in")
    private WebElement signInButton;

    @FindBy(xpath = "//p[(@class='state-muffin-message') and text() = 'Wrong user or password.']")
    private WebElement wrongCredentialsErrorMessage;

    public void loginWithInvalidCredentials(){
        usernameField.clear();
        usernameField.sendKeys(wrongUsernameConf);

        passwordField.clear();
        passwordField.sendKeys(wrongPasswordConf);

        signInButton.click();
    }

    public String getWrongCredentialsErrorMessage(){
        return wrongCredentialsErrorMessage.getText();
    }

}
