package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class RegistrationForm2 {
    /*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box. Step 4. Verify that warning message is displayed:
“The last name can only consist of alphabetical letters and dash”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("123");
        BrowserUtils.wait(2);
        String warningMassage =  driver.findElement(By.xpath("//form[@id='registrationForm']/div[2]/div/small[3]")).getText();
        System.out.println(warningMassage);
        driver.quit();

    }
}
