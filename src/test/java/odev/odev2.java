package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
       // 4-https://github.com/ adresine gidelim
        driver.navigate().to("https://github.com/nilgunaydin/");
       // 5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
        driver.navigate().to("https://www.hepsiburada.com/");
       // 6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip
        // icermedigini kontrol edelim
        String Title=driver.getTitle();
        String Url = driver.getCurrentUrl();
        if (Title.contains("burada")) System.out.println("Title test PASS");
            else System.out.println("Title test FAILED");
        if (Url.contains("burada")) System.out.println("URL test PASS");
        else System.out.println("URL test FAILED");
       // 7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
       // 8-Son adim olarak butun sayfalarimizi kapatmis olalim
     driver.quit();



    }
}
