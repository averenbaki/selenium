package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02cssSelector {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void calculate() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on Calculate under Micro Apps.
        driver.findElement(By.cssSelector("a[id='calculatetest']")).click();

        // Type any number in the first input.
        int num1 = 15;
        driver.findElement(By.cssSelector("input[id='number1']")).sendKeys("15");

        // Type any number in the second input.
        int num2 = 125;
        driver.findElement(By.cssSelector("input[id='number2']")).sendKeys("125");

        // Click on Calculate.
        driver.findElement(By.id("calculate")).click();

        // Get the result. Print the result.
        String result = driver.findElement(By.cssSelector("span[id='answer']")).getText();
        System.out.println("result = " + result);
    }
}
