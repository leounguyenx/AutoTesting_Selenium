package MouseKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MoveToElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");

        Actions actions = new Actions(driver);

        WebElement block = driver.findElement(By.id("blogsmenu"));
        /** Any of predefined methods of the Actions class to run or work => .perform()**/
        /** If use more than 1 reference object Actions => .build() **/

        actions.moveToElement(block).perform();

        WebElement option1 = driver.findElement(By.xpath("//span[text()='SeleniumByArun']"));

        actions.moveToElement(option1).click().build().perform();

//        actions.click().perform();



        Thread.sleep(Duration.ofSeconds(2));
        driver.close();
    }
}
