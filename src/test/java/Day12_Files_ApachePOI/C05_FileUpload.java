package Day12_Files_ApachePOI;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_FileUpload extends BaseTest {
    @Test
    public void fileUpload() {

//        Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
//        Find the path of the file that you want to upload.
        WebElement dosyasec=driver.findElement(By.id("file-upload"));
        dosyasec.sendKeys("C:/Users/ACER/Desktop/fileExist.png");
//                Click on Upload button.
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.click();
//                Verify the upload message.
        WebElement uploadedmessage=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedmessage.isDisplayed());
        Assert.assertEquals("File Uploaded!",uploadedmessage.getText());




    }
}
