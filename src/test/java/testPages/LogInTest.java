package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

import java.time.Duration;

public class LogInTest {
   private HomePage homePage;
   private LogInPage logInPage;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver,driverWait);
        logInPage = new LogInPage(driver,driverWait);
    }

    @Test
    public void verifyLogInPageUrl(){
        homePage.goToLogInPage();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void verifyEmailInputType(){
        homePage.goToLogInPage();
        String actualEmail = logInPage.checkEmailInputType();
        String expectedEmail = "email";
        Assert.assertEquals(actualEmail,expectedEmail);
    }

    @Test
    public void verifyPasswordInputType(){
        homePage.goToLogInPage();
        String actualPass = logInPage.checkPasswordInputType();
        String expectedPass = "password";
        Assert.assertEquals(actualPass,expectedPass);
    }

    @Test
    public void verifylogIn(){
        homePage.goToLogInPage();
        logInPage.logIn("admin@admin.com", "12345");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/home";
        driverWait.until(ExpectedConditions.urlContains("home"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test
    public void invalidUserLoginTest(){
        homePage.goToLogInPage();
        logInPage.logIn("test@test.com","12345");
        String expectedText = "User does not exists";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualText = actual.getText();
        Assert.assertEquals(actualText,expectedText);
    }
}
