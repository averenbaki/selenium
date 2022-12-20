package Day08_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BasicAuthentication {
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
    public void basicAuthentication(){

        //USER:PASSWORD@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement content = driver.findElement(By.id("content"));

        //giriş yapıp, doğru mesajı aldık mı kontrol ediyoruz
        Assert.assertTrue(content.getText().contains("Congratulations!"));



    }


}