package Day13_ScreenShoots_WebTables;

import Utilities.BaseTest;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_WebTables extends BaseTest {
    @Test
    public void webTableExample() {
//        Go to URL: http://demo.guru99.com/test/web-table-element.php
//        To find third row of table
//        To get 3rd row's 3nd column data
//        Get all the values of a Dynamic Table

        //        Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //        To find third row of table
        WebElement table=driver.findElement(By.className("dataTable"));//tablomuzu locate ettik
        //3.satır locate edildi
        WebElement row3=table.findElement(By.xpath(".//tr[3]"));//element üzerinden arama yaptığımızdan'.' ile başlıyoruz
                                        // '(.//tr)[3] yapılırsa sayfada elements bölümündeki tr sırasına göre 3.yü alır'
        System.out.println(row3.getText());

        //        To get 3rd row's 3nd column data
        WebElement row3cell3=row3.findElement(By.xpath(".//td[3]"));//td yani tabledata (hücre) [3].sütun
        System.out.println(row3cell3.getText());

        //        Get all the values of a Dynamic Table
        int satırsayisi=table.findElements(By.xpath(".//tr")).size();//tr-table row tüm satırlar
        System.out.println("satırsayisi = " + satırsayisi);

        int sutunsayisi=row3.findElements(By.xpath(".//td")).size();
        System.out.println("sutunsayisi = " + sutunsayisi);

        for (int i = 1; i <= satırsayisi; i++) {//index olarak gitmediğinden 1 den başlar//her satır işlemi

            for (int j = 1; j <=sutunsayisi ; j++) {//her sütun işlemi
                By locator=By.xpath(".//tr["+i+"]//td["+j+"]");
                WebElement tableData=table.findElement(locator);

                System.out.print(tableData.getText()+" ");
            }
            System.out.println();//dummy
        }


        /*----AHANDA TRICK----*/
        /*element üzerinden arama yaptığımızda'.' ile başlıyoruz AKSİ TAKDİRDE SAYFADAKİ İLK EŞLEŞME GETİRİLİR
        TABLE ÜZERİNDE YER ALAN VERİ DEĞİL SAYFADA YER ALAN BAŞKA BİR VERİ GELEBİLİR*/

    }
}
