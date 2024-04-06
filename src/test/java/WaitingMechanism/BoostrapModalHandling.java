package WaitingMechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoostrapModalHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://getbootstrap.com/docs/4.0/components/modal/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement simpleDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bd-example'][1]/button")));
        simpleDialog.click();
        WebElement actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModalLiveLabel")));
        String actualText = actual.getText();

        if (actualText.equals("Modal title")){
            System.out.println("OK");
        }
        else {
            System.out.println("Try again!.");
        }

        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@aria-label='Close'])[2]")));
        closeButton.click();

        Thread.sleep(Duration.ofSeconds(10));
        driver.quit();
    }
}
