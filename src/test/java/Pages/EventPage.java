package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventPage extends PageObject{

    @FindAll(
    @FindBy(xpath = "//li[contains(@class, 'list-group-item header-timeslot') and contains(., 'Day')] | //div[contains(@class, 'speaker-info')]")
    )
    public List<WebElement> eventDayElements;
    @FindBy(id = "map-canvas")
    public WebElement googleMapsIFrame;


    public EventPage(WebDriver driver) {
        super(driver);
    }

    public void printEventDays(){
        System.out.println(eventDayElements.size());
        for (WebElement eDay : eventDayElements) {
            System.out.println(eDay.getText());
        }
    }
}
