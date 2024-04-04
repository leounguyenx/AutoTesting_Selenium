package Property_Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class EditPropertyByOwner {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("force-device-scale-factor=0.75");
        options.addArguments("high-dpi-support=0.75");
        WebDriver driver = new ChromeDriver(options);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/authenticate");

        /**Test suite 1: Add property by Owner**/
        //Login as owner
        driver.findElement(By.xpath("//input[@placeholder='User name']")).sendKeys("bowner");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='button']")).click();



        //Go to Edit property of the first property
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();

        //Verify navigate to Edit property Page
        String actualResult = driver.findElement(By.xpath("(//h2[normalize-space()])[2]")).getText();
        String expectedResult = "Edit property";

        if (actualResult.equals(expectedResult)){
            System.out.println("You are in Edit Property Page");
        }
        else {
            System.out.println("Fail!!");
        }

        //Change information
        driver.findElement(By.id("street")).sendKeys("Edit by Automation Test");

        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        //driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();





        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();
    }
}
