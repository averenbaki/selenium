package Base.pages.Day22;

import Base.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class C04_SauceDemoLOGINPage {


    public C04_SauceDemoLOGINPage() {
        //initelements methodu page class ı initialize etmek adına kullanılır
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll({
            @FindBy(id = "user-name"),
            @FindBy(id = "password"),
            @FindBy(xpath = "//*[@id='login-button']")
    })
    public List<WebElement> inputElements;

}
