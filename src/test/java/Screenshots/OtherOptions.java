package Screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OtherOptions {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        //Take a screenshot for Web Element
        WebElement multiBox = driver.findElement(By.id("multiselect1"));
//        File scrFile = multiBox.getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(scrFile, new File("./src/test/Screenshots/screenshot3.png"));

        //Take a screenshot for a Section
        driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/login");
        WebElement section = driver.findElement(By.id("content"));
        File scrFile2 = section.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile2, new File("./src/test/Screenshots/section.png"));

        Thread.sleep(Duration.ofSeconds(5));
        driver.close();

        /*
        When you're taking a screenshot of a specific web element rather than the entire page, you typically use the getScreenshotAs() method provided by the WebElement interface itself.
        In this case, you don't need to cast the WebElement to TakesScreenshot because the WebElement interface already extends the TakesScreenshot interface.
        The WebElement interface inherits the getScreenshotAs() method from the TakesScreenshot interface, which means you can directly call this method on a WebElement object without any casting.
        */
        
    }
}
