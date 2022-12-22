package Day10_WindowHandle_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {

    //WindowType.TAB -->yeni sekmede
    //WindowTyoe.WINDOW --> yeni sayfada

    // https://testproject.io/
    // https://blog.testproject.io/
    @Test
    public void newWindow() {


        driver.get("https://testproject.io/");
        WebDriver newWindow= driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://blog.testproject.io/");
        //driver.get("https://testproject.io/");


    }

    @Test
    public void newTab(){

        driver.get("https://blog.testproject.io/");
        WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://amazon.com");
    }

    @Test
    public void handleWindows(){

        driver.get("https://amazon.com");

        //getwindowhandle ve getwindowhandles
        String homePageHandle=driver.getWindowHandle();//anasayfa handle değeri saklandı

        driver.switchTo().newWindow(WindowType.TAB);//yeni sekme açıldı
        driver.get("https://amazon.com.tr");//yeni sekmede amazon tr açıldı
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni pencere açıldı
        driver.get("https://www.google.com/");//yeni pencerede google açıldı

        Set<String> handles= driver.getWindowHandles();
        Iterator<String> i=handles.iterator();

        while (i.hasNext()) {

            String currentTab= i.next();
            driver.switchTo().window(currentTab);

            System.out.println("driver.getTitle() = " + driver.getTitle());

            //**********1.yol********
           if (!driver.getWindowHandle().equals(homePageHandle)){driver.close();}

            //**********2.yol********
            //if (!driver.getTitle().contains("Spend")){driver.close();}

        }

    }


}
