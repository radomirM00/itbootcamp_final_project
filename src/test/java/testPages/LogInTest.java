package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test(priority = 1)
    public void verifyLogInPageUrl() {
        homePage.goToLogInPage();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void verifyEmailInputType() {
        homePage.goToLogInPage();
        String actualEmail = logInPage.checkEmailInputType();
        String expectedEmail = "email";
        Assert.assertEquals(actualEmail, expectedEmail);
    }

    @Test(priority = 3)
    public void verifyPasswordInputType() {
        homePage.goToLogInPage();
        String actualPass = logInPage.checkPasswordInputType();
        String expectedPass = "password";
        Assert.assertEquals(actualPass, expectedPass);
    }

    @Test(priority = 4)
    public void verifyLogIn() {
        homePage.goToLogInPage();
        logInPage.logIn("admin@admin.com", "12345");
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/home";
        driverWait.until(ExpectedConditions.urlContains("home"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 6)
    public void validateUserDoesNotExistErrorMsg() {
        homePage.goToLogInPage();
        logInPage.logIn("test@test.com", "12345");
        String expectedText = "User does not exists";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualText = actual.getText();
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test(dependsOnMethods = {"verifyLogIn"})
    public void verifyLogout() {
        Assert.assertTrue(isVisible(getLogOutBtn()));
        logOut();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
