import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class AuthenticationPopup {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String username = "admin";
        String password = "admin";
        String domain = "the-internet.herokuapp.com/basic_auth";

        String url = "https://" + username + ":" + password + "@" + domain;
        driver.get(url);

        String expectedText = driver.findElement(By.cssSelector("div[class='example'] p")).getText();

        if(expectedText.equals("Congratulations! You must have the proper credentials.")){
            System.out.println("OK");
        }
        Thread.sleep(Duration.ofSeconds(2));
        driver.quit();
    }
}
