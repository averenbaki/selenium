package Base.TestNG.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_TestNGParametersSeleniumExample {

//    Go to URL: https://www.amazon.com
//    Search words: Java, Selenium
//    Assert get text result est that the result text contains the searched Word.
//    Run tests from XML file.
WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserValue) {
        //Driver konfigürasyonu yapılıyor
       switch (browserValue){

           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver=new ChromeDriver();
               break;

               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver=new FirefoxDriver();
                   break;

       }
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    @Parameters("aranacakKelime")
    public void parameterstest(String kelime) throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(kelime + Keys.ENTER);
        Thread.sleep(5000);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultText.getText().contains(kelime));
    }


}
