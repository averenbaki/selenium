package Day07_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {
// Go to http://www.bestbuy.com
// Verify that the page title contains "Best" Also, using Relative Locator.
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed.
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
    public void relativeLocator(){
        driver.get("http://www.bestbuy.com");

        Assert.assertTrue("Title Best kelimesini içermiyor",driver.getTitle().contains("Best"));
        //logo locate ediliyor
        By logoLocator=RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[.='Hello!']"));
        WebElement logo = driver.findElement(logoLocator);
        Assert.assertTrue(logo.isDisplayed());

        //Mexico logo locate ediliyor (Unites States sağında)
        By logoMexico=RelativeLocator.with(By.tagName("img")).toRightOf(By.xpath("//div[@lang='en']//a[@class='us-link']"));
        WebElement mxlogo=driver.findElement(logoMexico);
        Assert.assertTrue(mxlogo.isDisplayed());

    }

    //above=üzerinde
    //below=altında
    //toRightof,toLeftof=sağında,solunda


}
