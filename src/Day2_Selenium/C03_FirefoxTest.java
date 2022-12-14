package Day2_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class C03_FirefoxTest {
    //        Invoke FireFox Driver
//        Go to https://www.youtube.com/
//        Verify the page title contains the word video.
//        Close the driver.
    public static void main(String[] args) {

    System.setProperty("webdriver.gecko.driver","Dependencies/drivers/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.get("https://www.youtube.com/");

        //Verify the page title contains the word video.
        System.out.println("tittle testi yapılıyor...");
        String pageTitle=driver.getTitle();
        if (pageTitle.contains("video")){
            System.out.println("title test PASSED");
        }else System.out.println("title test FAILED");

    driver.close();



    }
}
