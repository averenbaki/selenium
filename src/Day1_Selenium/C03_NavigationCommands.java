package Day1_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigationCommands {
    public static void main(String[] args) {
        /*
        Invoke Chrome Browser
Navigate to URL: https://clarusway.com/
Navigate to URL: http://amazon.com/
Come back to the Clarusway using the back command.
Again go back to the amazon website using forward command
Refresh the Browser using refresh command.
Close the Browser.

         */

        System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://clarusway.com/");
        driver.navigate().to("http://amazon.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        driver.quit();


    }

}
