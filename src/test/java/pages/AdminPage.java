package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage{

    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By adminBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesBtn = By.id("list-item-568");
    private By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By deleteCityBtn = By.id("delete");




}
