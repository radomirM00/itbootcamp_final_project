package testPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;

public class BaseTest {


    protected HomePage homePage;
    protected LogInPage logInPage;
    protected UserPage userPage;
    protected AdminPage adminPage;
    protected AuthRoutesPage authRoutesPage;
    protected LocalePage localePage;
    protected SignUpPage signUpPage;
    protected WebDriver driver;
    protected Faker faker = new Faker();
    protected WebDriverWait driverWait;
    private final By logOutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver, driverWait);
        logInPage = new LogInPage(driver, driverWait);
        userPage = new UserPage(driver, driverWait);
        signUpPage = new SignUpPage(driver, driverWait);
        adminPage = new AdminPage(driver, driverWait);
        authRoutesPage = new AuthRoutesPage(driver, driverWait);
        localePage = new LocalePage(driver, driverWait);


    }

    @AfterClass
    public void terminate() {
        driver.quit();
    }


    public By getLogOutBtn() {
        return logOutBtn;
    }


    public boolean isVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public void logOut() {
        driver.findElement(logOutBtn).click();
    }


}
