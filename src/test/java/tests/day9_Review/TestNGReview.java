package tests.day9_Review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");
    }
    @Test(description = "Verify title of google.com", priority = 2)
    public void test1(){
        System.out.println("Test 1");
        driver.get("http://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Title is not correct!");

    }
    //priority will change the order of test execution
    //by default tests are running in alphabetic order (a,b,c,d.. from the method name)
    //lower priority - earlier execution
    // lower priority number - higher priority of execution
    //tests will run like this: priority 1, priority 2, priority 3...
    //default is 0
    @Test(description = "verify title of apple.com" , priority = 1)
    public void verifyApplePageTitle(){
        System.out.println("Test 2");
        driver.get("http://www.apple.com");
        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct!");
        System.out.println("Test passed!");
    }
    //   data provider can supply test with a test data. Also, it allows to do Data Driven Testing.
//   What is this? It's when same test runs multiple times with different test data set
    @DataProvider
    public static Object[][]testData(){
        return new Object[][]{{"http://www.apple.com", "Apple"}, {"http://google.com" , "Google"} };
    }
    //data provider must return 2d array of Object
    //1st parameter  = 1 object in the inner array, 2nd parameter = 2 object in the inner array
    // url = https://www.apple.com/, title = Apple
    // url = http://google.com, title = Google
    //we can have as many sets of data as we want
    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url, String title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
        driver.quit();
    }
}
