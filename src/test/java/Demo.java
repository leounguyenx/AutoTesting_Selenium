import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) throws InterruptedException {


        //WebDriverManager library - Make jobs easy instead of execution files (


        //Only supports Edge,Chrome,Firefox browsers

        //Change name to access a specific browser
        String browserName = "chrome";

        WebDriver driver = null;

        if (browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        /**COMMANDS**/

        //manage().window().maximize()/minimize(): maximize or minimize the current webpage
        driver.manage().window().maximize();
        //driver.manage().window().minimize();

        //get(): Load a new web page in the current browser window
        //http:// needs to be provided
        driver.get("https://omayo.blogspot.com/");

        /**findElement**/
        /**By Class**/
        //id() is one the static method of By class
        //driver.findElement(By.id("alert1")).click();

        //name()
        //driver.findElement(By.name("q")).sendKeys("Male");

        //className()
        //driver.findElement(By.className("gsc-search-button")).click();

        //linkText()
        //Inside anchor tag: <a href="http://only-testing-blog.blogspot.in/2014/01/textbox.html">onlytestingblog</a>
        //driver.findElement(By.linkText("onlytestingblog")).click();

        //partialLinkText()
        //driver.findElement(By.partialLinkText("onlytesting")).click();

        //cssSelector()
        //driver.findElement(By.cssSelector("#confirm")).click();

        //xpath()
        //driver.findElement(By.xpath("//input[@id='confirm']")).click();

        /**WebElement Interface**/
        //Performs multiple operations in the same element
        //Return WebElement type
        //
        // WebElement textField = driver.findElement(By.id("textbox1"));
        // textField.clear();
        // textField.sendKeys("Ho Diem Uyen Nguyen");
        // textField.clear();
        // textField.sendKeys("Selenium 4");
        //

        /**ACTION**/

        /**click():  Button, link, checkbox option and radio option**/
        //driver.findElement(By.xpath("//input[@id='checkbox2']")).click();

        /**getText()**/
        //The text between the starting and ending of tags of HTML elements
        //String getText = driver.findElement(By.xpath("//textarea[normalize-space()='The cat was playing in the garden.']")).getText();
        //System.out.println(getText);

        /**getTitle()**/
        //String siteTitle = driver.getTitle();
        //System.out.println(siteTitle);

        /**getCurrentUrl()**/
        //String currentURL = driver.getCurrentUrl();
        //System.out.println(currentURL);

        //Use this command to see the difference between close() and quit()
        //driver.findElement(By.xpath("//a[@id='selenium143']")).click();
        //Open pop-up
        //driver.findElement(By.linkText("Open a popup window")).click();

        /**close(): close current (tab) window browser after executed**/
        //driver.close();

        /**Thread.sleep(): Stop or hold this program in a specific time**/
        //Thread.sleep(Duration.ofSeconds(6));

        /**quit(): close multi window - close all the tabs open in this current window**/
        //driver.quit();

        /**getAttribute(): Retrieve the value stored in the specified attribute value of the html element**/
        //Apply for case: <input value="search"/> => Does not have text between tag (ending tag) => Can not use getText()

        //WebElement getElement = driver.findElement(By.cssSelector("input[title='search'][type='submit']"));
        //String getAttributeValue = getElement.getAttribute("class");
        //String getAttributeValue1 = getElement.getAttribute("type");
        //String getAttributeValue2 = getElement.getAttribute("title");
        //System.out.println(getAttributeValue + "," + getAttributeValue1 + "," + getAttributeValue2);

        /**isDisplayed(): check whether the element is displayed on the page or not before performing operations on it**/
        //WebElement getDisplayElement = driver.findElement(By.cssSelector("#alert1"));
        //WebElement getHiddenElement = driver.findElement(By.id("hbutton"));
        //boolean isDisplayed = getHiddenElement.isDisplayed();
        //System.out.println(isDisplayed);

        //if (isDisplayed){
        //    getHiddenElement.click();
        //}
        //else {
        //    System.out.println("This element is not displayed");
        //}

        /**isEnabled()**/
        //WebElement enableButton = driver.findElement(By.cssSelector("#but2"));
        //WebElement disableButton = driver.findElement(By.cssSelector("#but1"));
        //boolean isDisplayed = disableButton.isEnabled();

        //if (isDisplayed){
        //    System.out.println("This element is enabled");
        //}
        //else {
        //    System.out.println("This element is disabled");
        //}

        /**isSelected(): Find out whether the radio options or check options are selected or not**/
        //boolean selectedElement = driver.findElement(By.id("checkbox1")).isSelected();
        //boolean unselectedElement = driver.findElement(By.id("checkbox2")).isSelected();

        //if (unselectedElement){
        //    System.out.println("This element is selected");
        //}
        //else {
        //    System.out.println("This element is not selected");
        //}

        /**navigate(): Navigate back to prev page, navigates forward again or refreshing the current**/
        //driver.findElement(By.linkText("Selenium143")).click();
        //Thread.sleep(Duration.ofSeconds(2));
        //driver.navigate().back();
        //Thread.sleep(Duration.ofSeconds(2));
        //driver.navigate().forward();
        //Thread.sleep(Duration.ofSeconds(2));
        //driver.navigate().refresh();
        //Thread.sleep(Duration.ofSeconds(2));
        //driver.navigate().to("https://www.google.com.vn/");

        /**getPageSource(): Retrieve all the source code of current page and return in the form of String**/
        //driver.navigate().to("https://testpages.herokuapp.com/selenium/basic_web_page.html");
        //String getPageSource = driver.getPageSource();
        //System.out.println(getPageSource);

        /**submit(): submit a form**/
        //We can take any elements of the form to submit
        //Login
        /*
        driver.navigate().to("https://tutorialsninja.com/demo/");
        driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        Thread.sleep(Duration.ofSeconds(1));
        driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-password")).submit();
        */

        /**getTagName()**/
        //String getTagName = driver.findElement(By.id("ta1")).getTagName();
        //System.out.println(getTagName);

        /**getCssValue()**/
        /*
        String cssValue = driver.findElement(By.id("blogsmenu")).getCssValue("margin");
        if (cssValue.equals("0px")){
            System.out.println(cssValue);
        }
        else {
            System.out.println("Value is not matched.");
        }
        */

        /**getSize(): get width and height of the given element**/
        //Dimension getSize = driver.findElement(By.id("but2")).getSize();
        //System.out.println("Height: " + getSize.height + ", Width: " + getSize.width);

        /**getLocation(): get the x and y coordinate position of the given element**/
        //Point getLocation = driver.findElement(By.id("but2")).getLocation();
        //System.out.println("X: " + getLocation.x + ", Y: " + getLocation.y);

        /**getRect(): Get both size and location**/
        //Rectangle rect = driver.findElement(By.id("but2")).getRect();
        //System.out.println("Location: " + rect.getX() + ", "+ rect.getY());
        //System.out.println("Size: " + rect.getWidth() + ", "+ rect.getHeight());

        /**fullscreen()**/
        //driver.manage().window().fullscreen();

        /**setSize()**/
        //Dimension d = new Dimension(200,400);
        //driver.manage().window().setSize(d);

        /**getClass(): Retrieve the class name of the provided object**/
        //getSimpleName() => Convert to String
        //String className = driver.getClass().getSimpleName();
        //System.out.println(className);

        /**pageLoadTimeout(): Change the default time (Set a limit time wait) for loading web page**/
        //By default: Unlimited
        //Have to write before the render site

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.navigate().to("http://www.selenium143.blogspot.com/");









        Thread.sleep(Duration.ofSeconds(5));
        driver.close();
    }
}
