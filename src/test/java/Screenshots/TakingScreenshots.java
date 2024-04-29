package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;

public class TakingScreenshots {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        //Take screenshot with visible part
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Create a location to save the taken screenshot
        File destinationFile = new File("./src/test/Screenshots/screenshot1.png");
        //Copy and paste taken src to a specific location
        //FileUtils.copyFile(srcFile, destinationFile);
        FileHandler.copy(srcFile, destinationFile);

        //Take another screenshot
        driver.findElement(By.linkText("compendiumdev")).click();
        File srcFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile2, new File("./src/test/Screenshots/screenshot2.png"));

        Thread.sleep(Duration.ofSeconds(5));
        driver.close();

        /***
         * In Selenium, when you want to capture a screenshot of a web page, you typically use the TakesScreenshot interface.
         * This interface allows you to take a screenshot of the current state of the web browser. However, the WebDriver interface itself doesn't include methods for taking screenshots.
         * To access the screenshot-taking functionality provided by TakesScreenshot, you need to cast the WebDriver object to TakesScreenshot.
         * This casting enables you to utilize the methods defined in the TakesScreenshot interface, such as getScreenshotAs(), which actually captures the screenshot.
         *
         * **/
    }
}
