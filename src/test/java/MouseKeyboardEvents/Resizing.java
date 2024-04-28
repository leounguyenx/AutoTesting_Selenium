package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Resizing {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resizable/");

        WebElement frameElement = driver.findElement(By.className("demo-frame"));

        driver.switchTo().frame(frameElement);

        WebElement resizeableButton = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));

        Actions actions = new Actions(driver);

        actions.dragAndDropBy(resizeableButton, 100, 120).perform();

        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}


