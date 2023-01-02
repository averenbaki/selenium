package Base.TestNG.Day17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_DataProviderClass {



    @DataProvider(name = "testData")
    public Object[][] data() {
        //verileri teste sağlayacak method

        Object[][] returnData = {
                {"First Test","Birinci Test"},
                {"Second Test","İkinci Test"},
                {"Third Test","Üçüncü Test"}
        };
        return returnData;
    }

}
