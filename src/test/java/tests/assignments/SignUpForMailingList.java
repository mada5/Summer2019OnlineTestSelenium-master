package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class SignUpForMailingList {
    /*

Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List” Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed:
“Thank you for signing up. Click the button below to return to the home page.”
 Home button should be displayed.
     */
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Yasmin");
        driver.findElement(By.name("email")).sendKeys("ayse69turk@gmail.com");
        driver.findElement(By.className("radius")).click();

        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualResult = driver.findElement(By.name("signup_message")).getText();
        BrowserUtils.wait(2);
        verification(expectedResult, actualResult);

        driver.quit();

    }
    public static void verification(String expected, String actual){
if(expected.equals(actual)){
    System.out.println("PASSED");
}else{
    System.out.println("FAILED");
}
    }

}
