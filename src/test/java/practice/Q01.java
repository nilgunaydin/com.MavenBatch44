package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {
   static WebDriver driver;
   static  WebElement aramaKutusu;
   static WebElement sonucSayisi;
//...Exercise1...
//BeforeClass ile driver ı olusturun ve class icinde static yapin
//Maximize edin, 15 sn bekletin
//http://www.google.com adresine gidin
//arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
//AfterClass ile kapatın

@BeforeClass
    public static void setup() {
 WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@Before
public void LetsGoTo(){
    driver.get("http://www.google.com ");
    aramaKutusu=driver.findElement(By.xpath("//input[@type='text']"));
    sonucSayisi=driver.findElement(By.id("result-stats"));

}
@Test
public void test01(){
aramaKutusu.sendKeys("Green Mile", Keys.ENTER);
    System.out.println(sonucSayisi.getText());
}
    @Test
    public void test02(){
        aramaKutusu.sendKeys("Premonition", Keys.ENTER);
        System.out.println(sonucSayisi.getText());
    }
    @Test
    public void test03(){
        aramaKutusu.sendKeys("The Curious Case of Benjamin Button", Keys.ENTER);
        System.out.println(sonucSayisi.getText());
    }

@AfterClass
    public static void teardown(){
    driver.close();
}
}
