package Day2_Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ManageWindowCommend {
    /*
    Invoke Chrome Browser
       Open URL: https://www.google.com/
       Maximize the window.
       Print the position and size of the page.
       Minimize the page.
       Wait 5 seconds in the icon state and maximize the page.
               Print the position and dimensions of the page in maximized state.
       Make the page fullscreen.
      Close the Browser.
     */
    public static void main(String[] args) throws InterruptedException {

      System.setProperty("webdriver.chrome.driver","Dependencies\\drivers\\chromedriver.exe");

      WebDriver driver= new ChromeDriver();

      //1-open url
      driver.get("https://www.google.com");

      //2-maximize the window
      driver.manage().window().maximize();

      //3-print the position and size of the page
        Point point=driver.manage().window().getPosition();//Browser ın şu anki pozisyonunu(konumu) verir

        //pozisyonun koordinat değerleri değişkenlere atandı
        int posX= point.getX();
        int posY=point.getY();

        System.out.println("posX = " + posX);
        System.out.println("posY = " + posY);

        //browser ın size ı(boyutu) verilir
        Dimension dimension=driver.manage().window().getSize();
        int height=dimension.getHeight();
        int width=dimension.getWidth();

        System.out.println("browser yüksekliği height = " + height);
        System.out.println("browser genişliği width= " + width);

      //4-minimize the window
      driver.manage().window().minimize();

      //5-(5) seconds wait --> 1sn=1000ms
        Thread.sleep(5000);

      //6-maximize the window
      driver.manage().window().maximize();

      //print the position and size of the page
      Point point1=driver.manage().window().getPosition();//Browser ın şu anki pozisyonunu(konumu) verir

      //pozisyonun koordinat değerleri değişkenlere atandı
      int posX1= point1.getX();
      int posY1=point1.getY();

      System.out.println("posX = " + posX1);
      System.out.println("posY = " + posY1);

      //browser ın size ı(boyutu) verilir
      Dimension dimension1=driver.manage().window().getSize();
      int height1=dimension1.getHeight();
      int width1=dimension1.getWidth();

      System.out.println("browser yüksekliği height1 = " + height1);
      System.out.println("browser genişliği width1= " + width1);

      //7-fullscreen
      driver.manage().window().fullscreen();

      //8-çıkış
        driver.close();



    }
}
