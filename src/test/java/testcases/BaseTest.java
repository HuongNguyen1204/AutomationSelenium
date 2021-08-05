package testcases;

import helpers.BrowserHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utilities.Constants;

public class BaseTest {

    @BeforeMethod()
    @Parameters("browser")
    public void setupTestMethod(String browser) {
        BrowserHelper.DriverType type = BrowserHelper.DriverType.valueOf(browser.toUpperCase());
        BrowserHelper.startBrowser(type);
        BrowserHelper.navigateToUrl(Constants.BASE_URL);
    }

    @AfterMethod
    public void closePage() {
        BrowserHelper.quitBrowser();
    }

}
