package Base.TestNG.Day15;

import org.testng.annotations.Test;

public class C06_Description {

    //testin amacı ile ilgili bilgi verilecek kısım
    //daha sonra gelen testerlar için yardımcı niteliğinde
    //test commit i denilebilir,raporlama

    @Test(description = "Bu test sistemimizin login fonksiyonlarini kontrol eder")
    public void loginTest(){

    }

    @Test(description = "Bu test sistemimizin Home Page fonksiyonlarini kontrol eder")
    public void homePageTest(){

    }

}
