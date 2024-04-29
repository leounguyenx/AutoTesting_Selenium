package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Firefox_FullpageScreenshot {
    public static void main(String[] args) throws IOException, InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        File scrFile = driver.getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File("./src/test/Screenshots/FullpageFirefox.png"));

        /*
        * Or
        * WebDriver driver = new FirefoxDriver();
        *
        *....
        *
        * File scrFile = ((FirefoxDriver) driver).getFullPageScreenshotAs(...);
        *
        * */

        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
        
    }
}
