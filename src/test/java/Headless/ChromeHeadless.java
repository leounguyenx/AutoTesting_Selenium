package Headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeHeadless {
    WebDriver driver;
    //Headless browser testing: Test runs without UI
    //https://www.browserstack.com/guide/selenium-headless-browser-testing
    @Test
    public void verifyTitle() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.browserstack.com/");
        System.out.println("Title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");

        driver.quit();

    }

    @Test
    public void verifyTitleWithoutHeadless() {
        driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/");
        System.out.println("Title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
    }
}
