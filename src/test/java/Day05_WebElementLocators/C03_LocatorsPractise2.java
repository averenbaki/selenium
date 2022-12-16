package Day05_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LocatorsPractise2 {
    //    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.

   static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Before
    public void beforeClass(){

        driver.get("https://www.google.com.tr/");
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();

    }

    @Test
    public void test01(){
        WebElement search= driver.findElement(By.name("q"));
        search.sendKeys("Green Mile"+ Keys.ENTER);

        WebElement results= driver.findElement(By.id("result-stats"));

        System.out.println(results.getText());
    }




}
