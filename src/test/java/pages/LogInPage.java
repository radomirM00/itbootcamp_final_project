package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver, WebDriverWait driverWait){
        super(driver, driverWait);
    }
    private By email = By.id("email");
    private By password = By.id("password");
    private By logInBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    public void logIn(String emailCredential, String passwordCredential){
        getDriver().findElement(email).sendKeys(emailCredential);
        getDriver().findElement(password).sendKeys(passwordCredential);
        getDriver().findElement(logInBtn).click();
    }

    public String checkEmailInputType(){
        String emailType = getDriver().findElement(email).getAttribute("type").toString();
        return emailType;
    }
    public String checkPasswordInputType(){
        String passwordType = getDriver().findElement(password).getAttribute("type").toString();
        return passwordType;
    }





}
