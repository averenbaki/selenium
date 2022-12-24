package Homework.practise01;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class task08_dragDrop extends BaseTest {
    @Test
    public void dragDrop() {
/*
    1- https://demoqa.com/droppable adresine gidelim.
    2- "Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
    3- "Drop here" yazısı yerine "Dropped!" olduğunu test edin.
*/

        driver.get("https://demoqa.com/droppable");

        WebElement drgme=driver.findElement(By.id("draggable"));
        WebElement dropHere=driver.findElement(By.id("droppable"));

        actions.dragAndDrop(drgme, dropHere).perform();

        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());


    }
}
