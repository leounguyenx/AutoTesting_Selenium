package Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FrameByIndex {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://docs.oracle.com/javase/8/docs/api/");

        //Find number of frames on the page
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        int frameSize = frames.size();
        System.out.println(frameSize);

        int s;
        int index = 0;

        for(int i=0; i < frameSize; i++){
            driver.switchTo().frame(i);

            s = driver.findElements(By.linkText("Description")).size();

            if(s>0){
                index = i;
                driver.switchTo().parentFrame();
                break;
            }

            driver.switchTo().parentFrame();
        }
        driver.switchTo().frame(index);
        driver.findElement(By.linkText("Description")).click();



        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
