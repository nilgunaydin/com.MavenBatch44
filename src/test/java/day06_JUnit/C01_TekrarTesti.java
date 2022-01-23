package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Integer.parseInt;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
      //https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin

        //mende yoktur

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
       String Title =  driver.getTitle();
        if (Title.contains("Google")){
            System.out.println("Title test PASS");
        }else{
            System.out.println("Title test FAILED");}
        //5- Arama cubuguna “Nutella” yazip aratin
driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Nutella"+ Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin

        String sayi =driver.findElement(By.id("result-stats")).getText();
        System.out.println(sayi);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
String [] arr= sayi.split(" ");
String sayimiz = arr[1];
int sayi1 = Integer.parseInt(sayimiz.replaceAll("\\D",""));
if(sayi1>10000000){System.out.println("Nutella sonuc sayi testi PASS");}else{
    System.out.println("Nutella sonuc sayi testi FAILED");
}
        //8-Sayfayi kapatin
driver.close();
    }
}
