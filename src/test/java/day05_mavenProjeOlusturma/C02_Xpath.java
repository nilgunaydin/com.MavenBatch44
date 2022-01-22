package day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanina  “username” yazdirin
driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
driver.findElement(By.id("sp_amount")).sendKeys("120");
        //8. tarih kismina “” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
String alertMessage = driver.findElement(By.id("alert_content")).getText();
if(alertMessage.equals("The payment was successfully submitted.")){
    System.out.println("payment test PASS");
}else{System.out.println("payment test FAILED");
}
driver.close();
    }
}
