package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        // enter email and password
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        //enter password
        // * matches any element
        //it's better to specify tag name, to avoid issues with finding element
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
        //click on login button
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();
        BrowserUtils.wait(3);
        driver.quit();
    }
}
