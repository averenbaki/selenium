package Homework;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Task04Amazon extends BaseTest {
    /*
            1. https://www.amazon.com/ adresine gidin.
            2.  Assertion kullanarak Amazon web sitesine gittiğinizi doğrulayın.
            3. Kategori DropDown'dan Books kategorisini seçin ve arama kutusuna "Selenium" yazdırıp aratın.
            4. Çıkan kitaplardan 2. ve 5. kitabın isminde "Selenium" kelimesinin geçtiğini doğrulayın.
            5. Çıkan sonuç sayısının 500'den büyük olduğunu doğrulayın.*/

@Test
    public void amazon(){
    driver.get("https://www.amazon.com/");
    Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/"));//kontrol yapıldı nerdeyiz
    driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();//books seçildi
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium"+ Keys.ENTER);//arama çubuğuna selenium yazıp arattık
    WebElement book2=driver.findElement(By.xpath("//div[@data-index='2']"));//2.kitap webElementi
    WebElement book5=driver.findElement(By.xpath("//div[@data-index='5']"));//5.kitap WebElementi
    Assert.assertTrue(book2.getText().contains("Selenium"));//2.kitapta selenium varlığı kontrol edildi
    Assert.assertTrue(book5.getText().contains("Selenium"));//5.kitapta selenium varlığı kontrol edildi

    WebElement results=driver.findElement(By.xpath("//span[contains(text(),'results')]"));
    String sonuclar=results.getText().split("over").toString();
    int resultAmount=Integer.parseInt(sonuclar.substring(1).replaceAll("\\D", ""));
    Assert.assertTrue(resultAmount>500);




}

}
