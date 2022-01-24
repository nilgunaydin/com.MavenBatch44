package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class odev4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    // a. adresine gidiniz.
        driver.navigate().to("http://a.testaddressbook.com");
    // b. Sign in butonuna basin
driver.findElement(By.id("sign-in")).click();
    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement email = driver.findElement(By.id("session_email"));
        WebElement password = driver.findElement(By.id("session_password"));
        WebElement signin  = driver.findElement(By.name("commit"));

    // d. Kullanıcı adını ve şifreyi aşağıdaki sekilde girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username :
    // ii.Password :

        email.sendKeys("testtechproed@gmail.com");
        password.sendKeys("Test1234!");
        signin.click();

    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String ExpectedUserId = "testtechproed@gmail.com";
        String ActualUserId = driver.findElement(By.className("navbar-text")).getText();
        if(ActualUserId.equals(ExpectedUserId)) System.out.println("User id test PASS");
        else System.out.println("User id test FAILED");
    // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        if(driver.findElement(By.linkText("Addresses")).isDisplayed()) System.out.println("Addresses is displayed");
        else System.out.println("Addresses is NOT displayed");
        if(driver.findElement(By.linkText("Sign out")).isDisplayed()) System.out.println("Sign out is displayed");
        else System.out.println("Sign out is NOT displayed");

    //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> Links = driver.findElements(By.tagName("a"));
        System.out.println(Links.size()+" adet link var");
    //4.Linklerin yazisini nasil yazdirabiliriz
        System.out.print("== ");
        for (WebElement we:Links) {
            System.out.print(we.getText()+" == ");
        }
    //5. driver i kapatin
        driver.close();
} }
