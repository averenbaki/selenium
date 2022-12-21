package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework7_Alerts {
    /*
    Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert  (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.

     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(215));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void alert(){
//        Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

//        Click "Alert with OK" and click 'click the button to display an alert box:’
        WebElement alertwithOk=driver.findElement(By.xpath("(//a[@class='analystic'])[1]"));
        alertwithOk.click();

        WebElement displayAlertButton=driver.findElement(By.cssSelector("#OKTab .btn.btn-danger"));
        displayAlertButton.click();

//        Accept Alert(I am an alert box!) and print alert on console.
        Alert alert=driver.switchTo().alert();
        alert.accept();
        System.out.println("alertOK.getText() = " + alert.getText());

//        Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        WebElement alertwithOkCancel=driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        alertwithOkCancel.click();

        WebElement displayConfirmButton=driver.findElement(By.cssSelector("#CancelTab .btn.btn-primary"));
        displayConfirmButton.click();

//        Cancel Alert  (Press a Button !)
        alert.dismiss();

//        Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        WebElement alertwithTextbox=driver.findElement(By.xpath("//a[@href='#Textbox']"));
        alertwithTextbox.click();

        WebElement demonstratePrompt=driver.findElement(By.className("btn.info"));
        demonstratePrompt.click();

//        And then sendKeys «BootcampCamp» (Please enter your name)
        alert.sendKeys("BootcampCamp");

//        Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.


    }

}
