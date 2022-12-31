package Base.TestNG.Day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C02_ParametersExample {


    String driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) {
        //Driver konfigürasyonu yapılıyor
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver="chrome";
        } else if (browserName.equals("firefox")) {
            driver="firefox";
            WebDriverManager.firefoxdriver().setup();
        } else if (browserName.equals("opera")) {
            driver="opera";
            WebDriverManager.operadriver().setup();
        }
        System.out.println("Driver objesi oluşturuldu");
    }

    @AfterMethod
    public void tearDown() {
        driver="-";
        System.out.println("driver sonlandırıldı "+driver);
    }

    @Test
    public void test() {
        System.out.println("test execution başladı");
        System.out.println("testte kullanılan driver : "+driver);
    }
}
