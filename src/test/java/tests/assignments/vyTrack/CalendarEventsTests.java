package tests.assignments.vyTrack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarEventsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(2);
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){
        String expectedSubTitle = "Options";
        String actualSubTitle = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']")).getText();
        System.out.println(actualSubTitle);
        Assert.assertEquals(actualSubTitle,expectedSubTitle,"Sub title is not correct!");

    }
    @Test(description = "Verify that page number is equals to \"1\"")
    public void test2(){
       WebElement pageNumber = driver.findElement(By.cssSelector("input[value='1']"));
       Assert.assertTrue(pageNumber.isDisplayed());

    }
    @Test(description = "Verify that view per page number is equals to \"25\"")
    public void test3(){
        String expectedViewPerPage = "25";
        String actualViewPerPage = driver.findElement(By.xpath("//div[@class='grid-toolbar clearfix']/div[3]/div[2]/div/div/button")).getText();
        Assert.assertEquals(actualViewPerPage,expectedViewPerPage,"View per page number is not correct!");

    }
    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody/tr"));
        String totalRecord = driver.findElement(By.xpath("//label[@class='dib'][3]")).getText();
        String numberOfRecords = "" + checkBoxes.size();
        Assert.assertTrue(totalRecord.contains(numberOfRecords));

    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5(){
        driver.findElement(By.xpath("//div[@class='btn-group dropdown']/button/input")).click();
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//tbody/tr/td/input"));
        for (WebElement checkBox:checkBoxes) {
           Assert.assertTrue(checkBox.isSelected());
        }

    }
    @Test(dataProvider = "testData")
    public void test6(String xpath, String respond){
        WebElement testersMeeting = driver.findElement(By.xpath("//td[text()='Testers meeting']"));
        wait.until(ExpectedConditions.visibilityOf(testersMeeting));
        wait.until(ExpectedConditions.elementToBeClickable(testersMeeting));
        testersMeeting.click();
        Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(),respond);
    }
    @DataProvider
    public static Object[][]testData(){
        return new Object[][]{{"//div[text()='Testers meeting']", "Testers meeting"}, {"//div[text()='This is a a weekly testers meeting']"
                , "This is a a weekly testers meeting"}, {"//div[text()='Nov 27, 2019, 9:30 AM']","Nov 27, 2019, 9:30 AM"}
                ,{"//div[text()='Nov 27, 2019, 10:30 AM']","Nov 27, 2019, 10:30 AM"}
                ,{"//div[text()='No']","No"},{"//div[@class='calendar-event-organizer']/a","Stephan Haley"},{"//span[@class='list-group-item-text']/a","Tom Smith"}
                ,{"//div[text()='Weekly every 1 week on Wednesday']","Weekly every 1 week on Wednesday"},{"//label[text()='Call via Hangout']/parent::div/div/div","No"}};
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
