package Property_Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class AddPropertyByOwner {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/authenticate");

        /**Test suite 1: Add property by Owner**/
        //Login as owner
        driver.findElement(By.xpath("//input[@placeholder='User name']")).sendKeys("bowner");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //Add property
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//button[normalize-space()='Add property']")).click();
        if (driver.findElement(By.xpath("//h2[normalize-space()='Create new property']")).getText().equals("Create new property")){
            driver.findElement(By.xpath("//div[contains(@class,'g-sidenav-show')]//div[1]//div[1]//button[1]")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Town home']")).click();

            driver.findElement(By.xpath("//input[@id='propertyPrice']")).sendKeys("123456789");
            driver.findElement(By.xpath("//input[@id='numberOfRoom']")).sendKeys("2");
            driver.findElement(By.xpath("//input[@id='street']")).sendKeys("Create by automation test");
            driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Testing City");

            WebElement element = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(3) > form:nth-child(1) > div:nth-child(7) > div:nth-child(2) > button:nth-child(1)"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();

            WebElement element2 = driver.findElement(By.xpath("//a[normalize-space()='Alabama']"));
            actions.moveToElement(element2).click().build().perform();
            driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys("9999");

            //Click on "Submit"
            WebElement element3 = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            actions.moveToElement(element3).click().build().perform();
            Thread.sleep(Duration.ofSeconds(1));

            /**Upload file**/
            File uploadFile = new File("src/test/images/house1.jpeg");
            Thread.sleep(Duration.ofSeconds(1));
            WebElement fileInput = driver.findElement(By.xpath("(//input[@name='file'])[1]"));
            fileInput.sendKeys(uploadFile.getAbsolutePath());
            driver.findElement(By.xpath("//button[normalize-space()='Upload']")).click();
            //Verify
            Thread.sleep(5000);
            String expectedResult = "File uploaded successfully";
            String actualResult = driver.findElement(By.xpath("//div[normalize-space()='File uploaded successfully']")).getText();
            if (actualResult.equals(expectedResult)){
                System.out.println("Uploaded");
            }

            //Back to properties list after created a property
            WebElement element4 = driver.findElement(By.xpath("//a[normalize-space()='Back to properties']"));
            actions.moveToElement(element4).click().build().perform();

            String expectedURL = "http://localhost:3000/owner/properties";
            String actualURL = driver.getCurrentUrl();
            if (actualURL.equals(expectedURL)){
                System.out.println("Navigate to Properties List successfully!");
            }
            else {
                System.out.println("Navigate to URL after created Property failed!!");
            }
        }
        else {
            System.out.println("Can not navigate to Add Property Page");
        }



        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();
    }
}
