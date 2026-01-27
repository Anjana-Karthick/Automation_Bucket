package Day06;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import javax.swing.*;
import java.io.File;
import java.nio.file.attribute.FileAttribute;
import java.time.Duration;

public class practiseTestNG {

    WebDriver driver;

    @BeforeSuite
    void browser_open() {
        driver = new EdgeDriver();
    }

    @BeforeTest
    void browser_resolution() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    void waits(int a) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
    }


    @BeforeClass
    void browserConfirm() {
        System.out.println("Browser opened successfully");
    }

    @BeforeMethod
    void url_open(String a) {
        driver.get(a);
    }

    @Test(priority = -3)
    void cta_login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement signin = driver.findElement(By.xpath("//a[@href='/login']"));
        signin.click();
    }

    @Test(priority = -1)
    void newlogin(String username, String email) throws InterruptedException {
        Thread.sleep(2000);
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        userName.sendKeys(username);
        Email.sendKeys(email);

        WebElement Signup = driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]"));
        Signup.click();

        try {
            WebElement element = driver.findElement(By.xpath("//p[contains(text(),'Email')]"));
            String a = element.getText();
            if (a.equalsIgnoreCase("Email Address already exist!")) {
                System.out.println("Email Address already exist!");

                driver.close();
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Email Address is NEW");
        }

    }

    @Test(priority = 1)
    void EnterDetails(String pwd, String value, String Month, String Year, String Fname, String Lname,
                      String company, String address1, String address2, String value1, String statevalue,
                      String cityvalue, String zip, String Phnumber) throws InterruptedException {
        System.out.println("*****");
        Thread.sleep(4000);
        WebElement title = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        title.click();

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(pwd);

        //dropdown
        WebElement days = driver.findElement(By.name("days"));
        Select day = new Select(days);
        day.selectByValue(value);

        WebElement months = driver.findElement(By.name("months"));
        Select month = new Select(months);
        month.selectByVisibleText(Month);

        WebElement years = driver.findElement(By.name("years"));
        Select year = new Select(years);
        year.selectByValue(Year);

        //Checkbox handling
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();

        //Address Information
        //First name
        WebElement firstname = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstname.sendKeys(Fname);

        //Lastname
        WebElement lastname = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastname.sendKeys(Lname);

        //Company
        WebElement Company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
        Company.sendKeys(company);

        //Address1
        WebElement Address1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        Address1.sendKeys(address1);

        //Address2
        WebElement Address2 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
        Address2.sendKeys(address2);

        //Dropdown Country
        WebElement DdCountry = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select ddCountry = new Select(DdCountry);
        ddCountry.selectByVisibleText(value1);

        //State
        WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        State.sendKeys(statevalue);

        //City
        WebElement City = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        City.sendKeys(cityvalue);

        //Zipcode
        WebElement Zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        Zipcode.sendKeys(zip);

        //Mobile
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        Mobile.sendKeys(Phnumber);
        Thread.sleep(3000);
    }

    @Test
    void scroll() throws InterruptedException {
        //ScrollUp
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-360);");
        Thread.sleep(3000);
    }

    //Assert
    void Assert(String expected) {

        String Expected_Word = "expected";
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Receive special')]"));
        String Actual_Word = element.getText();

        if (Expected_Word.equals(Actual_Word)) {
            System.out.println("Validation passed");
        } else {
            System.out.println("Validation failed");
        }

        //ScrollDown
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,360);");
    }
        void submit_CTA () {
            //CreateAccount
            WebElement Submit = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
            Submit.click();

    }

    @AfterMethod
    void closing(){
        System.out.println("Account is being created");
    }
    @AfterClass
    void verify (){
        WebElement element = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        String text = element.getText();

        text.equalsIgnoreCase("Account Created!");
        System.out.println("Account Created! Successfully");
    }

    @AfterTest
    void screenshot(String image){
        TakesScreenshot ts = (TakesScreenshot)driver;
       File Capture= ts.getScreenshotAs(OutputType.FILE);
        File Target= new File("src/screenshots/"+image+".png");
        Capture.renameTo(Target);
        System.out.println("Screenshot taken successfully");

}

    @AfterSuite
    void Close_Browser(){
        driver.quit();
    }

    public static <Testing_Session> void main(String[] args) throws InterruptedException {

        practiseTestNG a = new practiseTestNG();
        // a.browser("Chrome");
       a.browser_open();
       a.browser_resolution();
       a.browserConfirm();
       a.url_open("https://automationexercise.com/login");
       a.waits(2);
        a.screenshot("image1");
        a.cta_login();
        a.newlogin("Anjana","xmen22236@gmail.com");
        a.EnterDetails("Anjana@123","1","January","2021", "Tiya","Papa",
                "TiyaTiffinCentre", "123, Vdavalli", "Coimbatore","Canada",
                "Tamilnadu","Coimbatore","600149","9500303039");
        a.scroll();
        a.Assert("Receive special offers from our partners!");
        a.submit_CTA();
        a.closing();
        a.verify();
        a.screenshot("image2");
        a.Close_Browser();
    }
}

