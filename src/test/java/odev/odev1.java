package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class odev1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        //2.Title i consolda yazdirin
        System.out.println(driver.getTitle());
        //3.Title “YouTube” a eşitse “correct title” yazdirin değilse “incorrect title yzdirin”
  if(driver.getTitle().equals("YouTube")) System.out.println("Correct Title");
  else System.out.println("Incorrect Title");
        //4.Sayfayi kapatin
        driver.close();
        //5.Tum sayfalari kapatin
        driver.quit();
        //6.Consola “Test completed” yazdirin
        System.out.println("Test Completed");
    }
}
