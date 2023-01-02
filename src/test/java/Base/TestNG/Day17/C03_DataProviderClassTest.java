package Base.TestNG.Day17;

import org.testng.annotations.Test;

public class C03_DataProviderClassTest {

    @Test(dataProvider = "testData",dataProviderClass = C03_DataProviderClass.class)
    public void dataProviderTest(String english,String turkish) {
        System.out.println(english);
        System.out.println(turkish);


    }



}
