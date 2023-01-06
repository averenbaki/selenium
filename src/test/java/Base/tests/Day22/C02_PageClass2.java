package Base.tests.Day22;

import Base.pages.Day22.C02_SauceDemoHOMEpage;
import Base.pages.Day22.C01_SauceDemoLOGiNPage;
import Base.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_PageClass2 {
    @Test
    public void pageclasstest() {

        Driver.getDriver().get("https://www.saucedemo.com/");

        //login sayfasında yapılan aksiyonlar
        C01_SauceDemoLOGiNPage loginPage=new C01_SauceDemoLOGiNPage();

        loginPage.txtusername.sendKeys("standard_user");
        loginPage.txtpassword.sendKeys("secret_sauce");
        loginPage.txtloginButton.click();

        C02_SauceDemoHOMEpage homepage=new C02_SauceDemoHOMEpage();
        Select select = new Select(homepage.filterDropdown);
        select.selectByValue("lohi");

        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("low to high"));

        Driver.quitDriver();

    }
}
