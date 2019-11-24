package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {
    // command + option + L - to organize code for Mac
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void test1() {
        //find all checkboxes
        //any checkbox will have [type='checkbox']
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        int index = 1;
        for (WebElement checkbox: checkboxes) {
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
                System.out.println("Checkbox #"+ index+ " was clicked: ");
            }else{
                System.out.println("Checkbox #" + index + " was not clicked");
            }
            index++;
        }


    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
