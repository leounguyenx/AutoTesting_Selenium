package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClick {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");

        WebElement doubleTarget = driver.findElement(By.id("testdoubleclick"));

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleTarget).perform();


        Thread.sleep(Duration.ofSeconds(5));
        driver.close();
    }
}