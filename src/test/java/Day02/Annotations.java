package Day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Annotations {

    WebDriver driver;

    @BeforeTest
    void login (){
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
       // System.out.println("Before Suite");
        System.out.println("Before Test");
        driver.quit();
    }

    @Test
    void home (){
        System.out.println("Successfully navigated to Homepage");
    }

    @Test
    void Order() {
        System.out.println("Successfully Placed the order");
    }

    @AfterTest
    void Logout(){
        driver.quit();
        //System.out.println("After Suite");
        System.out.println("After Test");
    }

}
