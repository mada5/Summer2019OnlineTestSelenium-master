package tests.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class StatusCodes {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @Test
    public void test9(){
        driver.findElement(By.linkText("200")).click();
        String expectedResult = "This page returned a 200 status code";
        String actualResult = driver.findElement(By.xpath("//p")).getText();
        System.out.println(actualResult);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
