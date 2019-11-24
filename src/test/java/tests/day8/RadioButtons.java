package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
       driver = BrowserFactory.getDriver("chrome");
       driver.get("https://practice-cybertekschool.herokuapp.com/");
        //to go to Radio Buttons page
        // <a href="/ radio_bttons">Radio Buttons</a>
        // linkText works only with <a> elements
        // link text only in between >Text<
       driver.findElement(By.linkText("Radio Buttons")).click();

    }
    @Test(description = "Verify that blue button is selected")
    public void test1(){
        //find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        //verify that radio button is selected
        //if button is selected it will return true, otherwise false
        Assert.assertTrue(blueButton.isSelected());

    }
    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());

    }
    @Test(description = "Verify that green button is not clickable")
    public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        //isEnabled() will return true if button is available for interaction
        //that means you can click on it, in this case
        Assert.assertFalse(greenButton.isEnabled());
    }
    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all radio buttons?
        //find all radio button
        //any radio button will have type='radio' and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement button: radioButtons) {
            //if button is available for clicking and not clicked yet
            if(button.isEnabled() && !button.isSelected()){
                //then click on it
                button.click();
                System.out.println("Button clicked: " + button.getAttribute("id"));
            }
            else{
                System.out.println("Button was not clicked: " + button.getAttribute("id"));
            }
            BrowserUtils.wait(1);
        }
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
