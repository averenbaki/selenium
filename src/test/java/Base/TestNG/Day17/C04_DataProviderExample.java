package Base.TestNG.Day17;

import Base.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProviderExample extends TestBase {

//    Open the site: https://www.amazon.com/
//    Do it with DataProvider for
//    Java
//    JavaScript
//    Phyton


    @Test(dataProvider = "keyData")
    public void amazonSearchTest(String key) {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(key+Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(resultText.getText().contains(key));//arama sonucunun aradığımız kelimeyi içerip içermediğini kontrol ettik


    }

    @DataProvider
    public Object[][] keyData(){
        return new Object[][]{
                {"java"},
                {"javascript"},
                {"python"}
        };
    }


}
