package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1.   sayfasina gidin
        driver.navigate().to("https://id.heroku.com/login");

//            2.  Bir mail adersi giriniz

        driver.findElement(By.id("email")).sendKeys("nltlb9597@gmail.com");
//3.  Bir password giriniz
        driver.findElement(By.id("password")).sendKeys("12345678");
//4.  Login butonuna tiklayiniz
        driver.findElement(By.name("commit")).click();
//5.  "There was a problem with your login." texti gorunur ise
        if(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed()){
            System.out.println("giris basarisiz");
        }else System.out.println("giris yapildi");
//6.  "kayit yapilamadi" yazdiriniz
//8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
//9.  Tum sayfalari kapatiniz
driver.quit();
}
}
