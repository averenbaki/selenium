package Day06_WebElementLocators;

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

public class C01_Locatorspractise {
    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //alerts linki locate edildi ve tıklandı
        WebElement alertsLink= driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();

        //Current URL yazdırıldı
        String alertsURL=driver.getCurrentUrl();
        System.out.println(alertsURL);

        //bir sayfa geri gelindi
        driver.navigate().back();

        //current URL yazdırıldı
        String homeURL= driver.getCurrentUrl();
        System.out.println(homeURL);

        //basic ajax clik edildi
        WebElement basicajax= driver.findElement(By.id("basicajax"));
        basicajax.click();

        //current URL yazdırıldı
        String basicURL=driver.getCurrentUrl();
        System.out.println(basicURL);

        //Enter value  20 and Enter- 20 yazılıp enter a basıldı
        WebElement enterValue=driver.findElement(By.id("lteq30"));
        enterValue.sendKeys("20"+ Keys.ENTER);

        //And then verify Submitted Values is displayed open page
        //submitted values yazısının görüntülediği doğrulandı
        WebElement submittedValues= driver.findElement(By.xpath("//p[text()='Submitted Values']"));

        //doğrula dediği için assert yapacağız
        Assert.assertTrue(submittedValues.isDisplayed());



    }



}
