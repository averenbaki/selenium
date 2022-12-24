package Homework.practise01;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class task07_Alert2 extends BaseTest {
    /*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
    */

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();

        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        String firstPageHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> allWindowHandle = driver.getWindowHandles();
        String secondPageHandle="";
        for (String each : allWindowHandle) {
            if (!each.equals(firstPageHandle)) {
                secondPageHandle = each;
            }
        }

        driver.switchTo().window(secondPageHandle);
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Elemental Selenium"));

    }


}
