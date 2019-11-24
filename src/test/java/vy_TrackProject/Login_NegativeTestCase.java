package vy_TrackProject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Login_NegativeTestCase {
    /*
    •Go to the login page of VyTrack
    •Enter invalid credential (can be any role)
    •Click login button
    •Verify that the system shows error message “Invalid user name or password.”
     */

    public static void main(String[] args) {

        String[] users = new String[3];
        for (int i = 0; i < users.length; i++) {
            String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String character = "0123456789@#$%^&*";
            String randomUserName = RandomStringUtils.random(15, upper + character);
            users[i] = randomUserName;
        }

        loginFunctionality(users);
    }
    public static void loginFunctionality(String[] users){
        ArrayList<Boolean> list = new ArrayList<>();
        for(int i = 0; i < users.length; i++){

            // create  a driver object to get chrome browser
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://qa2.vytrack.com/user/login");  // takes to vy_tracking application page

            // locating elements for username and password
            WebElement username = driver.findElement(By.name("_username"));
            username.sendKeys(users[i]);
            WebElement password = driver.findElement(By.name("_password"));
            password.sendKeys("UserUser123");
            BrowserUtils.wait(1);

            // expected result
            String expectedResult = "Invalid user name or password.";


            // find the element for login button
            WebElement loginButton = driver.findElement(By.id("_submit"));
            loginButton.submit();
            BrowserUtils.wait(2);

            // actual result
            String actualResult = driver.findElement(By.xpath("//div[@class='alert alert-error']/div")).getText();
           

            // call the verify method from the verification class
            list.add(Verification.verify(expectedResult, actualResult));
            driver.close(); // close the current page
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(true)) {
                System.out.println(users[i] + " cannot login / Test Passed");
            }else{
                System.out.println(users[i] + " can login / Test Failed");
            }
        }


    }
}
