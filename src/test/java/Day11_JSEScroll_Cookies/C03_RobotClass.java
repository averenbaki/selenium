package Day11_JSEScroll_Cookies;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03_RobotClass extends BaseTest {

    @Test
    public void robotTest() throws AWTException, InterruptedException {//actions yetersiz kalırsa kullanılır özellikle masaüstü işlemlerinde

        driver.get("https://demo.guru99.com/test/upload/");

        WebElement dosyaSec=driver.findElement(By.id("uploadfile_0"));
        dosyaSec.sendKeys("C:\\Users\\ACER\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);//keypress tuşa basılı tuar, ctrl ye bastık
        robot.keyPress(KeyEvent.VK_S);//s tuşana bastık

        robot.keyRelease(KeyEvent.VK_CONTROL);//keyrelease tuşu serbest bırakır
        robot.keyRelease(KeyEvent.VK_S);


        robot.keyPress(KeyEvent.VK_ENTER);//enter tuşuna bastık
        robot.keyRelease(KeyEvent.VK_ENTER);//tuşu serbest bıraktık



    }
}
