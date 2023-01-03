package Base.TestNG.Day18;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_ParalelTestDataProvider {

    @Test(dataProvider = "getData")
    public void test(String ad,String soyad) {
        System.out.println(ad+soyad+Thread.currentThread().getId());

    }

    @DataProvider(parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"yusuf"," çelik"},
                {"can"," efe"},
                {"merve"," aslan"}
        };
    }

}
