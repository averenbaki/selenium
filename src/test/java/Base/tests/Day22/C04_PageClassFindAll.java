package Base.tests.Day22;

import Base.pages.Day22.C04_SauceDemoLOGINPage;
import Base.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_PageClassFindAll {

    @Test
    public void test(){

        Driver.getDriver().get("https://www.saucedemo.com/");

        C04_SauceDemoLOGINPage lp = new C04_SauceDemoLOGINPage();

        Assert.assertEquals(3, lp.inputElements.size());//beklenen elemsn sayısı(actual):3, sonuç(expected):3

    }


}
