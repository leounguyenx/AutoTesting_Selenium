package WaitingMechanism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingProcessWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /**1st solution: Wait till loading is finish**/

        WebElement loadedContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        System.out.println(loadedContent.getText());

        /**2nd solution Wait till loading image is disappear - Not work in this case**/
//        Boolean loaded = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']/img")));
//        if (loaded == true) {
//            String finishText = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
//            System.out.println(finishText);
//        }
//        else {
//            System.out.println("Try again!");
//        }

        /**3rd solution: Checking by using List and while loop**/
//        List<WebElement> imgList = driver.findElements(By.xpath("//div[@id='loading']/img"));
//        int countTime = 0;
//
//        while (imgList.size()!=0 && countTime <= 10){
//
//            Thread.sleep(Duration.ofSeconds(1));
//            countTime++;
//        }
//
//        String loadedContent = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
//        System.out.println(loadedContent);





        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();

    }
}
