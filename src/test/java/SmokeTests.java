import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;
import sun.misc.GThreadHelper;

import static org.testng.Assert.assertEquals;


public class SmokeTests {


    public WebDriver driver ;

    @BeforeTest
    public void beforeTestSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.out.println("launching Chrome browser");
        driver = new ChromeDriver();
    }


    @Test
    public  void firstTest() throws InterruptedException {
         String baseUrl = "http://demo.guru99.com/test/radio.html";
        driver.get(baseUrl);
        System.out.println("In first Test");

                // declaration and instantiation of objects/variables
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement radio3 = driver.findElement(By.xpath("//input[@id='vfb-7-3']"));
        Thread.sleep(10000);
        //Radio Button1 is selected
        radio1.click();
        System.out.println("Radio Button Option 1 Selected");
        Thread.sleep(5000);
        //Radio Button1 is de-selected and Radio Button2 is selected
        radio2.click();
        System.out.println("Radio Button Option 2 Selected");
        Thread.sleep(5000);
        radio3.click();
        System.out.println("Radio Button Option 3 Selected");
        Thread.sleep(10000);
                // Selecting CheckBox
                WebElement option1 = driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
                // This will Toggle the Check box
                option1.click();
        Thread.sleep(5000);
        // Selecting CheckBox2
        WebElement option2 = driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        // This will Toggle the Check box
        option2.click();
        Thread.sleep(5000);
        // Selecting CheckBox3
        WebElement option3 = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        // This will Toggle the Check box
        option3.click();
        Thread.sleep(5000);
                // Check whether the Check box is toggled on
                if (option1.isSelected()) {
                    System.out.println("Checkbox is Toggled On");

                } else {
                    System.out.println("Checkbox is Toggled Off");
                }

                driver.close();

            }// end of first test

            @Test//click an image using xpath
            public void secondTest() throws InterruptedException {
                driver.get("https://www.amazon.in");
                Thread.sleep(10000);
                driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bottle");
                Thread.sleep(5000);
                driver.findElement(By.xpath("//input[@value='Go']")).click();
                Thread.sleep(5000);
                //click on the "Amazon" logo on the upper left portion
                driver.findElement(By.xpath("//span[@class='nav-sprite nav-logo-base']")).click();
                Thread.sleep(10000);
                driver.close();
            }

            public static void testMethod()
            {
                int a =1;
                String str= "testing";
                boolean bool= false;
            }

            @Test
            public void ThirdTest() throws InterruptedException {
                SmokeTests.testMethod();
                String baseUrl = "http://demo.guru99.com/test/upload/";
                driver.get(baseUrl);
                WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
                Thread.sleep(5000);
                // enter the file path onto the file-selection input field
                uploadElement.sendKeys("/home/nikhil_pc/IdeaProjects/seleniumTutorial/FileToBeUploaded.xml");
                // check the "I accept the terms of service" check box
                driver.findElement(By.id("terms")).click();
                // click the "UploadFile" button
                driver.findElement(By.name("send")).click();
            }

            @Test
    public void downloadFileTest()
            {
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                WebDriver driver = new ChromeDriver(options);
                driver.navigate().to("https://www.pexels.com/");
                //We find the download links
                List<WebElement> list =driver.findElements(By.className("photo-item__img"));
                //Click the last one to downaload 5MB file :)
                WebElement el = list.get(list.size()-1);
                el.click();

            }

    @Test
    public void testSimpleAlert() throws InterruptedException {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
// Click Simple button to show an Alert box
        driver.findElement(By.id("simple")).click();
// Optionally we can also wait for an Alert box using the WebDriverWait;
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Get the text displayed on Alert
        String textOnAlert = alert.getText();
// Check correct message is displayed to the user on Alert box
        assertEquals("Hello! I am an alert box!", textOnAlert);
        Thread.sleep(10000);
// Click OK button, by calling accept method
        alert.accept();
    }

    @Test
    public void testConfirmAccept() throws InterruptedException {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
// Click Confirm button to show Confirmation Alert box
        driver.findElement(By.id("confirm")).click();
        // Optionally we can also wait for an Alert box using the WebDriverWait;
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Click OK button, by calling accept method
        Thread.sleep(10000);
        alert.accept();
// Check Page displays correct message
        WebElement message = driver.findElement(By.id("demo"));
        assertEquals("You Accepted Alert!", message.getText());
    }

    @Test
    public void testConfirmDismiss() throws InterruptedException {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
// Click Confirm button to show Confirmation Alert box
        driver.findElement(By.id("confirm")).click();
        // Optionally we can also wait for an Alert box using the WebDriverWait;
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Click Cancel button, by calling dismiss
        Thread.sleep(5000);
        alert.dismiss();
        Thread.sleep(5000);
// Check Page displays correct message
        WebElement message = driver.findElement(By.id("demo"));
        assertEquals("You Dismissed Alert!", message.getText());
        Thread.sleep(5000);
        driver.close();
    }
//prompt alert

    @Test
    public void testPrompt() throws InterruptedException {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
// Click Confirm button to show Prompt Alert box
        driver.findElement(By.id("prompt")).click();
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Enter some value on Prompt Alert box
        alert.sendKeys("Foo");
// Click OK button, by calling accept method
        Thread.sleep(10000);
        alert.accept();
// Check Page displays message with value entered in Prompt
        WebElement message = driver.findElement(By.id("prompt_demo"));
        assertEquals("Hello Foo! How are you today?",
                message.getText());
    }
    @Test
    public void scrollDownByPixel() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Launch the application
        driver.get("https://www.amazon.in/");
        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below
        driver.manage().window().maximize();
        Thread.sleep(5000);
        // This  will scroll down the page by  1500 pixel vertical
        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void scrollUp() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Launch the application
        driver.get("https://www.mahadiscom.in/");
        Thread.sleep(5000);
        //To maximize the window. This code may not work with Selenium 3 jars. If script fails you can remove the line below
        driver.manage().window().maximize();
        // This  will scroll down the page by  1000 pixel vertical
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
       WebElement element= driver.findElement(By.xpath("//h5[contains(text(),'Quick Bill Payment')]"));
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(5000);
        driver.close();
    }
    //working with web tables
    @Test
    public void testWebTable() throws InterruptedException {
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        WebElement simpleTable = driver.findElement(By.xpath("//table[@id='customers']"));
        Thread.sleep(5000);
// Get all rows
        List<WebElement> rows =
                simpleTable.findElements(By.tagName("tr"));
        assertEquals(7, rows.size());
// Print data from each row
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");

            }
            System.out.println();
        }
        driver.close();
    }
    //Synchronizing a test with an implicit wait
    @Test
    public void testWithImplicitWait() {

// Launch the sample Ajax application
        driver.get("http://www.gmail.com/");
// Set the implicit wait time out to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
// Get login to Gmail
            driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("www.nikschandwani@gmail.com");
                                                    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("#niks%7756#");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                                    driver.findElement(By.xpath("//input[@placeholder='Search mail']")).click();

// Get an element with id page4 and verify it's text
            WebElement message = driver.findElement(By.id("//div[@id=':z0']//span[@name='Jabong Updates'][contains(text(),'Jabong Updates')]"));
            Assert.assertTrue(message.getText().contains("Jabong Updates"));
        } finally {
            driver.quit();
        }
    }
    }

