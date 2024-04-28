package MouseKeyboardEvents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ContextClickJQuery {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement target = driver.findElement(By.xpath("//span[text()='right click me']"));
        WebElement quitOption = driver.findElement(By.xpath("//span[text()='Quit']"));
        Actions actions = new Actions(driver);

        actions.contextClick(target).moveToElement(quitOption).click().build().perform();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        if (alertText.equals("clicked: quit")){
            System.out.println("OK");
            alert.accept();
        } else {
            System.out.println("Try again!");
        }

        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}
