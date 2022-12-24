package Homework.practise01;

import Utilities.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class task04_select extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
    3. Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    4. Tüm dropdown değerleri(value) yazdırın.
    5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, değilse False yazdırın.
*/

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown=driver.findElement(By.id("dropdown"));//dropdown locate
        Select select=new Select(dropDown);//select oluşturuldu

        select.selectByIndex(1);//index ile select yapıldı
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");//value ile select yapıldı
        System.out.println(select.getFirstSelectedOption().getText());//2.yi yazdırır first dese dahi çünkü select edilen 2

        select.selectByVisibleText("Option 1");//visibletext kullanarak select yaptık
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> allOptions= select.getOptions();//dropdown daki tüm optionlar get ile liste atıldı
        allOptions.forEach(t-> System.out.println(t.getText()));

        System.out.println(allOptions.size() == 4 ? "True" : "False");


    }
}
