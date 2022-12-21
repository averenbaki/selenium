package Day08_Dropdown_SeleniumWaits;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_SeleniumWaits extends BaseTest {

    //Explicit wait
    @Test
    public void webDriverWait() {

        driver.get("https://demoqa.com/elements");

        //Adım 1--> Webdrivverwait objemiz oluşturuldu
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement category=driver.findElement(By.xpath("(//div[@class='icon'])[2]"));

        //wlwmwnttobe(Webelement)
        wait.until(ExpectedConditions.elementToBeClickable(category)).click();

        //elementToBe(By)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Practice Form']"))).click();





    }

}
