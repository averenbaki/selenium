package Base.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseCrossBrowser {
    protected WebDriver driver;
    protected Actions actions;
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        switch (browser){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
