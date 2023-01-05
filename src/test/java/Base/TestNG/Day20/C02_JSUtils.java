package Base.TestNG.Day20;

import Base.Utilities.BaseCrossBrowser;
import Base.Utilities.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class C02_JSUtils extends BaseCrossBrowser {

//    Go to URL: https://www.amazon.com/
//    Scroll in to view Amazon Ignite WebElement.
//    Scroll up search area WebElement.
//    Then flashing the background color.


    @Test
    public void testJS() throws InterruptedException {
        JSUtils.driver=driver;
        driver.get("https://www.amazon.com/");

        JSUtils.scrollIntoViewJS(driver.findElement(By.partialLinkText("Amazon Ignite")));
        Thread.sleep(2000);//debug amaçlı
        JSUtils.scrollAllUpByJS();

        JSUtils.flash(driver.findElement(By.id("twotabsearchtextbox")));
        Thread.sleep(2000);//debug amaçlı


    }
}
