package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ContextClick {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement searchTarget = driver.findElement(By.xpath("//input[@name='search']"));

        Actions actions = new Actions(driver);

        actions.contextClick(searchTarget).perform();


        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}
