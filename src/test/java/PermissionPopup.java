import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class PermissionPopup {
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--enable-notifications");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://permission.site/");

        driver.findElement(By.xpath("//button[@id='notifications']")).click();

        Thread.sleep(Duration.ofSeconds(10));
        driver.quit();
    }
}
