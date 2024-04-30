package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericMethod_DatePicker {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        WebElement calendarElement = driver.findElement(By.id("datepicker"));
        calendarElement.click();

        //Use Explicit Wait for the datepicker to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

        selectDateInCalendar("30", "February", "2025");

        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }

    public static void selectDateInCalendar(String selectDay, String selectMonth, String selectYear) {

        if (Integer.parseInt(selectDay) > 31) {
            System.out.println("Invalid Date Provided");
            return;
        }
        //Leap year?
        if (Integer.parseInt(selectYear) % 4 == 0 && Integer.parseInt(selectYear) % 400 == 0 && Integer.parseInt(selectYear) % 100 == 0){
            if(selectMonth.equals("February") && Integer.parseInt(selectDay) > 29){
                System.out.println("Invalid Date Provided");
                return;
            } else if (selectMonth.equals("April") || selectMonth.equals("June") ||
                    selectMonth.equals("September") || selectMonth.equals("November") && Integer.parseInt(selectDay) > 30){
                System.out.println("Invalid Date Provided");
                return;
            }
        } else {
            if(selectMonth.equals("February") && Integer.parseInt(selectDay) > 28){
                System.out.println("Invalid Date Provided");
                return;
            } else if (selectMonth.equals("April") || selectMonth.equals("June") ||
                    selectMonth.equals("September") || selectMonth.equals("November") && Integer.parseInt(selectDay) > 30){
                System.out.println("Invalid Date Provided");
                return;
            }
        }

        String currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
        System.out.println(currentDate);

        String[] monthYear = currentDate.split(" ");

        String month = monthYear[0];
        String year = monthYear[1];

        while (!(month.equals(selectMonth) && year.equals(selectYear))){
            driver.findElement(By.xpath("//a[@title='Next']")).click();

            currentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
            month = currentDate.split(" ")[0];
            year = currentDate.split(" ")[1];
        }
        //Dynamic xpath
        String xpathText = "//td[@data-handler='selectDay']/a[text()=\'"+selectDay+"\']";

        try {
            driver.findElement(By.xpath(xpathText)).click();
        } catch (Exception e) {
            System.out.println("Invalid Date Provided");
        }
    }
}
