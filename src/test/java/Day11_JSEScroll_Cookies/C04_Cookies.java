package Day11_JSEScroll_Cookies;

import Utilities.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C04_Cookies extends BaseTest {
    /*
    Go to URL: https://kitchen.applitools.com/ingredients/cookie
Get Cookie.
Find the total number of cookies.
Print all the cookies.
Add Cookie.
Edit Cookie.
Delete Cookie.
Delete All Cookies.
     */

    @Test
    public void cookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        //Get Cookie
        Cookie cookie=driver.manage().getCookieNamed("protein");//cookie isimle çağrıldı
        Assert.assertEquals("chicken",cookie.getValue());

        //Find the total number of cookies.
        Set<Cookie> allCookies=driver.manage().getCookies();
        System.out.println("cookies.size() = " + allCookies.size());

        //Print all the cookies.
        for (Cookie c : allCookies){
            System.out.println("each cookie : "+c);
            System.out.println("each cookie name : "+c.getName());
            System.out.println("each cookie value : "+c.getValue());
        }

        //Add cookie
        System.out.println("add cookie");
        Cookie cookie1=new Cookie("fruit","apple");//cookie oluşturduk
        driver.manage().addCookie(cookie1);
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies=driver.manage().getCookies();
        System.out.println("allCookies.size() eklemeden sonra= " + allCookies.size());//3

        //Edit cookie
        System.out.println("edit cookie");

        Cookie editedCookie=new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(editedCookie);
        System.out.println(driver.manage().getCookieNamed(editedCookie.getName()).getValue());
        Assert.assertEquals(editedCookie.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());


    }

    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2

        Cookie addedCookie = new Cookie("drinks", "ayran"); //cookie olusturduk
        driver.manage().addCookie(addedCookie); //cookie ekledik

        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 3

        System.out.println("delete cookies");
        driver.manage().deleteCookie(addedCookie); // cookie sildik
        Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(addedCookie.getName())); //PASSED

        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 2

        driver.manage().deleteAllCookies(); //browserdan hepsi sildik
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); // allCookies = 0


    }
}
