package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JQueryDropdown {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();

        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        By singleDrop = By.id("justAnotherInputBox");
        By selectedOption = By.xpath("(//span[text()='choice 2 2'])[3]");

        getWebElement(singleDrop).click();
        waitToClick(selectedOption);

        /*---*/
        By multiDrop = By.id("justAnInputBox1");
        By selectOption1 = By.xpath("(//input[@type='checkbox'])[16]");
        By selectOption2 = By.xpath("(//input[@type='checkbox'])[19]");
        By selectOption3 = By.xpath("(//input[@type='checkbox'])[21]");

        getWebElement(multiDrop).click();
//        waitToClick(selectOption1);
//        waitToClick(selectOption2);
//        waitToClick(selectOption3);

        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@id='comboTree430107DropDownContainer']//span[@class='comboTreeItemTitle']"));

        System.out.println("Click all options: " + allOptions.size());
        for (WebElement o : allOptions) {
            System.out.println("Clicked");
            o.click();
        }

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }

    public static WebElement getWebElement(By locator){
        return driver.findElement(locator);
    }

    public static void waitToClick(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }

}
