package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signUpBtn = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By submitSignUp = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By verificationMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    public By getName() {
        return name;
    }
    public By getEmail() {
        return email;
    }
    public By getPassword() {
        return password;
    }
    public By getConfirmPassword() {
        return confirmPassword;
    }
    public By getVerificationMessage() {
        return verificationMessage;
    }
    public void signUpBtnClick(){
        getDriver().findElement(signUpBtn).click();
    }
    public void submitSignupClick(){
        getDriver().findElement(submitSignUp).click();
    }
    public String checkNameInputType(){
        String nameType = getDriver().findElement(name).getAttribute("type").toString();
        return nameType;
    }
    public String checkEmailInputType(){
        String emailType = getDriver().findElement(email).getAttribute("type").toString();
        return emailType;
    }
    public String checkPasswordInputType(){
        String passwordType = getDriver().findElement(password).getAttribute("type").toString();
        return passwordType;
    }
    public String checkConfirmPasswordInputType(){
        String confirmPasswordType = getDriver().findElement(confirmPassword).getAttribute("type").toString();
        return confirmPasswordType;
    }
    public void fillInputField(String input, By inputFiled){
        WebElement element = getDriver().findElement(inputFiled);
        element.sendKeys(input);
    }
    public void clearInputFields(){
        getDriver().findElement(name).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(email).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(password).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        getDriver().findElement(confirmPassword).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }
}
