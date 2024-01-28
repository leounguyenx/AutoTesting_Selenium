import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        /**Handling StaleElementReferenceException**/
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='LinkList1']//a"));

//        for(WebElement e: links){
//            e.click();
//            System.out.println(e.getText());
//            driver.navigate().back();
//        }

        /**Solution 1: Traditional For Loop**/
        String path = "(//div[@id='LinkList1']//a)";

        for (int i = 1; i <= links.size(); i++){
            String ePath = path + "[" + i + "]";
            driver.findElement(By.xpath(ePath)).click();
            driver.navigate().back();
        }

        Thread.sleep(Duration.ofSeconds(3));
        driver.quit();

    }
}
