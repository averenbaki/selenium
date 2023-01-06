package Base.tests.Day22;

import Base.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class C01_PageClass {
//    Navigate to https://www.saucedemo.com/
//    Enter the user name as standard_user
//    Enter the password as secret_sauce
//    Click on login button.
//            - Choose price low to high
//            - Verify item prices are sorted from low to high with hard Assert.

    @Test
    public void test() {
        Driver.getDriver().get("https://www.saucedemo.com/");
        WebElement username=Driver.getDriver().findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password=Driver.getDriver().findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton=Driver.getDriver().findElement(By.id("login-button"));
        loginButton.click();

        Select dropdown=new Select(Driver.getDriver().findElement(By.tagName("select")));
        dropdown.selectByValue("lohi");

        List<WebElement> itemPrices=Driver.getDriver().findElements(By.className("inventory_item_price"));
        itemPrices.forEach(t-> System.out.println(t.getText()));

        List<Double> urunfiyatlari=itemPrices.stream()
                        .map(t -> t.getText().substring(1))
                                .map(t -> Double.parseDouble(t))
                                        .collect(Collectors.toList());
        System.out.println(urunfiyatlari);


        for (int i = 0; i <urunfiyatlari.size()-1 ; i++) {
            Assert.assertTrue(urunfiyatlari.get(i)<=urunfiyatlari.get(i+1));
        }


        Driver.quitDriver();

    }
}
