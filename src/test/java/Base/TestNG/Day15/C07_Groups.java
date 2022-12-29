package Base.TestNG.Day15;

import org.testng.annotations.Test;

public class C07_Groups {

    // Bu groups attribute u sayesinde biz istedigimiz grouplara sahip test caselerini ozel olarak calistirabiliriz.

    @Test(groups = {"smoke", "regression"})
    public void loginTest(){

    }

    @Test(groups = {"regression"})
    public void aboutTest(){

    }

    @Test(groups = {"regression"})
    public void contactTest(){

    }

    @Test(groups = {"regression", "smoke"})
    public void registrationTest(){

    }

    @Test(groups = {"regression", "smoke"})
    public void checkoutTest(){

    }



}
