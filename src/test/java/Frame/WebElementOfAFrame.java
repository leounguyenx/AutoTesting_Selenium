package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementOfAFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://blogpendingtasks.blogspot.com/p/switchtoframeusingwebelement.html");

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='arunmotoori']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.linkText("Home")).click();



        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
