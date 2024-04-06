import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPrompt {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        String parentWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String checkAlert = alert.getText();
        if (checkAlert.equals("I am a JS prompt")){
            alert.sendKeys("Leo is on the way");
            alert.accept();
        }
        else {
            alert.dismiss();
        }

        //Switch back to default window
        driver.switchTo().window(parentWindow);
        String expectedResult = "You entered: Leo is on the way";
        String actualResult = driver.findElement(By.id("result")).getText();
        if (actualResult.equals(expectedResult)){
            System.out.println("OK");
        }
        else {
            System.out.println("Please try again.!");
        }

        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();
    }
}
