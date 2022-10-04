package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, WebDriverWait driverWait){
        super(driver,driverWait);
    }
    private By logInBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");

    public WebElement getLogInBtn(){
        return getDriver().findElement(logInBtn);
    }

    public void goToLogInPage(){
        getLogInBtn().click();
    }

}
