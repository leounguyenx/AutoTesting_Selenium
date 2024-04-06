package WaitingMechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class ImplicitExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Implicit Wait and Explicit Wait**/
        /**Implicit
         *
         * Maximum time to wait is 10 secs until throw exception
         * If element is available, it will not wait
         * Global wait (All the elements have the maximum waiting time
         *
         * Implicit time should be max 10 secs
         * **/
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.className("dropbtn")).click();

        //Thread.sleep(Duration.ofMillis(10000));

        /**Explicit
         *
         * Solve the global waiting time for all the elements with different max waiting time
         * 1.WebDriverWait
         * 2.FluentWait
         * */

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        WebElement gmailOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
//        gmailOption.click();

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement gmailOption = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.linkText("Gmail"));
            }
        });
        gmailOption.click();

        /**
         *
         * Why pollingEvery?
         * Optimizing the performance of your tests by avoiding unnecessary waiting
         *
         * **/



        driver.quit();
    }
}
