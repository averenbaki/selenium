package Day12_Files_ApachePOI;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends BaseTest {
    @Test
    public void fileDownload() throws InterruptedException {

//        Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
//        Login page valid credentials.
        WebElement username=driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin123"+Keys.ENTER);

//        Download sample CSV file.
        WebElement PIM= driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        PIM.click();
        WebElement configaritionTab=driver.findElement(By.xpath("//span[text()='Configuration ']"));
        configaritionTab.click();

        WebElement dataimport=driver.findElement(By.linkText("Data Import"));
        dataimport.click();

        WebElement downloadlink=driver.findElement(By.className("download-link"));
        downloadlink.click();

        Thread.sleep(5000);

        String downloadPath="C:/Users/ACER/Downloads/importData.csv";
        Assert.assertTrue("indirilen dosya bulunamadı",Files.exists(Paths.get(downloadPath)));


//        Verify if the file downloaded successfully.



    }
}
