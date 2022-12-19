package Day07_Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C02_ChromeOptions {

    @Test
    public void chromeOptions(){
        WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");//başlıksız
        // options.addArguments("incognito");//gizli sekmede açma
        options.addArguments("start-maximized");//max ekran ile pencerenin açılması
        WebDriver driver = new ChromeDriver(options);
    }
}
