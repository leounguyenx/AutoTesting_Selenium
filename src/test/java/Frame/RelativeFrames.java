package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RelativeFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //Switch to parent TOP FRAME
        driver.switchTo().frame("frame-top");

        /**
         * It is not possible to switch from sibling1 to sibling2. We have to go back to parent frame
         */

        //Switch to parent LEFT FRAME
        driver.switchTo().frame("frame-left");

        String leftFrameText = driver.findElement(By.xpath("//body")).getText();
        System.out.println(leftFrameText);

        //Switch back to PARENT TOP FRAME
        driver.switchTo().parentFrame();

        //Switch to parent MIDDLE FRAME
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        /**
         * It is not possible to switch from sibling of parent1 frame to parent2 frame.
         * We have to go back to parent1 frame then go parent2 frame
         **/

        //Switch back directly to the page level
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//body")).getText());

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
