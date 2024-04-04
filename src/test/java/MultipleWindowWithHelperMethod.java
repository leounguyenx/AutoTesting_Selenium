import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowWithHelperMethod {
        static WebDriver driver = new ChromeDriver();
        static Set<String> allWindows;

    public static void main(String[] args) throws InterruptedException {

        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.id("ta1")).sendKeys("Bo");

        //Get parent window
        //Every window has unique ID
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window: " +  parentWindowHandle);

        //Open a popup window
        driver.findElement(By.linkText("Open a popup window")).click();
        System.out.println("Opened popup");

        //Open a new tab
        driver.findElement(By.linkText("Blogger")).click();

        //Capture all open windows
        allWindows = driver.getWindowHandles();

        switchToRequireWindow("New Window");
        String textOnChildWindow = driver.findElement(By.className("example")).getText();
        System.out.println(textOnChildWindow);

        switchToRequireWindow("Blogger.com - Create a unique and beautiful blog easily.");
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();

        driver.switchTo().window(parentWindowHandle);
        driver.findElement(By.id("ta1")).sendKeys("I'm back!!");

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();

    }

    public static void switchToRequireWindow (String title) {
        Iterator<String> i = allWindows.iterator();

        while (i.hasNext()) {
            String childWindow = i.next();

            //Switch to new window
            driver.switchTo().window(childWindow);

            if (driver.getTitle().equals(title)){
                System.out.println("Switched to new window successfully.!");
                break;
            }
        }

    }
}