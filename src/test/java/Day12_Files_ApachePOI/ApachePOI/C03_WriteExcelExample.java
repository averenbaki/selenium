package Day12_Files_ApachePOI.ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcelExample {
    @Test
    public void writeExcel() throws IOException {
//        Store the path of the file as string and open the file.
//        Open the workbook.
//                Open the first worksheet.
//                Go to the first row.
//        Create a cell on the 3rd column (2nd index) on the first row.
//        Write “POPULATION” on that cell.
//                Create a cell on the 2nd row 3rd cell(index2), and write data.
//        Create a cell on the 3rd row 3rd cell(index2), and write data.
//        Create a cell on the 4th row 3rd cell(index2), and write data.
//        Write and save the workbook.
//                Close the file.
//        Close the workbook.


        String path="src/test/java/resources/excelfile.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
//                Open the first worksheet.
        Sheet sheet2= workbook.getSheetAt(1);//2.sayfa açıldı
//                Go to the first row.
        Row row1= sheet2.getRow(0);//ilk satırı aldık
//        Create a cell on the 3rd column (2nd index) on the first row.
        Cell row1cell3= row1.createCell(2);//güncellenebilir bir alan oluşturduk//getcell yerine createcell yazdık
//        Write “POPULATION” on that cell.
        row1cell3.setCellValue("POPULATION");
//        Create a cell on the 2nd row 3rd cell(index2), and write data.
        sheet2.getRow(1).createCell(2).setCellValue("Rusyanın Populasyonu");
//        Create a cell on the 3rd row 3rd cell(index2), and write data.
        sheet2.getRow(2).createCell(2).setCellValue("Çin'in Populasyonu");
//        Create a cell on the 4th row 3rd cell(index2), and write data.
        sheet2.getRow(3).createCell(2).setCellValue("ABD'nin Populasyonu");
//        Write and save the workbook.
        FileOutputStream fos= new FileOutputStream(path);
        workbook.write(fos);//yazma işlemi tamamlandı
//        Close the file.
        fileInputStream.close();
        fos.close();
//        Close the workbook.
        workbook.close();





    }
}
