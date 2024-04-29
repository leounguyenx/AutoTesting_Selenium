package Screenshots;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenshotWithRobotClass {
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        //Take a screenshot with URL
        //Take a screenshot with displayed alert
        driver.findElement(By.id("alert1")).click();

        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        //String screenshotPath = "./src/test/Screenshots/screenshot2.png";
        ImageIO.write(bufferedImage, "png", new File("./src/test/Screenshots/robot.png"));


        /*We need to handle to close the alert when using driver.close()*/
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(Duration.ofSeconds(3));
        driver.close();
    }
}
