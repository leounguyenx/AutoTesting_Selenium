import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LightboxHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        driver.findElement(By.linkText("HP LP3065")).click();
        driver.findElement(By.xpath("(//a/img[@title='HP LP3065'])[1]")).click();

        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//button[@title='Previous (Left arrow key)']")).click();
        driver.findElement(By.xpath("//button[@class='mfp-close']")).click();

        System.out.println("OK");
        Thread.sleep(Duration.ofSeconds(10));
        driver.quit();
    }
}
