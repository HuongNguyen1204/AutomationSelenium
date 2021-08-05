package testcases;

import helpers.BrowserHelper;
import helpers.MenuHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.CategoryPage;
import page.objects.LoginPage;
import utilities.Constants;
import utilities.Log;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    CategoryPage categoryPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        categoryPage = new CategoryPage();
    }

    @Test(testName = "TO_JOOMLA_CATEGORY_MANAGER_007", description = "User can browse Category help page")
    public void TO_JOOMLA_CATEGORY_MANAGER_007() {
        Log.startTestCase("TO_JOOMLA_CATEGORY_MANAGER_007 : User can browse Category help page");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Content > Category on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.CONTENT_MENU+">"+Constants.CATEGORIES_ITEM);

        Log.info("[STEP-3] - Click Help button");
        categoryPage.clickHelpBtn();

        Log.info("[STEP-4] - Assert the help page is displays");
        Assert.assertTrue(categoryPage.isDisplayTitleHelpPage(Constants.TITLE_HELP_BROWSER, Constants.TIME_WAIT_FIRE_FOX), "The help page is not display");
    }

    @Test(testName = "TO_JOOMLA_CATEGORY_MANAGER_014", description = "User can move may articles to another category")
    public void TO_JOOMLA_CATEGORY_MANAGER_014() {
        Log.startTestCase("TO_JOOMLA_CATEGORY_MANAGER_014 : User can move may articles to another category");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Content > Category on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.CONTENT_MENU+">"+Constants.CATEGORIES_ITEM);

        Log.info("[STEP-3] - Get first title of categories");
        String firstTitle = categoryPage.getFirstTitle();

        Log.info("[STEP-4] - Ordering categories article");
        categoryPage.orderingCategory();

        Log.info("[STEP-5] - Assert the first title before and after sort ");
        Assert.assertNotEquals(firstTitle, categoryPage.getFirstTitle(), "The item is not ordering");
    }
}
