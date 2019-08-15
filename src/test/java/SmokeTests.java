import java.io.*;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public void testSimpleAlert() {
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
// Click OK button, by calling accept method
        alert.accept();
    }

    @Test
    public void testConfirmAccept() {
        driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
// Click Confirm button to show Confirmation Alert box
        driver.findElement(By.id("confirm")).click();
        // Optionally we can also wait for an Alert box using the WebDriverWait;
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Click OK button, by calling accept method
        alert.accept();
// Check Page displays correct message
        WebElement message = driver.findElement(By.id("demo"));
        assertEquals("You Accepted Alert!", message.getText());
    }
    @Test
    public void testConfirmDismiss() {
// Click Confirm button to show Confirmation Alert box
        driver.findElement(By.id("confirm")).click();
        // Optionally we can also wait for an Alert box using the WebDriverWait;
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
// Get the Alert
        Alert alert = driver.switchTo().alert();
// Click Cancel button, by calling dismiss method
        alert.dismiss();
// Check Page displays correct message
        WebElement message = driver.findElement(By.id("demo"));
        assertEquals("You Dismissed Alert!", message.getText());
    }


}