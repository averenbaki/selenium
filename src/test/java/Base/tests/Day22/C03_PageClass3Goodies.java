package Base.tests.Day22;

import Base.pages.Day22.C03_HtmlGoodiesHOMEPage;
import Base.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C03_PageClass3Goodies {

    @Test
    public void test() {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        C03_HtmlGoodiesHOMEPage homePage=new C03_HtmlGoodiesHOMEPage();
        Actions actions= new Actions(Driver.getDriver());

        actions
                .dragAndDrop(homePage.copenhag,homePage.denmark)
                .dragAndDrop(homePage.seoul,homePage.sKorea)
                .dragAndDrop(homePage.washington,homePage.us)
                .dragAndDrop(homePage.rome,homePage.italy)
                .dragAndDrop(homePage.madrid,homePage.spain)
                .dragAndDrop(homePage.oslo,homePage.norway)
                .dragAndDrop(homePage.stockholm,homePage.sweden)
                .perform();

        Driver.quitDriver();


    }


}
