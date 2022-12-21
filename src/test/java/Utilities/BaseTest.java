package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {//abstract

    /*Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
      TestBase Class'ı sadece extends ile inherit ederek kullanacağız.
      Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz.*/
    protected WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
      //  driver.quit();
    }


}
