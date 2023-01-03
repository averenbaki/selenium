package Base.TestNG.Day18;

import org.testng.annotations.Test;

public class C02_ParalelTestParameter {
    @Test(threadPoolSize = 2,//testimizin kaç çekirdekte paralel olarak çalışacağını belirler
            invocationCount = 4)//testin kaç defa çalışacağını belirler
    public void testMethod() {

        System.out.println("Current thread Id= "+Thread.currentThread().getId());
    }


}
