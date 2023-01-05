package Base.TestNG.Day20;

import Base.Utilities.BaseCrossBrowser;
import Base.Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_ExelUtils extends BaseCrossBrowser {


    @Test
    public void test() {
        String path=System.getProperty("user.dir")+"/src/test/java/Base/resources/testdata.xlsx";
        ExcelUtils exelUtils = new ExcelUtils(path,2);
        driver.get("http://crossbrowsertesting.github.io/login-form.html");

        String email=exelUtils.getCellData(1,0);
        String password=exelUtils.getCellData(1,1);

        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement welcome=driver.findElement(By.xpath("//h2[contains(., 'Welcome')]"));
        Assert.assertTrue(welcome.getText().contains(email));

        wait.until(ExpectedConditions.visibilityOf(welcome));
    }
}


//    Go to URL: http://crossbrowsertesting.github.io/login-form.html
//        Login with credentials by using ExcelUtils
//        Username: tester@crossbrowsertesting.com
//Password: test123