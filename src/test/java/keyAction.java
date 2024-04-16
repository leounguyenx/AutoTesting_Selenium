import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class keyAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("fromCity")).click();
        WebElement fromField = driver.findElement(By.xpath("//input[@placeholder='From']"));

        fromField.sendKeys("viet");
        Thread.sleep(Duration.ofSeconds(3));
        for (int i = 1; i < 5; i++) {
            Thread.sleep(Duration.ofSeconds(1));
            fromField.sendKeys(Keys.ARROW_DOWN);
        }
        fromField.sendKeys(Keys.ENTER);

        driver.findElement(By.id("toCity")).click();
        WebElement toField = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toField.sendKeys("iowa");
        Thread.sleep(Duration.ofSeconds(2));
        toField.sendKeys(Keys.ARROW_DOWN);
        toField.sendKeys(Keys.ENTER);


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autowhatever-1-section-0-item-1")));
//        option.click();
//        Thread.sleep(Duration.ofSeconds(3));
//        driver.findElement(By.id("react-autowhatever-1-section-0-item-1")).click();

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();

    }
}
