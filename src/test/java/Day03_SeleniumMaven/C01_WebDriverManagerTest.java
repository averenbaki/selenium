package Day03_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    // Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.
    public static void main(String[] args) {

        //webdriver manager classını kullanarak chromedriver binary leri indirildi
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //title imizi aldık
        String title = driver.getTitle();

        //title doğrulandı
        if (title.equals("Google")){
            System.out.println("title test PASSED");
        }else System.out.println("title test FAILED");

        driver.quit();




    }

}
