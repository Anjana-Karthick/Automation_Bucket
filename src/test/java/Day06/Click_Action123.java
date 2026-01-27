package Day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Click_Action {

    WebDriver driver=new ChromeDriver();

@Test
        void Setup() {
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

      WebElement click= driver.findElement(By.xpath("//input[@title=\"Search for Products, Brands and More\"]"));
    Actions a1=new Actions(driver);
    a1.click().perform();
    driver.quit();

    }
    }


