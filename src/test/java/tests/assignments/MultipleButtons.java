package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class MultipleButtons {
    /*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”

     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();
    }
}
