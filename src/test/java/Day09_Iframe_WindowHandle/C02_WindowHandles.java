package Day09_Iframe_WindowHandle;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C02_WindowHandles extends BaseTest {
    //    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page.
//    Set the driver back to the main page.

    @Test
    public void windowHandles(){
        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
        //target='_blank' : yeni sekmede aç

        String homepageID= driver.getWindowHandle();//ana sayfa değerini koruduk daha sonra kullanmak için

       //sayfada link oluşturmak için linkleri locate ettik, yeni sekmeler oluşturacak linklere tıkladık
        List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));
        links.get(0).click();
        links.get(1).click();

        //birden fazla pencere olduğundan, pencereler arası geçiş için pencere değerlerini oluşturduk
        Set<String> windows=driver.getWindowHandles();//set olma sebebi unıq değerlere sahip olunması

        //pencereler arası geçiş için iteratör tanımladık
        Iterator<String> iterator= windows.iterator();

        //korunan home page değerini kullanarak diğer pencereleri kapadık
        while (iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            if (driver.getWindowHandle().equals(homepageID)){
                continue;//atlanarak home page kapanması engellendi
            }
            driver.close();

        }


    }

}
