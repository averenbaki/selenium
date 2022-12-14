package Day2_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_FacebookURLTest {
    public static void main(String[] args) {
// Invoke Chrome Driver
// Navigate to Facebook homepage URL: https://www.facebook.com/
// Verify expected equals actual URL.
// Verify expected title contains Facebook Word.

        System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        System.out.println("URL Test yapılıyor...");
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("URL Test PASSED");
        }else System.out.println("URL Test FAILED");

        System.out.println("title test yapılıyor...");
        String actualTitle= driver.getTitle();
        if (actualTitle.contains("Facebook")){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED");

        driver.quit();

    }
}
