import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Problem: When an alert appears, we cannot proceed other operations**/

        driver.get("https://omayo.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Information Alert
//        driver.findElement(By.id("alert1"));
//        wait.until(ExpectedConditions.alertIsPresent());

        //Confirmation Alert
        driver.findElement(By.id("confirm")).click();
        wait.until(ExpectedConditions.alertIsPresent());

        //If we switch to Alert() but what if alert is not exist => NoAlertPresentException
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        //alert.dismiss();

        //This operation will be blocked by alert if we don't handle => "UnhandledAlertException"
        driver.findElement(By.id("ta1")).sendKeys("Hi Leo");



        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();

    }
}

/**TYPE OF ALERTS
 * 1. Information
 * 2.Confirmation
 * 3.Prompt
 * **/
