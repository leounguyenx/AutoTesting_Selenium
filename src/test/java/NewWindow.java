import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("ta1")).sendKeys("Hi Leo");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://google.com");
        driver.close();

        /**NoSuchWindow Exception**/
        driver.switchTo().window("XYZ");

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }


}
