package Day12_Files_ApachePOI;

import Utilities.BaseTest;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileExist  {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));//projemizin root'unun yolunu verir
        String projectRoot=System.getProperty("user.dir");

        String filePath="/src/test/java/resources/fileExist.jpg";

        filePath=projectRoot+filePath;
        System.out.println(Files.exists(Paths.get(filePath)));//bu path de dosyanın varlığnı kontrol ettik/true

        if (Files.exists(Paths.get(filePath))){
            System.out.println("Dosya Bulundu");
        }else System.out.println("Dosya Bulunamadı");



    }



}
