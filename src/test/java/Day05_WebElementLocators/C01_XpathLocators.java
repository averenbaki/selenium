package Day05_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathLocators {

    WebDriver driver;

    @Before
    public void setup(){

        //Driver olusturuldu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //sayfanin yuklenmesi beklendi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //LinkedIn sitesine gidildi
        driver.get("https://www.linkedin.com/");

        // driver imiz maximize edildi
        driver.manage().window().maximize();


    }

    @After
    public void tearDown(){

        // driver imiz kapatildi
        //driver.quit();
    }
    @Test
    public void absoluteXpath(){
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("Karl absolute xpath konusunu gayet basirili tamamladi");
    }


    @Test
    public void relativeXpath(){
        // xpath locator -> //input[@name='session_key']

        WebElement email = driver.findElement(By.xpath("//input[@name='session_key']"));
        email.sendKeys("Karl relative xpath konusunu gayet basirili tamamladi");
    }

    @Test
    public void multipleAttributeXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class=\"input__input\"][@id=\"session_key\"]"));
        email.sendKeys("karl hoca multipleattribute xpath konusunu gayet başarılı tamamladı");

    }




    @Test
    public void andOrXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@class=\"input__input\" and @id=\"session_key\"]"));
        email.sendKeys("karl hoca  and xpath konusunu gayet başarılı tamamladı");

    }

    @Test
    public void orAndXpath(){

        WebElement email = driver.findElement(By.xpath("//input[@name='session_password' or @class='input__input']"));
        email.sendKeys("karl hoca  or xpath konusunu gayet başarılı tamamladı");

    }

    @Test
    public void containsXpath(){

        WebElement email = driver.findElement(By.xpath("//input[contains(@id,'key')]"));
        email.sendKeys("karl hoca  contains xpath konusunu gayet başarılı tamamladı");

    }
    @Test
    public void startsWithXpath(){

        WebElement email = driver.findElement(By.xpath("//input[starts-with(@id,'session')]"));
        email.sendKeys("karl hoca  starts-with xpath konusunu gayet başarılı tamamladı");

    }
    @Test
    public void textXpath(){

        WebElement email = driver.findElement(By.xpath("//button[contains(text(),'Oturum açın')]"));
        email.sendKeys("karl hoca  contains, text() xpath konusunu gayet başarılı tamamladı");

    }


}
