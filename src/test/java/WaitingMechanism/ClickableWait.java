package WaitingMechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickableWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://verifalia.com/validate-email");

        driver.findElement(By.name("inputData")).sendKeys("john.smith@example.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement validateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Validate']")));
        validateButton.click();

        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='Container'] div:nth-child(2) h4:nth-child(1)")));

        if (content.getText().equals("Security check")){
            System.out.println("Successfully");
        }
        else {
            System.out.println("Try again.");
        }

        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();

    }
}
