package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. “” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “” yazdirin
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement IlkUrun= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String IlkUrunIsmi = IlkUrun.getText() ;
        System.out.println(IlkUrunIsmi);
        IlkUrun.click();
        //6. Add to Cart butonuna basin
driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
WebElement sepetteki = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
String Sepettekiurunadi = sepetteki.getText();
if(Sepettekiurunadi.equals(IlkUrunIsmi)){
    System.out.println("sepet testi PASS");}else{
        System.out.println("sepet testi FAILLED");}


        //9. Sayfayi kapatin

driver.close();
    }
}
