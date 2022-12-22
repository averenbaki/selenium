package Day10_WindowHandle_Actions;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class C04_Actions_HoverOver extends BaseTest {

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com.tr/");

        //hesap ve listeler bölümünü locate ettik
        WebElement accountAndList=driver.findElement(By.id("nav-link-accountList"));

        //hesap ve siparişler üzerine gelip açılmasını bekledik(dropdown)
        actions.click(driver.findElement(By.name("accept")))//çerezleri kabul ettim
                .moveToElement(accountAndList)
                .click(driver.findElement(By.id("nav_prefetch_yourorders")))//siparilerime tıkladım
                .perform();

        Assert.assertEquals("Amazon Giriş Yap",driver.getTitle());




    }






}
