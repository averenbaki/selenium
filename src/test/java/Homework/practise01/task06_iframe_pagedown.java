package Homework.practise01;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class task06_iframe_pagedown extends BaseTest {
    /*
    1- https://html.com/tags/iframe/ sayfasına gidelim.
    2- Video'yu görecek kadar aşağı inin.
    3- Videoyu izlemek için Play tuşuna basın.
    4- Videoyu çalıştırdığınızı test edin.
*/
    @Test
    public void test() {
        driver.get("https://html.com/tags/iframe/");

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframe=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iframe);

        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        actions.click(play).perform();

        Assert.assertFalse(play.isDisplayed());





    }
}
