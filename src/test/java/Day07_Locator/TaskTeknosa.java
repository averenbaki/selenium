package Day07_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TaskTeknosa {
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
    public void teknosaTest(){
//https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.

        driver.get("https://www.teknosa.com/");

        WebElement search= driver.findElement(By.id("search-input"));

        // 2-Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
        search.sendKeys("oppo"+ Keys.ENTER);

        // 3-Sonuç sayısını yazdırınız.
        WebElement sonucSayisi=driver.findElement(By.className("plp-info"));
        System.out.println("sonucSayisi = " + sonucSayisi.getText());

        //4-Çıkan ilk ürüne tıklayınız.
        WebElement ilkUrun=driver.findElement(By.className("prd-link"));
        ilkUrun.click();

        //5-Sepete ekleyiniz.
        WebElement sepeteEkle=driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]"));
        sepeteEkle.click();

        //6-Sepetime gite tıklayınız.
        WebElement sepeteGitButton=driver.findElement(By.xpath("a[@class='btn btn-secondary']"));
        sepeteGitButton.click();

        //7-Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
        WebElement siparisOzeti=driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
        System.out.println("siparisOzeti = " + siparisOzeti.getText());

        //8-Alışverişi tamamlayınız.
        WebElement alısverisTamamla=driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        alısverisTamamla.click();

        //9-Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
        WebElement hosgeldiniz=driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println("hosgeldiniz = " + hosgeldiniz.getText());

    }





}
