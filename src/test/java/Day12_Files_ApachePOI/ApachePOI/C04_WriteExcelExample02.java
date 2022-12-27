package Day12_Files_ApachePOI.ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcelExample02 {
    @Test
    public void writeExcel02() throws IOException {
//        Create an object of File class to open xlsx file.
//        Create an object of FileInputStream class to read excel file.
//        Create an object of FileInputStream class to read excel file.
//        Creating workbook instance that refers to .xlsx file.
//        Creating a Sheet object.
//        Get all rows in the sheet.
//        Create a row object to retrieve row at index 4.
//        Create a cell object to enter value in it using cell Index.
//        Write the data in excel using output stream.

        //        Create an object of File class to open xlsx file.
        String path="src/test/java/resources/excelData.xlsx";
        //        Create an object of FileInputStream class to read excel file.
        File file=new  File(path);
        FileInputStream fis=new FileInputStream(file);
        //        Creating workbook instance that refers to .xlsx file.
        Workbook workbook= WorkbookFactory.create(fis);
        //        Creating a Sheet object.
        Sheet  informationData= workbook.getSheet("informationData");//sayfamızın adı informationData
        //        Get all rows in the sheet.
        int totalRowsUsed=informationData.getLastRowNum()-informationData.getFirstRowNum();
        System.out.println("totalRowsUsed = " + totalRowsUsed);
        //        Create a row object to retrieve row at index 4.
        Row row5=informationData.createRow(4);
        //        Create a cell object to enter value in it using cell Index.
        row5.createCell(0).setCellValue("Eren");
        row5.createCell(1).setCellValue("Baki");
        row5.createCell(2).setCellValue("erenbaki34@hotmail.com");
        row5.createCell(3).setCellValue("male");
        row5.createCell(4).setCellValue("460746");
        row5.createCell(5).setCellValue("Turkey");
        //        Write the data in excel using output stream.
        FileOutputStream fos= new FileOutputStream(file);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();




    }
}
