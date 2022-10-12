package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LocalePage extends BasePage {
    public LocalePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private final By languageBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[3]");

    private final By languageSelectMenu = By.xpath("//*[@id=\"app\"]/div[2]/div");

    public void languageBtnClick() {
        getDriver().findElement(languageBtn).click();
    }

    public void setLanguage(String preferredLanguage) {
        getDriverWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(languageBtn)));
        languageBtnClick();
        List<WebElement> languages = getDriver().findElements(languageSelectMenu);
        for (WebElement language : languages) {
            if (language.getText().equals(preferredLanguage)) {
                language.click();
                break;
            }
        }

    }
}
