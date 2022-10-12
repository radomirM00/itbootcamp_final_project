package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthRoutesPage extends BasePage {
    public AuthRoutesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    public String setUrlRoute(String route) {
        return baseUrl + route;
    }
}
