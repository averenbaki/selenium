package Day12_Files_ApachePOI;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist  {



    @Test
    public void fileExist() {


        System.out.println(System.getProperty("user.home"));//C:\Users\ACER

        String homePath=System.getProperty("user.home");

        String filePath="/Desktop/fileExist.png";

        String fullPath=homePath+filePath;

        File image=new File(fullPath);
        Assert.assertTrue(image.exists());




    }





}
