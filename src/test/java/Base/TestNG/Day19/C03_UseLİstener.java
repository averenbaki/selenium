package Base.TestNG.Day19;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

    @Listeners(C02_ITestListener.class)
    public class C03_UseLİstener {

    @Test
    public void testpassed() {
        System.out.println("passed test");
    }

    @Test
    public void testfailed() {
        System.out.println("failed test");
        Assert.fail();

    }

    @Test(timeOut = 500)
    public void testtimeout() throws InterruptedException {
        System.out.println("time out test");
        Thread.sleep(600);
    }
}
