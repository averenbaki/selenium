package Base.TestNG.Day17;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C02_DataProvider {

    @Test(dataProvider = "getData")
    public void test(String name,String mail, String password, Integer number) {
        //username, email , password, number
        System.out.println("name = " + name);
        System.out.println("mail = " + mail);
        System.out.println("password = " + password);
        System.out.println("number = " + number);
        System.out.println();
    }

    @DataProvider
    public Object[][] getData() {
        //verileri teste sağlayacak method

        Object[][] data = {{"Eren","eb@mail.com","abc",46},
                {"Gamze","gk@mail.com","def",07},
                {"Sülüman","ss@mail.com","ghn",34}};
        return data;
    }

}
