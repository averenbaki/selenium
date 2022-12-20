package Day08_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown_Select {
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
       // driver.quit();
    }

    @Test
    public void selectByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //dropdown locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));

        //locate edilen dropdown select objesine dönüştürüldü
        Select select=new Select(drpDown);
        select.selectByIndex(1);//ALGERIA
        //selectByIndex methodu her index gibi '0' ile başlar

    }

    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //dropdown locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));

        //locate edilen dropdown select objesine dönüştürüldü
        Select select=new Select(drpDown);
        select.selectByValue("TURKEY");//value değeri girildi

    }

    @Test
    public void visibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //dropdown locate edildi
        WebElement drpDown=driver.findElement(By.name("country"));

        //locate edilen dropdown select objesine dönüştürüldü
        Select select=new Select(drpDown);
        select.selectByVisibleText("FINLAND");
        //selectByValue methodu option elementlerinin value attribute unun değerine göre seçim yapar

        System.out.println(select.isMultiple());//false
        //birden çok seçim yapıp, yapamama durumunu boolean olarak ifade eder


    }

    @Test
    public void multipleSelect() {

        driver.get("https://output.jsbin.com/osebed/2");
        Select select=new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());//true

        select.selectByValue("apple");
        select.selectByIndex(3);//grape

    }


    //getOptions: argüman olarak string alır, açılır menü listesinden bir seçeneğin seçilmesini sağlar
    //getOptions():List<WebElement>
    @Test
    public void getOptions() {
    driver.get("https://demo.guru99.com/test/newtours/register.php");
   Select select=new Select(driver.findElement(By.name("country")));

   //getOptions metodu select elementinin tüm seçeneklerini(optionlarını) bir liste içerisinde bize verir
    List<WebElement> options=select.getOptions();
         for (WebElement w:options) {System.out.println(w.getText());}

    }

    @Test
    public void getFirsSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select=new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());//true

        select.selectByIndex(3);//grape
        select.selectByIndex(2);//orange
        WebElement selectedOption=select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
    //getFirstSelectedOption() metodu seçili olan ilk option elementini bize verir.(seçtiğimiz ilk option u değil)
    }

    @Test
    public  void getAllSelectedOptions(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select=new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());//true
        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> selectedOptions=select.getAllSelectedOptions();
        selectedOptions.forEach(t-> System.out.println(t.getText()));
    }




}
