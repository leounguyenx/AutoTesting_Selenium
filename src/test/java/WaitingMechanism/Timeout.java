package WaitingMechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Timeout {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**By default, Selenium will wait the webpage to load until it completes to operate **/

        //Customize the limit of pageLoadTimeout => Throw TimeoutException
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(500));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));

        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.id("ta1")).sendKeys("Hi Leo");

        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();

    }
}
