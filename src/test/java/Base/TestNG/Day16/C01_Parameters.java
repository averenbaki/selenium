package Base.TestNG.Day16;

import Base.Utilities.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C01_Parameters  {

    @Test
    @Parameters("İsim")
    public void test01(String name) {
        System.out.println("Hello "+name);
    }



}
