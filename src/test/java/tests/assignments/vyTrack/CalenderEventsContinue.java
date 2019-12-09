package tests.assignments.vyTrack;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderEventsContinue {


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver,15);
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1(){
        Actions action = new Actions(driver);
        WebElement threeDots = driver.findElement(By.xpath(" //tbody/tr[13]/td[9]/div/div/a"));
        action.moveToElement(threeDots).perform();
        BrowserUtils.wait(5);
        WebElement view = driver.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-eye hide-text']"))).perform();
        Assert.assertTrue(view.isDisplayed());
        BrowserUtils.wait(1);
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"))).perform();
        BrowserUtils.wait(1);
        action.moveToElement(threeDots.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"))).perform();
        BrowserUtils.wait(2);

    }
    @Test(description = "Verify that “Title” column still displayed")
    public void test2(){
        driver.findElement(By.cssSelector("a[title='Grid Settings']")).click();

        List<WebElement> gridList = driver.findElements(By.xpath("//tbody/tr[@class='renderable']/td[3]/input"));

         for(int i = 1; i< gridList.size(); i++){
            gridList.get(i).click();
            Assert.assertFalse(gridList.get(i).isSelected());
        }
        BrowserUtils.wait(3);


    }
    @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void test3(){

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement saveAndCloseButton = driver.findElement(By.cssSelector("a[class='btn-success btn dropdown-toggle']"));
        BrowserUtils.wait(2);
        saveAndCloseButton.click();
        List<WebElement> options = driver.findElements(By.xpath("//li/button"));
        for (WebElement option: options
             ) {
            option.isEnabled();
            System.out.println(option.getText());

        }
        BrowserUtils.wait(3);

    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4(){

        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement cancelButton = driver.findElement(By.xpath("//a[@title='Cancel']"));
        BrowserUtils.wait(2);
        cancelButton.click();
        BrowserUtils.wait(2);
        String expectedTitle = "All Calendar Events";
        String actualTitle = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle,"Sub title is not correct!");

    }
    @Test(description = "Verify that difference between end and start time is exactly 1 hour" )
    public void test5(){

        WebElement loaderMask = driver.findElement(By.xpath("//div[@class='loader-mask']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        //click start time
        WebElement startTime = driver.findElement(By.xpath("//label[text()='Start']/parent::div/following-sibling::div/div/input[2]"));
        BrowserUtils.wait(2);
        startTime.click();

        String sTime = startTime.getAttribute("value");

        WebElement endTime = driver.findElement(By.xpath("//label[text()='End']/parent::div/following-sibling::div/div/input[2]"));
        endTime.click();
        String eTime = endTime.getAttribute("value");











    }
    @Test
    public void test6(){
        WebElement loaderMask = driver.findElement(By.xpath("//div[@class='loader-mask']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        //Start time
        WebElement startTime = driver.findElement(By.xpath("//label[text()='Start']/parent::div/following-sibling::div/div/input[2]"));
        BrowserUtils.wait(2);
        startTime.click();

        //Selects 9:00 PM
        WebElement timeSelected = driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper']/ul/li[43]"));
        timeSelected.click();

        WebElement endTime = driver.findElement(By.xpath("//label[text()='End']/parent::div/following-sibling::div/div/input[2]"));
        endTime.click();
        BrowserUtils.wait(3);
        String selectedTime = endTime.getAttribute("value");
        Assert.assertEquals(selectedTime,"10:00 PM");



    }
    @Test(description = "Verify that All day Event check box is selected")
    public void test7(){
        WebElement loaderMask = driver.findElement(By.xpath("//div[@class='loader-mask']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        WebElement allDayEventBox = driver.findElement(By.xpath(" //label[text()='All-day event']/parent::div/following-sibling::div/input"));
        BrowserUtils.wait(2);
        allDayEventBox.click();
        WebElement startTime = driver.findElement(By.xpath("//label[text()='Start']/parent::div/following-sibling::div/div/input[2]"));
        WebElement endTime = driver.findElement(By.xpath("//label[text()='End']/parent::div/following-sibling::div/div/input[2]"));
        Assert.assertTrue(allDayEventBox.isSelected());
        BrowserUtils.wait(2);
        Assert.assertFalse(startTime.isDisplayed());
        Assert.assertFalse(endTime.isDisplayed());




    }
    
    @Test(description ="Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void test8(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        BrowserUtils.wait(3);
        WebElement repeatBox = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        Select select = new Select(repeatBox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Daily");
        BrowserUtils.wait(3);
        repeatBox.click();
        List<WebElement> list = driver.findElements(By.xpath("//select[@name='temp-validation-name-125']/option"));
        for (int i = 0; i < list.size(); i++){
            list.get(i).isEnabled();

        }


    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day")
    public void test9(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatButton = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.wait(3);
        repeatButton.click();
        Assert.assertTrue(repeatButton.isSelected());
        WebElement repeatEveryButton = driver.findElement(By.xpath("//span[text()='day(s)']/preceding-sibling :: input[3]"));
        Assert.assertTrue(repeatEveryButton.isSelected());
        WebElement neverButton = driver.findElement(By.xpath("//span[text()='Never']/preceding-sibling :: input"));
        Assert.assertTrue(neverButton.isSelected());
        WebElement summary = driver.findElement(By.xpath("//span[text()='Daily every 1 day']"));
        Assert.assertTrue(summary.isDisplayed());


    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences")
    public void test10(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatButton = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.wait(3);
        repeatButton.click();

        //Click "After" radio button
        driver.findElement(By.xpath("//span[text()='After']/preceding-sibling :: input")).click();

        //send 10 into occurrence box
        driver.findElement(By.xpath("//span[text()='After']/following-sibling :: input")).sendKeys("10",Keys.ENTER);

        String expectedMessage = "Daily every 1 day, end after 10 occurrences";
        String actualMessage = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']/div")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);


    }
    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021")
    public void test11(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatButton = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.wait(3);
        repeatButton.click();

        //Click "By" button
        driver.findElement(By.xpath("//span[text()='By']/preceding-sibling :: input")).click();
        driver.findElement(By.xpath("//span[text()='By']/parent :: label/following-sibling :: span/div/input[2]")).click();
        WebElement monthName = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthName);
        select.selectByValue("10");

        WebElement year = driver.findElement(By.className("ui-datepicker-year"));
        Select select1 = new Select(year);
        select1.selectByValue("2021");

        driver.findElement(By.xpath("//table/tbody/tr[3]/td[5]/a")).click();


        String expectedMessage = "Daily every 1 day, end by Nov 18, 2021";
        String actualMessage = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']/div")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test(description = "Verify that “Monday and Friday” options are selected and Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday")
    public void test12(){
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        WebElement repeatButton = driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        BrowserUtils.wait(3);
        repeatButton.click();
        WebElement repeatBox1 = driver.findElement(By.xpath("//div[@data-name='recurrence-settings']/div/div/div/select"));
        repeatBox1.click();
        BrowserUtils.wait(3);
        Select select = new Select(repeatBox1);
        select.selectByValue("weekly");

        WebElement monday =  driver.findElement(By.cssSelector("input[value='monday']"));
        monday.click();
        BrowserUtils.wait(3);
        Assert.assertTrue(monday.isSelected());
        WebElement friday =  driver.findElement(By.cssSelector("input[value='friday']"));
        friday.click();
        Assert.assertTrue(friday.isSelected());

        
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
