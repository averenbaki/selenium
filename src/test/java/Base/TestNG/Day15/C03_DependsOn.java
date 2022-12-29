package Base.TestNG.Day15;

import org.testng.annotations.Test;

public class C03_DependsOn {

    //Bir testin çalışması başka bir teste bağlıysa kullanılır
    // Home page testimiz login testimize bagli oldugundan dependsOn attribute unu kullanabiliriz
    // Bagimli olunan test fail olursa bagimli olan method ignore edilir.
    // Bagimli olan method alfabetik execution a bakilmaksizin bagimli olunan metoddan sonra calisir
    // Coklu dependsOn kullaniminda tum bagimli olunan methodlar pass oldugu durumda bagimli method calisir


    @Test
    public void loginTest(){
        System.out.println("Login testi yapiliyor");
    }

    @Test
    public void registrationTest(){
        System.out.println("Kayit testi yapiliyor");
    }


    @Test(dependsOnMethods = {"registrationTest", "loginTest"})
    public void homePageTest(){
        System.out.println("Home Page testi yapiliyor");
    }

}
