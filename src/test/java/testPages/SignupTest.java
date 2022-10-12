package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SignupTest extends BaseTest {
    @Test(priority = 1)
    public void verifySignUpUrl() {
        signUpPage.signUpBtnClick();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void verifyInputFieldTypes() {
        ArrayList<Boolean> actualInputFiledTypeChecks = new ArrayList<>();
        ArrayList<Boolean> expectedInputFieldTypeChecks = new ArrayList<>();
        actualInputFiledTypeChecks.add(signUpPage.checkNameInputType().equals("text"));
        actualInputFiledTypeChecks.add(signUpPage.checkEmailInputType().equals("email"));
        actualInputFiledTypeChecks.add(signUpPage.checkPasswordInputType().equals("password"));
        actualInputFiledTypeChecks.add(signUpPage.checkConfirmPasswordInputType().equals("password"));
        for (int i = 0; i < actualInputFiledTypeChecks.size(); i++) {
            expectedInputFieldTypeChecks.add(true);
        }
        Assert.assertEquals(actualInputFiledTypeChecks, expectedInputFieldTypeChecks);
    }

    @Test(priority = 3)
    public void validateExistingUserErrorMessage() {
        signUpPage.fillInputField("Test Test", signUpPage.getName());
        signUpPage.fillInputField("admin@admin.com", signUpPage.getEmail());
        signUpPage.fillInputField("123546", signUpPage.getPassword());
        signUpPage.fillInputField("123546", signUpPage.getConfirmPassword());
        signUpPage.submitSignupClick();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")).isDisplayed());
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 4)
    public void signUp() {
        signUpPage.clearInputFields();
        signUpPage.fillInputField("Radomir Milovic", signUpPage.getName());
        signUpPage.fillInputField("rado21mi22r21.milovic@itbootcamp.rs", signUpPage.getEmail());
        signUpPage.fillInputField("123456", signUpPage.getPassword());
        signUpPage.fillInputField("123456", signUpPage.getConfirmPassword());
        signUpPage.submitSignupClick();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(signUpPage.getVerificationMessage()));
        Assert.assertTrue(driver.findElement(signUpPage.getVerificationMessage()).getText().contains("IMPORTANT: Verify your account"));
    }

}
