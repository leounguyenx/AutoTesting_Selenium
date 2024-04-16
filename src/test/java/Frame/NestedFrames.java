package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NestedFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://letcode.in/frame");

        driver.switchTo().frame("firstFr");

        driver.findElement(By.name("fname")).sendKeys("Leo");
        driver.findElement(By.name("lname")).sendKeys("Nguyen");

        WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
        driver.switchTo().frame("innerFrame");
        driver.findElement(By.name("email")).sendKeys("leounguyen75@gmail.com");



        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
