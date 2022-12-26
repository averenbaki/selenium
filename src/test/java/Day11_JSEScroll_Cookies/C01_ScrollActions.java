package Day11_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.Keys;

public class C01_ScrollActions extends BaseTest {


    @Test
    public void scrollPageUpDown() throws InterruptedException {//klavyedeki page up-down tuşları
        driver.get("https://amazon.com/");
        Thread.sleep(2000);//her halükarda bekler implicitly ise webelementi bulunca beklemeyi bırakır
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();


    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {//klavyedeki ok tuşları

        driver.get("https://amazon.com/");
        Thread.sleep(2000);

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();




    }



}
