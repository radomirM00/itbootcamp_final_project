package testPages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {
    @Test
    public void verifyAdminCitiesPageUrl() {
        homePage.goToLogInPage();
        logInPage.logIn("admin@admin.com", "12345");
        adminPage.selectCitiesFromAdminDropdown();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
    }

    @Test(dependsOnMethods = {"verifyAdminCitiesPageUrl"})
    public void verifyThatLogoutBtnIsVisible() {
        Assert.assertTrue(isVisible(getLogOutBtn()));
    }

    @Test(dependsOnMethods = {"verifyAdminCitiesPageUrl"})
    public void verifyThatNewCityIsCreated() {
        adminPage.enterCityName(faker.address().cityName());
        Assert.assertTrue(adminPage.isCitySavedSuccessfully());
    }

    //TODO city edit, city delete
}
