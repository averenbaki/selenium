package Base.Test.Day01_AnnotationsTestNG;

import org.testng.annotations.Test;

public class C02_Priority {


    // TestNG (default) olarak @Test annotationları alfabetik sıraya göre execute eder
    // TestNG prioritysinin sayi degeri en az olan testi ilk once calistirir
    // Priporty attribute u icin negatif degerler kullanilabilir



    @Test(priority = 1000)
    public void test02(){
        System.out.println("Test 2 Çalıştı");
    }
    @Test(priority = 1001)
    public void test04(){
        System.out.println("Test 4 Çalıştı");
    }
    @Test(priority = 1500)
    public void test01(){
        System.out.println("Test 1 Çalıştı");
    }
    @Test(priority = 2000)
    public void test03(){
        System.out.println("Test 3 Çalıştı");
    }

}
