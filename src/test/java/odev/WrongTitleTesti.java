package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class WrongTitleTesti {static WebDriver driver;
    static WebElement aramaCubugu;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        //ChromeOptions object
        ChromeOptions op = new ChromeOptions();
        //disable notification parameter
        op.addArguments("--disable-notifications");
        // configure options parameter to Chrome driver
        driver = new ChromeDriver(op);
        // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//https://www.hepsiburada.com/ sayfasina gidelim
        driver.get("https://www.hepsiburada.com/");

        driver.manage().getCookies(); // Returns the List of all Cookies
        driver.manage().deleteAllCookies(); // Deletes all the cookies




    }
    @Test
    public void wrongTitleTesti () {

        String actualTitle=driver.getTitle();
        String expectedTitle="hepsi";
        Assert.assertFalse(actualTitle.equals(expectedTitle));

        //hepsiburada title da hepsi oldugunu kontrol edin
    }
    @Test
    public void logoTesti() {
        //4.
        //hepsiburada logosunun gozuktugunu test edelim
        WebElement logo=driver.findElement(By.xpath("//a[@class='sf-OldHeader-1NFKi']"));
        Assert.assertTrue("logo geldi mi",logo.isDisplayed());
    }
    @Test
    public void aramaCubuguEnabled () {

        //arama cubugunun enabled oldugunu erisilebilir oldgunu test edin

        aramaCubugu=driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        Assert.assertTrue(aramaCubugu.isEnabled());
    }

    @Test
    public void monitorAraTest (){
        //arama cubuguna monitor arattirin

        aramaCubugu=driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        while (!aramaCubugu.getAttribute("value").equals("")) {
            aramaCubugu.sendKeys(Keys.BACK_SPACE);
        }
        aramaCubugu.sendKeys("monitor"+ Keys.ENTER);

    }



    @Test
    public void sonucSayisi () {

        //cikan sonucun 100 den fazla oldugunu test edin
        aramaCubugu=driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        while (!aramaCubugu.getAttribute("value").equals("")) {
            aramaCubugu.sendKeys(Keys.BACK_SPACE);
        }
        aramaCubugu.sendKeys("monitor"+ Keys.ENTER);

        WebElement sonucSayisi=driver.findElement(By.xpath("//b[@class='searchResultSummaryBar-bold']"));

        String sonucSayisiStr=sonucSayisi.getText().replace("+","");
        int sonucInteger=Integer.parseInt(sonucSayisiStr);
        System.out.println(sonucInteger);
        Assert.assertTrue(sonucInteger>100);

    }


    @Test
    public void sepet (){

        //urun secip sepete atin
        System.out.println("sepet methodu calisti");
        aramaCubugu=driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        while (!aramaCubugu.getAttribute("value").equals("")) {
            aramaCubugu.sendKeys(Keys.BACK_SPACE);
        }
        aramaCubugu.sendKeys("monitor"+ Keys.ENTER);

        WebElement urun=driver.findElement(By.xpath("(//div[@data-test-id='review'])[1]"));
        urun.click();

    }




    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}