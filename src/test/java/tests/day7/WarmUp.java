package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com/");
        //how to find all links?
        //every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: " + links.size());
        //what if I want to print text of all links one bye one
        //loop through the collection of links
        for (WebElement webElement: links) {
            if(!webElement.getText().isEmpty()) {
                System.out.println(webElement.getText());
            }
        }
        driver.quit();
    }
}
