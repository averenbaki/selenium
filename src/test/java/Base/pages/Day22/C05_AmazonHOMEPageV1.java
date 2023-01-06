package Base.pages.Day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_AmazonHOMEPageV1 {

    private WebDriver ldriver;
    public C05_AmazonHOMEPageV1(WebDriver driver) {
    this.ldriver=driver;
        PageFactory.initElements(ldriver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement txtSearch;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountAndlist;

    @FindBy(id = "nav_prefetch_yourorders")
    private WebElement yourOrders;

    public void searchFor(String search){
        txtSearch.sendKeys(search+ Keys.ENTER);
    }

    public void navigateToOrders(){
        Actions actions=new Actions(ldriver);
        actions.moveToElement(accountAndlist).perform();

        WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(yourOrders)).click();
    }




}
