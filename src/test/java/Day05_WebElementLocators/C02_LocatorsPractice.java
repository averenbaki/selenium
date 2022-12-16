package Day05_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class C02_LocatorsPractice {


    WebDriver driver;
    @Before
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void xpathPractise(){
        //1Adım-linkedIn e git
        driver.get("https://tr.linkedin.com/");

        //2.adım-email alanına @ sembolü olmayan bir mail adresi gir ve enter la
        WebElement email = driver.findElement(By.xpath("//input[@id='session_key']"));
        email.sendKeys("karlclarusway.com"+ Keys.ENTER);

        //3.adım-hata mesajının görüntülendiğini doğrula
        WebElement alertMessage = driver.findElement(By.xpath("//p[@class='alert-content']"));
        //doğrulama kelimesi gördüğüüzde Assert methodu aklımıza gelmeli
        Assert.assertTrue(alertMessage.isDisplayed());
        //Assert.assertEquals(true,alertMessage.isDisplayed());
        //Assert.assertFalse(!alertMessage.isDisplayed());
    }




}
