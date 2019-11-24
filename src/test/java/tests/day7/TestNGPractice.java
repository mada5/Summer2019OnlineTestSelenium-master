package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {
    @Test
    public void test() {
        // to verify that expected and actual result is same
        //if no-it will throw exception and stop the program
        //also, you will see int the console what was expected
        //and what was actually
        Assert.assertEquals("apple", "apple");
    }

    @Test(description = "Verifying title of the practice website")
    public void verifyTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is wrong");
        driver.quit();
    }

    @Test(description = "verify that Test Automation Practice heading is displayed")
    public void verifyHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
        //to make sure that element is visible to user
        //because element can be present, but not visible
        //we need to make sure element is visible
        //Element is not visible - will be printed, the element is there, but not visible
        //assertTrue - method that checks if something is true
        //if it;s false, you will get exception
        //.isDisplayed() return true or false
        //if it returns true- that means element is visible
        //if this method return false - element is not visible
        Assert.assertTrue(heading.isDisplayed(),"Element is not visible");
        driver.quit();
    }


}