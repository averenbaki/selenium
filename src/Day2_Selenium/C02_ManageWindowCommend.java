package Day2_Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManageWindowCommend {
    // Go to the Amazon URL : https://www.amazon.com/
// Print the position and size of the page.
// Adjust the position and size of the page as desired.
// Test that the page is in the position and size you want.
// Close the page.
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //print the position and size
        System.out.println("browse ın pozisyonu(position) : " + driver.manage().window().getPosition());
        System.out.println("browse ın boyutu(size) : " +driver.manage().window().getSize());
        Thread.sleep(3000);

        //browser position(190,70) olarak set ettik
        driver.manage().window().setPosition(new Point(190,70));
        Thread.sleep(3000);

        //browser boyutunu size(600,700) olarak set ettik
        driver.manage().window().setSize(new Dimension(600,700));
        Thread.sleep(3000);

        //browser boyutunu doğruluyoruz
        int height=driver.manage().window().getSize().getHeight();
        int width=driver.manage().window().getSize().getWidth();

        System.out.println("height = " + height);
        System.out.println("width = " + width);

        System.out.println("browser boyutu test ediliyor...");
        if (width==600 && height==700){
            System.out.println("boyut testi PASSED");
        }else System.out.println("boyut testi FAILED");

        //browser in pozisyonu doğruluyoruz
        int X=driver.manage().window().getPosition().getX();
        int Y=driver.manage().window().getPosition().getY();

        System.out.println("browser pozisyonu test ediliyor...");
        if (X==190&&Y==70){
            System.out.println("position test PASSED");
        }else System.out.println("position test FAILED");

        driver.quit();




    }
}
