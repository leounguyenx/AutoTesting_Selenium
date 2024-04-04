import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandlingMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
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
        Set<String> allWindows = driver.getWindowHandles();

        //Now iterate using Iterator (No index, unique)
        Iterator<String> i = allWindows.iterator();

        while (i.hasNext()) {
            String childWindow = i.next();

            //Switch to new window
            driver.switchTo().window(childWindow);

            if (driver.getTitle().equals("New Window")){
                //Get and print the text from popup window
                String textOnChildWindow = driver.findElement(By.className("example")).getText();
                System.out.println(textOnChildWindow);
                driver.close();
                break;
            }
        }

        Iterator<String> i1 = allWindows.iterator();

        while (i1.hasNext()){
            String childWindow = i1.next();

            driver.switchTo().window(childWindow);

            if(driver.getTitle().equals("Blogger.com - Create a unique and beautiful blog easily.")){
                Thread.sleep(Duration.ofMillis(100));
                //Click on Sign in
                driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
                driver.close();
                break;
            }
        }

        driver.switchTo().window(parentWindowHandle);
        driver.findElement(By.id("ta1")).sendKeys("I'm back!!");

        System.out.println("5 secs before quit this browser.");
        Thread.sleep(Duration.ofSeconds(5));

        driver.quit();

    }
}
/**
 main body
 {
    frame1
    {
        frame2
        frame3 (we are here currently)
    }
 }

 driver.switchTo().defaultContent(); => main body
 This will pass the control to the main document which contains the iframes

 driver.switchTo().parentFrame(); => frame1
 This will pass the control to the imminent parent frame of the current frame

 **/
