package Day09_Iframe_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_iframeExample {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void iframeExample(){
        //        Go to URL: https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains "Editor"
//        Locate the text box
//        Delete the text in the text box
//        Type "Hi everyone"
//        Verify the text Elemental Selenium text is displayed on the page.

        driver.get("https://the-internet.herokuapp.com/iframe");

        //2-    Verify the Bolded text contains "Editor"
        WebElement boldedtext=driver.findElement(By.tagName("h3"));
        String text= boldedtext.getText();
        Assert.assertTrue(text.contains("Editor"));

        //3-        Locate the text box
        driver.switchTo().frame(0);
        WebElement textbox=driver.findElement(By.id("tinymce"));

        //4-       Delete the text in the text box
        textbox.clear();

        //5-        Type "Hi everyone"
        textbox.sendKeys("Hi everyone");

        //6-        Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();//sayfaya geri switch işlemi yapılır çünkü geri dönmezsek sadece frame içinde arama yapar

        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());

    }

    @Test
    public void practise(){
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
// Web sitesini maximize yapınız.
// İkinci emojiye tıklayınız.
// Tüm ikinci emoji öğelerine tıklayınız.
// Parent iframe geri dönünüz.
// Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.switchTo().frame("emoojis");
        //3-ikinci emojiye tıklayınız
        WebElement secondEmojiTab=driver.findElement(By.xpath("//a[contains(@href,'nature')]"));
        secondEmojiTab.click();
        //4-tüm ikinci öğelere tıklayınız
        List<WebElement> emojiList=driver.findElements(By.xpath("//div[@id='nature']//img"));
        emojiList.forEach(WebElement::click);//her bir img elemente tıklanıyor

        //5- Parent iframe geri dönünüz.
        driver.switchTo().parentFrame();

        //6-Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.
        WebElement text=driver.findElement(By.id("text"));
        text.sendKeys("Text");
        WebElement smiles=driver.findElement(By.id("smiles"));
        smiles.sendKeys("Smiles");
        WebElement food=driver.findElement(By.id("food"));
        food.sendKeys("Food");
        driver.findElement(By.id("send")).click();
    }






}
