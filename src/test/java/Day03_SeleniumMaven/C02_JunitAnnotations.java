package Day03_SeleniumMaven;

import org.junit.*;

public class C02_JunitAnnotations {
    //        1. @Test -> Marks a method as a TEST CASE.
    //        2. @Before : Runs before EACH @Test annotation.
    //        3. @After : Runs after EACH @Test annotation.
    //        4. @BeforeClass : Runs before each class only once.
    //        5. @AfterClass : Runs after each class only once.
    //        6. @Ignore : Skipping a test case.


    //1.test
    //2.test
    //3.test
    //4.test (geliştirme aşamasında bu yüzden rapora dahil edilmeyecek)

    //Her testten önce ve sonra çalışması gereken code blockları(methods) mevcut
    //Tüm testlerin öncesinde ve sonrasında çalışması gereken methodlarımız mevcut


    @Test
    public void test01(){
        System.out.println("1.test yapılıyor...");
    }
    @Test
    public void test02(){
        System.out.println("2.test yapılıyor...");
    }
    @Test
    public void test03(){
        System.out.println("3.test yapılıyor...");
    }

    @Test
    @Ignore
    public void test04(){
        System.out.println("4.test geliştirme aşamasında...");
    }

    @Before
    public void beforeEach(){
        System.out.println("method öncesi code block çalıştı...");
    }
    @After
    public void afterEach(){
        System.out.println("method sonrası code block çalıştı...");
    }

    @BeforeClass
    public static void beforeAll(){
        System.out.println("tüm methodların öncesinde code block çalıştı..");
    }

    @AfterClass
    public static void afterAll(){
        System.out.println("tüm methodların sonrasında code block çalıştı..");
    }



}
