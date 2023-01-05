package Base.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver Driver;

    private Driver() {

    }

    public static WebDriver getDriver() {
        if (Driver == null) {
            WebDriverManager.chromedriver().setup();
            Driver=new ChromeDriver();
            Driver.manage().window().maximize();
            Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return Driver;
    }


    public static void quitDriver(){
        if (Driver != null){
            Driver.quit();
            Driver=null;
        }
    }


}
