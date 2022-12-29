package Base.TestNG.Day15;

import org.testng.annotations.Test;

public class C04_Enabled {

    @Test(enabled = true)
    public void enabledTest() {

    }


    @Test(enabled = false)
    public void disabledTest() {//enabled değerini false atadığımız için 'run' olaamz

    }
}
