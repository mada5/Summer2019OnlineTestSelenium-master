package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CalenderEventsPage extends BasePage {
    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalenderEvent;

    public void clickToCreateCalenderEvent(){
        BrowserUtils.waitForVisibility(createCalenderEvent,5);
        BrowserUtils.waitForClickablility(createCalenderEvent,5);
        createCalenderEvent.click();
    }
}
