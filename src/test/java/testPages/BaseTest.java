package testPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LogInPage;
import pages.SignUpPage;
import pages.UserPage;
import java.time.Duration;
public class BaseTest {
    protected HomePage homePage;
    protected LogInPage logInPage;
    protected UserPage userPage;
    protected SignUpPage signUpPage;
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver,driverWait);
        logInPage = new LogInPage(driver,driverWait);
        userPage = new UserPage(driver,driverWait);
        signUpPage = new SignUpPage(driver,driverWait);
    }

    private By logOutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    public By getLogOutBtn() {
        return logOutBtn;
    }

    public boolean isVisible(By element){
        return driver.findElement(element).isDisplayed();
    }
    public void logOut(){
        driver.findElement(logOutBtn).click();
    }

}
