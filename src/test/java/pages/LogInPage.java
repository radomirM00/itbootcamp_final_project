package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By logInBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    public void logIn(String emailCredential, String passwordCredential) {
        clearInputFields();
        getDriver().findElement(email).sendKeys(emailCredential);
        getDriver().findElement(password).sendKeys(passwordCredential);
        getDriver().findElement(logInBtn).click();
    }

    public void clearInputFields() {
        getDriver().findElement(email).clear();
        getDriver().findElement(password).clear();
    }

    public String checkEmailInputType() {
        return getDriver().findElement(email).getAttribute("type");
    }

    public String checkPasswordInputType() {
        return getDriver().findElement(password).getAttribute("type");
    }
}
