package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class RegistrationForm5 {
    /*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “5711234354” into phone number input box.
Step 4. Verify that warning message is displayed: “Phone format is not correct”
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("phone")).sendKeys("5711234354");
        String warningMessage = driver.findElement(By.xpath("//form[@id='registrationForm']/div[6]/div/small[2]")).getText();
        System.out.println(warningMessage);
        driver.quit();
    }
}
