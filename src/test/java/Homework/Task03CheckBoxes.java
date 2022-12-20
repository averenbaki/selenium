package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task03CheckBoxes {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkBoxes(){
//    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.

        //  01-->  Go to URL: https://demoqa.com/

        driver.get("https://demoqa.com/");

        //  02--> Click on Elements.
        WebElement ClickonElements = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        ClickonElements.click();

      //  03-->Click on Checkbox.
      WebElement ClickonCheckbox = driver.findElement(By.xpath("//span[@class='text'][.='Check Box']"));
      ClickonCheckbox.click();

      //  04--> Verify if Home checkbox is selected.
      WebElement ClickonHomeButton = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));


      if (!ClickonHomeButton.isSelected()) {
          ClickonHomeButton.click();
      }

      //  05--> Verify that "You have selected" is visible.

      WebElement verifyisselect = driver.findElement(By.id("result"));
      Assert.assertTrue(verifyisselect.isDisplayed());


    }


}
