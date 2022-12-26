package Day11_JSEScroll_Cookies_Files;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_ScrollWithJSExecutor extends BaseTest {

   // go to url : https://api.jquery.com/dblclick/
   // double click on the blue square at the bottom of the page and then write the changed color.


    @Test
    public void doubleClick() {
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);

        WebElement blueBox=driver.findElement(By.tagName("div"));//xpath("//span[text()='Double click the block']")
                                                                //By.cssSelector("body>div")

        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();",blueBox);//bluebox görene kadar aşağı iniyor sayfa

        System.out.println("colour before = " + blueBox.getCssValue("background-color"));
        actions.doubleClick(blueBox).perform();
        System.out.println("colour after = " + blueBox.getCssValue("background-color"));



    }
}
