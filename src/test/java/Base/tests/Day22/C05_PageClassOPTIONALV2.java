package Base.tests.Day22;

import Base.pages.Day22.C05_AmazonHOMEPageV1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_PageClassOPTIONALV2 {

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("https://www.amazon.com.tr/");

        C05_AmazonHOMEPageV1 homePage=new C05_AmazonHOMEPageV1(driver);


        // Driver objemiz static degil ise bu driver objemizi
        // page class imizda kullanmak adina constructor kullaniriz
        homePage.searchFor("mouse");
        //mouse arama satırına yazılıp enter a basıldı


       // homePage.navigateToOrders();

        driver.close();


    }
}
