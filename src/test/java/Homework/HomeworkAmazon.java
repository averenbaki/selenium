package Homework;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomeworkAmazon extends BaseTest {
    @Test
    public void Amazon() {
        //    o https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");
        //o Ana sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com.tr/"));
        //o Çerez tercihlerinden Çerezleri kabul et seçilir.
       driver.findElement(By.id("sp-cc-accept")).click();
        //o Siteye login olunur.
        WebElement login=driver.findElement(By.id("nav-link-accountList"));
        login.click();
       WebElement email= driver.findElement(By.id("ap_email"));
        email.click();
        email.sendKeys("erenbaki34@hotmail.com");
        email.sendKeys(Keys.ENTER);
        WebElement password=driver.findElement(By.id("ap_password"));
        password.sendKeys("erenB.93");
        password.sendKeys(Keys.ENTER);
        //o Login işlemi kontrol edilir.
        WebElement hesapveListe=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(hesapveListe).perform();
        Assert.assertTrue(driver.findElement(By.id("nav-item-signout")).isDisplayed());

        //o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement tümkategori=driver.findElement(By.id("searchDropdownBox"));
        tümkategori.click();
        Select select=new Select(tümkategori);
        select.selectByValue("search-alias=computers");

        //o Bilgisayar kategorisi seçildiği kontrol edilir.

        WebElement selectkontrol=driver.findElement(By.id("nav-search-label-id"));
        Assert.assertEquals("Bilgisayarlar",selectkontrol.getText());
        //o Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchbar=driver.findElement(By.id("twotabsearchtextbox"));
        searchbar.click();
        searchbar.sendKeys("MSI");
        searchbar.sendKeys(Keys.ENTER);
        //o Arama yapıldığı kontrol edilir.
        WebElement arananUrun=driver.findElement(By.xpath("//span[text()='MSI']"));
        Assert.assertTrue(arananUrun.getText().equals("MSI"));
        //o Arama sonuçları sayfasından 2. sayfa açılır.
         WebElement ikisayfa=driver.findElement(By.xpath("(//a[@class='s-pagination-item s-pagination-button'])[1]"));
        ikisayfa.click();

        //o 2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.getCurrentUrl().endsWith("2"));

        //o Sayfadaki 2. ürün listeye eklenir.
        WebElement ürün2=driver.findElement(By.xpath("//div[@data-index='2']"));
        ürün2.click();
        WebElement listeyeekle=driver.findElement(By.id("add-to-wishlist-button-submit"));
        listeyeekle.click();
        WebElement listeolustur=driver.findElement(By.id("wl-redesigned-create-list"));
        listeolustur.click();
        //o 2. Ürünün favorilere eklendiği kontrol edilir.
        WebElement listedeürün2id=driver.findElement(By.id("wl-huc-title-holder"));
        WebElement ürün2id=driver.findElement(By.id("productTitle"));
        Assert.assertTrue(ürün2id.getText().equalsIgnoreCase(listedeürün2id.getText()));
        //o Hesabım > Favori Listem sayfasına gidilir.
     WebElement favorisayfam=driver.findElement(By.xpath("(//a[@class='a-button-text'])[2]"));
        favorisayfam.click();

        //o “Favori Listem” sayfası açıldığı kontrol edilir.
        WebElement alışverisliste=driver.findElement(By.id("profile-list-name"));
        Assert.assertTrue(alışverisliste.isDisplayed());
        //o Eklenen ürün favorilerden silinir.
       WebElement delete=driver.findElement(By.name("submit.deleteItem"));
       delete.click();
        //o Silme işleminin gerçekleştiği kontrol edilir.
     WebElement silmekontrol=driver.findElement(By.xpath("//div[contains(text(),'Silindi')]"));
     Assert.assertTrue(silmekontrol.isDisplayed());
        //o Üye çıkış işlemi yapılır.
     WebElement hesapveliste=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
     actions.moveToElement(hesapveliste).perform();
     WebElement signout=driver.findElement(By.id("nav-item-signout"));
     signout.click();

        //o Çıkış işleminin yapıldığı kontrol edilir.
      WebElement emailcıkıs=driver.findElement(By.id("ap_email"));
      Assert.assertTrue(emailcıkıs.isDisplayed());

    }


}
