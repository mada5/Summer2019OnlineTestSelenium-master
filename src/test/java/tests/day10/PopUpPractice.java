package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @Test(description = "Click on button 1 and click OK in pop up message")
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.wait(2);
        //to deal with pop-up, we can create object of Alert
        //Switches to the currently active model dialog
        Alert alert = driver.switchTo().alert();
        alert.accept();  //to click on OK
        BrowserUtils.wait(2);

    }
    @Test(description = "Click on button 2 and click on Cancel in pop up message")
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();
        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //to click cancel
        BrowserUtils.wait(2);
        alert.dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test(description = "Click on button 3, enter some text and click ok")
    public  void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("Java is fun!");
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
