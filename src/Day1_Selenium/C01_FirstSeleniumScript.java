package Day1_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FirstSeleniumScript {
    /*
    2. Create main method.
3. System.setProperty("","");System.setProperty("webdriver.chrome.driver","/Users/Garry/Documents/seleniumdependencies/drivers/chromedriver");
 (Windows) System.setProperty("webdriver.chrome.driver","C:\\Users\\Garry\\Documents\\seleniumdependencies\\drivers\\chromedriver.exe");
4. Chrome driver oluşturun.
WebDriver driver = new ChromeDriver();
5. ''https://www.google.com'’ adresinden google ana sayfasını açın.
     */

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");




    }

}
