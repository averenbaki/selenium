package Day13_ScreenShoots_WebTables;

import Utilities.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshoots extends BaseTest {
//    Go to URL: https://opensource-demo.orangehrmlive.com/
//    Saving the image to  the path.
//    Getting screenshot of Orange HRM Logo.
//    Getting screenshot of  Orange HRM Page Section.


    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

        //Screenshot umuzu File class indan bir objeye aliyoruz
        File kaynak = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Aldigimiz screenshot istedigimiz path e kaydediyoruz
        FileHandler.copy(kaynak, new File("test-output/Screenshots/n11PageScreenshot.png"));


    }


    @Test
    public void getElementScreenshoot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Screenshot u alinacak elementimizi locate ettik
        WebElement logo=driver.findElement(By.className("orangehrm-login-branding"));

        // Element uzerinden screenshot umuzu aldik
        File logoScreenShoot=logo.getScreenshotAs(OutputType.FILE);

        // Ozel isimler olabilmesi adina date imizi dosya isimlerimizin yanina ekledik
        String date=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String path="test-output/Screenshots/logoScreenShoot_"+date+".png";
        System.out.println("path = " + path);

        // Dosyamizi kaydettik
        FileUtils.copyFile(logoScreenShoot,new File(path));


    }
}
