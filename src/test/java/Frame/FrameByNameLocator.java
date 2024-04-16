package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameByNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://docs.oracle.com/javase/8/docs/api/");

        //Frames

        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Description")).click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.linkText("java.applet")).click();

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
