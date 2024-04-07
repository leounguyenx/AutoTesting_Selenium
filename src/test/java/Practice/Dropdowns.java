package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdowns {
        static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://letcode.in/dropdowns");

        By fruits = By.id("fruits");
        selectOption(fruits,"visibleText", "Apple");

        String actualText = driver.findElement(By.xpath("(//p[@class='subtitle'])[1]")).getText();
        if (actualText.equals("You have selected Apple")){
            System.out.println("Awesome! 1st is completed");
        }
        else {
            System.out.println("Try again!");
        }

        /*-----*/
        By superheros = By.id("superheros");
        selectOption(superheros,"index","0");
        selectOption(superheros,"index","1");

        List<WebElement> selectedList = selectedList(superheros);

        for (WebElement o : selectedList){
            System.out.println(o.getText());
        }

        if (selectedList.size() == 2) {
            System.out.println("Awesome! 2nd is completed");
        }
        else {
            System.out.println("Try again!");
        }

        /*-----*/
        By languages = By.id("lang");
        selectOption(languages, "visibleText", "C#");
        String text = selectedList(languages).get(0).getText();
        if (text.equals("C#")){
            System.out.println("Awesome! 3rd is completed");
        }
        System.out.println("List of languages: ");
        for (WebElement o : allOptions(languages)){
            System.out.println(o.getText());
        }

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();
    }

    public static WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    public static Select getSelect(By locator){
        return new Select(getWebElement(locator));
    }

    public static void selectOption(By locator, String optionType, String option){

        Select select = getSelect(locator);

        switch (optionType) {
            case "visibleText":
                select.selectByVisibleText(option);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(option));
                break;
            case "value":
                select.selectByValue(option);
                break;
        }
    }

    public static List<WebElement> selectedList (By locator){
        return getSelect(locator).getAllSelectedOptions();
    }

    public static List<WebElement> allOptions (By locator) {
        return getSelect(locator).getOptions();
    }
}
