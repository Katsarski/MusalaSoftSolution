package Tests;

import Pages.ArchivePage;
import Pages.EventPage;
import Pages.ExternalPages.FacebookPage;
import Pages.ExternalPages.LinkedInPage;
import Pages.ExternalPages.MusalaPage;
import Pages.HomePage;
import Pages.SignInPage;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class Tests extends BaseTest {

    //Test Case 1
    @Test
    public void verifySignInWithInvalidCredentials(){
        driver.get(configurationReader.getURL());

       HomePage homePage = new HomePage(super.driver);

       SignInPage signInPage = homePage.navigateToSignInPage();
       signInPage.loginWithInvalidCredentials();
        Assert.assertEquals(signInPage.getWrongCredentialsErrorMessage(),
               configurationReader.getWrongCredentialsErrorMessage());
    }

    //Test Case 2
    @Test
    public void verifyHomePageLinksAndLogos() throws InterruptedException {
        driver.get((configurationReader.getURL()));

        //Navigate to company page and verify URL and logo
        HomePage homePage = new HomePage(super.driver);
        MusalaPage musalaPage = homePage.navigateToMusalaCompanyPage();
        Assert.assertEquals(configurationReader.getCompanyLinkDestination(),
                driver.getCurrentUrl());
        Assert.assertTrue(musalaPage.companyLogo.isDisplayed());
        driver.close();
        homePage.selectMainTab();

        //Navigate to company facebook page and verify URL and logo
        FacebookPage facebookPage = homePage.navigateToMusalaFacebookPage();
        Assert.assertEquals(configurationReader.getFacebookLinkDestination(),
                driver.getCurrentUrl());
        Assert.assertTrue(facebookPage.companyLogo.isDisplayed());
        driver.close();

        homePage.selectMainTab();

        //Navigate to company linkedin page and verify URL and logo
        LinkedInPage linkedInPage = homePage.navigateToMusalaLinkedInPage();
        Assert.assertEquals(configurationReader.getLinkedInLinkDestination(),
                driver.getCurrentUrl());
        Assert.assertTrue(linkedInPage.companyLogo.isDisplayed());
    }

    //Test Case 3
    @Test
    public void verifyArchivePage(){
        driver.get((configurationReader.getURL()));

        HomePage homePage = new HomePage(super.driver);
        ArchivePage archivePage = homePage.navigateToArchivePage();
        EventPage eventPage = archivePage.openLastEvent();
        eventPage.printEventDays();
        Assert.assertTrue(eventPage.googleMapsIFrame.isDisplayed());
    }

}
