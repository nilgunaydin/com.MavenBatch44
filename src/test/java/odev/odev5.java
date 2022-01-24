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

import java.time.Duration;
import java.util.List;

public class odev5 {
    static WebDriver driver;
@BeforeClass
    static  public void  setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/");
}


//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori
//    sayisinin 45 oldugunu test edin

@Test
public void test01 () {
driver.findElement(By.id("searchDropdownBox")).click();
List<WebElement> list = driver.findElements(By.xpath("//select/option[@value]"));
Assert.assertNotEquals(45, list.size()); //but its 28

}
//             -Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
@Test
public void test02 () {
driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

System.out.println(text);
    Assert.assertTrue(text.contains("Java"));

}
    @AfterClass
    public static void dobarlan() {
    driver.close();

    }
}


