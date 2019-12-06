package tests.vyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalenderEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;

public class CreateCalendarEventTests extends TestBase {

    @Test(description = "Verify owners name is equal to Stephan Haley(it works on qa1  storemanager85")
    public void test1(){

        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        //login as Stephan Haley(storemanager85)
        loginPage.login("storemanager85","UserUser123");

        //go to calender events page
        loginPage.navigateTo("Activities","Calender Events");

        //click on create calender event button
        calenderEventsPage.clickToCreateCalenderEvent();

        String expectedOwner = "Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText();

        Assert.assertEquals(actualOwner,expectedOwner);
    }
}
