package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BootstrapDropdown {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");

        By menu1 = By.id("menu1");
        By accOption = By.xpath("(//ul[@class='dropdown-menu test']//a[text()='HTML'])[1]");
        By menu2 = By.id("menu2");
        //By accOption1 = By.xpath("(//ul[@class='dropdown-menu test']//a[text()='About Us'])[1]");

        waitToClick(menu1);
        waitToClick(accOption);
        waitToClick(menu2);

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }

    public static void waitToClick (By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }


}
