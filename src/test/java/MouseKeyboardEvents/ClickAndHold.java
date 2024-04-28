package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ClickAndHold {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement obj = driver.findElement(By.id("box1"));
        WebElement target = driver.findElement(By.id("box101"));

        Actions actions = new Actions(driver);

        //Click and Hold
        //Move to element
        //Release
        actions.clickAndHold(obj).moveToElement(target).release().build().perform();

        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}


