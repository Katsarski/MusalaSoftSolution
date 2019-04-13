package Tests;

import Pages.ArchivePage;
import Pages.EventPage;
import Pages.HomePage;
import Pages.SignInPage;
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
        assertEquals(signInPage.getWrongCredentialsErrorMessage(),
                configurationReader.getWrongCredentialsErrorMessage());
     }

     //Test Case 2
     @Test
     public void verifyHomePageLinksAndLogos(){
         driver.get((configurationReader.getURL()));

         HomePage homePage = new HomePage(super.driver);
         homePage.navigateToMusalaCompanyPage();
         assertEquals(configurationReader.getCompanyLinkDestination(),
                 driver.getCurrentUrl());

         homePage.selectMainTab();

         homePage.navigateToMusalaLinkedInPage();
         assertEquals(configurationReader.getLinkedInLinkDestination(),
                 driver.getCurrentUrl());

         homePage.selectMainTab();

         homePage.navigateToMusalaFacebookPage();
         assertEquals(configurationReader.getFacebookLinkDestination(),
                 driver.getCurrentUrl());
     }

    //Test Case 3
    @Test
    public void verifyArchivePage(){
        driver.get((configurationReader.getURL()));

        HomePage homePage = new HomePage(super.driver);
        ArchivePage archivePage = homePage.navigateToArchivePage();
        EventPage eventPage = archivePage.openLastEvent();
        eventPage.printEventDays();
        assertTrue(eventPage.googleMapsIFrame.isDisplayed());
    }

}
