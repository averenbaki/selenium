package Base.TestNG.Day17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

public class C01_DataProvider {

    @Test(dataProvider = "dataProvider")
    public void test01(String name) {
        //verileri dataprovider methodundan alarak çalışacak olan test
        System.out.println(name);
    }

    @DataProvider
    public Object[][] dataProvider() {
        //verileri teste sağlayacak method

        Object[][] data = {{"Eren"},{"Baki"},{"46"}};
        return data;
    }

}
