import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ListboxField {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        WebElement multiSelect = driver.findElement(By.id("multiselect1"));
        Select select = new Select(multiSelect);

        if (select.isMultiple()) {
            select.selectByVisibleText("Audi");
            select.selectByIndex(0);
            select.selectByValue("swiftx");

            select.deselectByIndex(0);
            select.deselectByValue("audix");

            select.deselectAll();

            select.selectByVisibleText("Audi");
            select.selectByIndex(0);
            select.selectByValue("swiftx");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            System.out.println("List of selected options: ");
            for (WebElement selectedOp : selectedOptions) {
                System.out.println(selectedOp.getText());
            }

            System.out.println("-----");

            String firstSelectedOp = select.getFirstSelectedOption().getText();
            System.out.println("First selected option: " + firstSelectedOp);

        }
        else {
            System.out.println("This is single selection");
            List<WebElement> options = select.getOptions();

            System.out.println("List of options: ");
            for(WebElement option : options) {
                System.out.println(option.getText());
            }
        }

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }
}
