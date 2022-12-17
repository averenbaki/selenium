package Day06_WebElementLocators;

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

public class C02_CSSSelector {

    //CSS daha hızlı xpath daha yavaştır ama xpath daha çok tercih edilir
    WebDriver driver;

    @Before
    public void setUp() {
        //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()

            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

        @After
        public void tearDown() {
        driver.quit();

        }

        @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createElements(100);
        deleteButtonsAndValidate(40);

        }

        //create button methodu ile 100 defa create elements e tıklıyoruz
        public void createElements(int amount){

            WebElement addElementButton= driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));
            for (int i = 0; i <amount ; i++) {
                addElementButton.click();
            }

        }

        public void deleteButtonsAndValidate(int amount){
            //1-sayfadaki delete button sayısını saklarız
            List<WebElement> deleteButtonList= driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            int silinmedenOnceDeleteButtonSayisi=deleteButtonList.size();

            //2-bizden istenen sayı kadar butonu sileriz
            for (int i = 0; i <amount ; i++) {
                deleteButtonList.get(i).click();
            }
            //3-silindikten sonraki buton sayısını buluruz
            List<WebElement> deleteButtonListAfter= driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
            int silinmedenSonraDeleteButtonSayisi=deleteButtonListAfter.size();

            //4-ilk sayı ile son sayı arasındaki farkı doğrularız
            Assert.assertEquals(silinmedenOnceDeleteButtonSayisi-amount,silinmedenSonraDeleteButtonSayisi);



        }



}
