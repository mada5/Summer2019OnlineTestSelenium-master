package vy_TrackProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.io.FileDescriptor;

public class Vy_TrackLoginFunctionality {
    /*
    •Go to the login page of VyTrack
    •Enter valid credential (can be any role)
    •Click login button
    •Verify that the user login successfully
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement username = driver.findElement(By.name("_username"));
        System.out.println(username);
        username.sendKeys("storemanager99");
        WebElement password = driver.findElement(By.name("_password"));
        System.out.println(password);
        password.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.submit();

       driver.close();

    }
    public static void verifyLogin(String expect, String actual){
        if (expect.equals(actual)) {

            System.out.println("PASS");
        }
        else{
            System.out.println("FAiLED");
        }
    }
}
