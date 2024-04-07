import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropdownHTML {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        WebElement dropdownField = driver.findElement(By.id("drop1"));

        /*
        * Select class is the predefined claas in Selenium WebDriver and it has predefined
        * to performing various on Dropdown fields.
        * => Create an object
        * */

        Select select = new Select(dropdownField);
        select.selectByVisibleText("doc 3");
        select.selectByIndex(2);
        select.selectByValue("jkl");

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
