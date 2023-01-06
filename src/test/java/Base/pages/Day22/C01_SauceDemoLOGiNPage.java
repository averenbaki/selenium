package Base.pages.Day22;

import Base.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C01_SauceDemoLOGiNPage {

    public C01_SauceDemoLOGiNPage() {
        //initelements methodu page class ı initialize etmek adına kullanılır
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //@FindBy anatasyonu elementleri locate ederken kullandığımız ve initelements methodu ile elementlerin
    // bulunmasını sağlayan anatasyondur
    @FindBy(id = "user-name")
    public WebElement txtusername;//Driver.getDriver().findElement(By.id("user-name"));

    @FindBy(id = "password")
    public WebElement txtpassword;//Driver.getDriver().findElement(By.id("password"));

    @FindBy(xpath = "//*[@id='login-button']")//farklı gösterim xpath ile
    public WebElement txtloginButton;//Driver.getDriver().findElement(By.id("login-button"));


}
