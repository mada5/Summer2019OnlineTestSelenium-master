package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {

    public static void main(String[] args) {
        // create a webdriver object, to work with a browser
        WebDriver driver = new BrowserFactory().getDriver("chrome");
        driver.manage().window().maximize(); // to maximize browser window
        driver.get("http://google.com");

        // wait for 3 seconds
        //this is our custom method
        //since method is static, we can use class name to call method
        //as a parameter, we provide number of seconds(time in seconds)
        BrowserUtils.wait(3);

        //how to print page title
        System.out.println(driver.getTitle());

        driver.navigate().to("http://amazon.com");

        //navigate back to google (previous url)
        driver.navigate().back();

        //move forward to the amazon again
        driver.navigate().forward();

        // to refresh/reload a web-page/ website
        driver.navigate().refresh();

        //shutdown browser
        driver.quit();

        // what will happen, if i will call driver again
       // driver.get("http://google.com"); // you can not write anything after quiting, it will
        // give a exception , so we have to recreate an object of webDriver
    }


}
