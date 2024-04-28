package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyDownUp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        Actions actions = new Actions(driver);

        WebElement find = driver.findElement(By.linkText("compendiumdev"));

        //actions.moveToElement(find).click().perform();

        //Automate open the new tab by keyboard
        //Press and hold one of the key => keyDown
        actions.keyDown(Keys.COMMAND)
                .moveToElement(find).click()
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        Thread.sleep(Duration.ofSeconds(5));
        driver.close();
    }
}


