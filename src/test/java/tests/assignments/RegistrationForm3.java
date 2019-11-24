package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class RegistrationForm3 {
    /*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “user” into username input box. Step 4. Verify that warning message is displayed:
“The username must be more than 6 and less than 30 characters long”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        String warningMassage = driver.findElement(By.xpath("//form[@id='registrationForm']/div[3]/div/small[2]")).getText();
        System.out.println( warningMassage);

        driver.quit();
    }
}
