package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WrongTitleTesti {

    static WebDriver driver;
    static WebElement aramaCubugu;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notification");
        driver = new ChromeDriver(op);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.hepsiburada.com/");
    driver.manage().deleteAllCookies();
    }
    @Test
    @Order(1)
    public void AAwrongTitleTesti () {
        //https://www.hepsiburada.com/ sayfasina gidelim

        String actualTitle=driver.getTitle();
        String expectedTitle="hepsi";
        Assert.assertFalse(actualTitle.equals(expectedTitle));

        //hepsiburada title da hepsi oldugunu kontrol edin
    }
    @Test
    @Order(2)
    public void BBlogoTesti() {
        //4.
        //hepsiburada logosunun gozuktugunu test edelim

        Assert.assertTrue("there is no logo",driver.findElement(By.xpath("//a[@class='sf-OldHeader-1NFKi']")).isDisplayed());
    }
    @Test
    @Order(3)
    public void CCaramaCubuguEnabled () {
        //arama cubugunun enabled oldugunu erisilebilir oldgunu test edin
        aramaCubugu = driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
    Assert.assertTrue(aramaCubugu.isEnabled());
    }
    @Test
    @Order(4)
    public void DDmonitorAraTest (){
        //arama cubuguna monitor arattirin
        aramaCubugu = driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        aramaCubugu.sendKeys("monitor", Keys.ENTER);
    }
    @Test
    @Order(5)
    public void EEsonucSayisi () {
        //cikan sonucun 100 den fazla oldugunu test edin
        Assert.assertTrue(Integer.parseInt(driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']")).
                getText()) >= 100);
    }
    @Test
    @Order(6)
    public void FFsepet (){
        //urun secip sepete atin
        WebElement IlkUrun = driver.findElement(By.id("i0"));
        IlkUrun.click();
        WebElement Buttom= driver.findElement(By.id("addToCart"));
        Buttom.click();

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}