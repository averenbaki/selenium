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

import java.time.Duration;

public class C04_RadioButtons {

    //    Go to URL:  https://www.facebook.com/
//    Click on kadın
//    Click on erkek
//    Then click on the radio buttons.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void radioButtons(){
        driver.get("https://www.facebook.com/");
        //  1-  Click on Create an Account button.
        driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]")).click();

        //  2-  Then click on the "kadın" radio buttons
        WebElement kadinRadio=driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        kadinRadio.click();
        WebElement erkekRadio=driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        erkekRadio.click();

        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertTrue(!kadinRadio.isSelected());


    }

}
