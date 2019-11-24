package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.ArrayList;
import java.util.List;


public class VerifyListSize {
    /*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size()
methods.
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        List<WebElement> linklist = driver.findElements(By.xpath("//li[@class='list-group-item']"));
        System.out.println("The number of listed examples are " + linklist.size() );
        driver.quit();

    }
}
