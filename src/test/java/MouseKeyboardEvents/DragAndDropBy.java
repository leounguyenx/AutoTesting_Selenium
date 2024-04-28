package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDropBy {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/p/page3.html");

        WebElement minLabel = driver.findElement(By.xpath("//a[@aria-labelledby='price-min-label']"));

        WebElement maxLabel = driver.findElement(By.xpath("//a[@aria-labelledby='price-max-label']"));

        Actions actions = new Actions(driver);

        actions.dragAndDropBy(minLabel, -50, 0).perform();
        actions.dragAndDropBy(minLabel, 100, 0).perform();
        actions.dragAndDropBy(maxLabel, 40, 0).build().perform();


        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}
