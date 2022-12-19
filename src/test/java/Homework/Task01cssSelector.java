package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01cssSelector {
    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

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
    public void kayıtYapılamamaTest(){
        driver.get("https://id.heroku.com/login");
        //Bir mail adresi giriniz.
        driver.findElement(By.id("email")).sendKeys("mgkara@gmail.com");

        //Bir password giriniz.
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

        //Login butonuna tıklayınız.
        WebElement loginButon=driver.findElement(By.cssSelector("button[name='commit']"));
        loginButon.click();

        //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız. Görünürse "Kayıt yapıldı" yazdırın
        String alertMessage=driver.findElement(By.xpath("//div[@role='alert']")).getText();
        if(alertMessage.equals("There was a problem with your login.")){
            System.out.println("Kayıt yapılamadı");
        } else {
            System.out.println("Kayıt yapıldı");}

    }
}
