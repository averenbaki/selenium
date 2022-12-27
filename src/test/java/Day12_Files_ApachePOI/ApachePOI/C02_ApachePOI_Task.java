package Day12_Files_ApachePOI.ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePOI_Task {
//    Add the excel file on the resources folder.
//    Open the file.
//    Open the workbook using file input stream.
//    Open the first worksheet.
//    Go to first row.
//    Go to first cell on that first row and print.
//    Go to second cell on that first row and print.
//    Go to 2nd row first cell and assert if the data equal to Rusya.
//    Go to 3rd row 2nd cell-chain the row and cell.
//    Find the number of used row.
//    Print country, area key value pairs as map object.
    @Test
    public void apacheTask() throws IOException {
        //Excel dosyası path alındı
        String path="src/test/java/resources/excelfile.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        //    Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //    Open the first worksheet.
        Sheet sheet1 = workbook.getSheetAt(0);
        //    Go to first row.
        Row row1 =sheet1.getRow(0);
        //    Go to first cell on that first row and print.
        Cell row1cell1=row1.getCell(0);
        System.out.println("row1cell1 = " + row1cell1);
        //    Go to second cell on that first row and print
        Cell row1cell2 = row1.getCell(1);
        System.out.println("row1cell2 = " + row1cell2);
        //    Go to 2nd row first cell and assert if the data equal to Rusya.
        Row row2=sheet1.getRow(1);
        Cell row2cell1=row2.getCell(0);
        Assert.assertEquals("Rusya",row2cell1.toString());
        //    Go to 3rd row 2nd cell-chain the row and cell.
        Row row3=sheet1.getRow(2);
        Cell row3cell2=row3.getCell(1);//Cell row3cell2=sheet1.getRow(2).getCell(1);
        System.out.println("row3cell2 = " + row3cell2);
        //    Find the number of used rows.
        sheet1.getPhysicalNumberOfRows();//doğrudan satır sayısını verir index için 1 eksik almalıyız
        sheet1.getLastRowNum();//index verir//physical number dan bir eksik olur
        //    Print country, area key value pairs as map object.
        int totalRows=sheet1.getPhysicalNumberOfRows();
        Map<String,String> countryAreas=new HashMap<>();
        for (int row=1; row<totalRows; row++){
            String country=sheet1.getRow(row).getCell(0).toString();

            String area=sheet1.getRow(row).getCell(1).toString();
            //System.out.println( (row+1)+" .satır= " + country+"-Area "+area);
            countryAreas.put(country, area);//map haline getirdik

        }System.out.println( countryAreas);

    }



}
