package Day10_WindowHandle_Actions;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C05_Actions_Keyboard extends BaseTest {
    @Test
    public void keyboardActions(){
        driver.get("https://demoqa.com/auto-complete");

        WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));

        actions.click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("ou are ")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional")
                .perform();


    }



}
