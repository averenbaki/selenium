package Base.TestNG.Day17;

import Base.Utilities.BaseCrossBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C06_CrossBrowserTestExample extends BaseCrossBrowser {

    //go to amazon.com
    //search for "headset", "mouse", "keyboard" in order with dataProvider
    //assert that first item contains searched keyword in the item description
    //go to product page
    //add first item to cart
    //click go to cart on cart section
    //assert shopping card heading
    //check this a gift
    //assert that checkbox is checked
    //click on proceed to checkout
    //assert that login page is opened

    //Do it for chrome and firefox with crossbrowser testing


    @Test(dataProvider = "data")
    public void amazonTest(String key) {
        // Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Search for key word
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(key + Keys.ENTER);

        // Assert that first item contains searched keyword in the item description
        WebElement firstProduct = driver.findElement(By.xpath("//div[@data-component-type='s-search-result']"));
        String firstProductDescription = firstProduct.getText().toLowerCase();
        Assert.assertTrue(firstProductDescription.contains(key));

        // Go to product page
        firstProduct.findElement(By.tagName("img")).click();

        // Add first item to cart
        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
        addToCartBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("attach-sidesheet-checkout-button"))));

        // Click Go to cart on cart section
        WebElement goToCartLink = driver.findElement(By.id("attach-view-cart-button-form"));
        goToCartLink.submit();

        // Assert shopping cart heading
        List<WebElement> shoppingCartHeaderList = driver.findElements(By.tagName("h1"));
        Assert.assertTrue(shoppingCartHeaderList.size() > 0);

        WebElement shoppingCartHeader = shoppingCartHeaderList.get(0);
        Assert.assertTrue(shoppingCartHeader.isDisplayed());
        Assert.assertEquals(shoppingCartHeader.getText(), "Shopping Cart");

        // Check this is a gift
        WebElement thisIsAGiftCb = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        thisIsAGiftCb.click();

        // Assert that checkbox is checked
        Assert.assertTrue(thisIsAGiftCb.isSelected());

        // Click on proceed to checkout
        WebElement proceedToCheckoutBtn = driver.findElement(By.name("proceedToRetailCheckout"));
        proceedToCheckoutBtn.click();

        // Assert that login page is opened
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://www.amazon.com/ap/signin"));



    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                {"headset"},
                {"mouse"},
                {"keyboard"}
        };
    }


}
