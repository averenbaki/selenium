package Day12_Files_ApachePOI.ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {

    public static void main(String[] args) throws IOException {
        //Excel dosyası path alındı
        String path="src/test/java/resources/excelfile.xlsx";

        //Dosya açıldı
        FileInputStream fileInputStream=new FileInputStream(path);

        //açtığımız dosyayı excel workbook una çevirdik
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //workbook(excel dosyamız) dan sheet(sayfa) 'e geçiş yaptık
        Sheet sheet1=workbook.getSheetAt(0);

        //sheet te yer alan row(satır)' a geçiş yaptık
        Row row1=sheet1.getRow(0);

        //row da yer alan cell(hücre) seçildi
        Cell cell1=row1.getCell(0);
        System.out.println("cell1 = " + cell1);//.toString() ile string e çevirebiliriz ve string methodlarını kullanırız


    }





}
