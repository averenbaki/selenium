package Base.TestNG.Day15;

import org.testng.annotations.Test;

public class C08_MultipleAssertions {


    // Bir test methodu birden fazla attribute kullanilarak konfigure edilebilir
    @Test(
            description = "This is a test case",
            priority = 10,
            groups = {"regression"},
            enabled = false
    )
    public void test(){
    }
}
