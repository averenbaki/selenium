package Base.TestNG.Day17;

import Base.Utilities.BaseCrossBrowser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_CrossBrowser extends BaseCrossBrowser {
    //browser bilgisi testng.xml dosyasindan alinacagindan dolayi kod asamasinda
    // herhangi bir degisiklik goruntulenmeyecektir


    @Test
    public void crossBrowserTest() throws InterruptedException {
        driver.get("https://www.google.com/");

        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Google");
    }

}
