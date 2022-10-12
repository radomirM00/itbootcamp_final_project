package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private final By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private final By citiesBtn = By.xpath("//*[@id=\"list-item-117\"]");

    private final By addCityBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private final By savedSuccessfullyMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private final By typeCityField = By.id("name");
    private final By saveBtn = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private final By editCityName = By.id("edit");
    private final By deleteCityBtn = By.id("delete");

    public void selectCitiesFromAdminDropdown() {
        getDriver().findElement(adminBtn).click();
        getDriverWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(citiesBtn)));
        getDriver().findElement(citiesBtn).click();
    }

    public void enterCityName(String cityName) {
        getDriver().findElement(addCityBtn).click();
        getDriverWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(typeCityField)));
        getDriver().findElement(typeCityField).sendKeys(cityName);
        getDriver().findElement(saveBtn).click();
    }

    public boolean isCitySavedSuccessfully() {
        return getDriver().findElement(savedSuccessfullyMsg).isDisplayed();
    }


}
