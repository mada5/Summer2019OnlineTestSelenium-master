package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // to maximize browser
        driver.manage().window().maximize();
        driver.get("http://google.com");
        // we want to navigate, to the different page
        driver.navigate().to("http://amazon.com");
        //if you want to comeback, to the previous page
        driver.navigate().back();
        // if you want to know the URL of current website
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.close();

    }
}
