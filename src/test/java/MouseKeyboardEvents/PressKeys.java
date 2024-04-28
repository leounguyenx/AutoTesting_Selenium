package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PressKeys {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement first = driver.findElement(By.name("firstname"));
        first.sendKeys("Leo");

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.TAB)
                        .sendKeys("Nguyen").keyDown(Keys.TAB).pause(Duration.ofSeconds(1))
                        .sendKeys("testleo@gmail.com").keyDown(Keys.TAB)
                        .sendKeys("256699333").keyDown(Keys.TAB)
                        .sendKeys("123456").keyDown(Keys.TAB)
                        .sendKeys("123456").keyDown(Keys.TAB)
                        .keyDown(Keys.ARROW_LEFT).keyDown(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                        .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();




        Thread.sleep(Duration.ofSeconds(5));
        driver.close();
    }
}


