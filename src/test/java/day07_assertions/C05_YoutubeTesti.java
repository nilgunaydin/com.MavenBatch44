package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
    static WebDriver driver;

    //
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        String title = driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,title);
    }

    @Test
    public void imageTest(){
WebElement icon = driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
Assert.assertTrue(icon.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        String title = driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertNotEquals(expectedTitle,title);
    }

    @AfterClass
    public static void teardown(){
    driver.close();

    }
}