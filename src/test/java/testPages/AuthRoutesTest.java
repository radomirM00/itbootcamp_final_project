package testPages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest {
    @Test
    public void verifyThatVisitIsForbiddenToHomeUrlIfNotAuthenticated() {
        authRoutesPage.setUrlRoute("/home");
        Assert.assertFalse(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void verifyThatVisitIsForbiddenToProfileUrlIfNotAuthenticated() {
        authRoutesPage.setUrlRoute("/profile");
        Assert.assertFalse(driver.getCurrentUrl().contains("/profile"));
    }

    @Test
    public void verifyThatVisitIsForbiddenToAdminCitiesUrlIfNotAuthenticated() {
        authRoutesPage.setUrlRoute("/admin/cities");
        Assert.assertFalse(driver.getCurrentUrl().contains("/admin/cities"));
    }

    @Test
    public void verifyThatVisitIsForbiddenToAdminUsersUrlIfNotAuthenticated() {
        authRoutesPage.setUrlRoute("/admin/users");
        Assert.assertFalse(driver.getCurrentUrl().contains("/admin/users"));
    }


}
