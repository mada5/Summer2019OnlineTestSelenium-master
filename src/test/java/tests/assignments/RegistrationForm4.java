package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class RegistrationForm4 {
    /*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a valid
Email format is not correct”
     */
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("email")).sendKeys("testers@email");
        String warningMessage1 = driver.findElement(By.xpath("//form[@id='registrationForm']/div[4]/div/small[2]")).getText();
        String warningMessage2 = driver.findElement(By.xpath("//form[@id='registrationForm']/div[4]/div/small[3]")).getText();

        System.out.println(warningMessage1 + "\n" + warningMessage2);

        driver.quit();

    }

}
