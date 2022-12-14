package Day2_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_PageSourceTest {
    public static void main(String[] args) {
        // Go to the Amazon URL: https://www.amazon.com/
        // Verify that it writes "Performance Metrics" and "MEOW" from the Source code.


        System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");


        System.out.println("pageSource test starting...");
        String pageSource=driver.getPageSource();
        if (pageSource.contains("Performance Metrics")&&pageSource.contains("MEOW")) {
            System.out.println("pageSource test PASSED");
        }else System.out.println("pageSource test FAILED");


        driver.quit();



    }
}
