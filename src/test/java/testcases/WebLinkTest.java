package testcases;

import helpers.DataHelper;
import helpers.MenuHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.WebLinkPage;
import utilities.Constants;
import utilities.Log;

public class WebLinkTest extends BaseTest {
    LoginPage loginPage;
    WebLinkPage webLinkPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        webLinkPage = new WebLinkPage();
    }

    @Test(testName = "TO_JOOMLA_WEBLINKS_007", description = "User can move a web link to trash section")
    public void TO_JOOMLA_WEBLINKS_007() {
        Log.startTestCase("TO_JOOMLA_WEBLINKS_007 : User can move a web link to trash section");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Content > Weblink on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.WEBLINK_ITEM);

        Log.info("[STEP-3] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-4] -Init new data for weblink form");
        String nameWebLinkRandom = DataHelper.randomText();
        String url = DataHelper.randomUrl();

        Log.info("[STEP-5] -Fill this data to weblink form");
        webLinkPage.enterWebLinkForm(nameWebLinkRandom, url, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-6] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-7] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS, "Save  sucess message does not matched");

        Log.info("[STEP-8] - Click to show all weblink ");
        webLinkPage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-9] - Move the weblink just posted to trash");
        webLinkPage.deleteItem(nameWebLinkRandom);

        Log.info("[STEP-10] - Assert message trash weblink success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.TRAHS_SUCCESS_WEBLINK, "Trash sucess message does not matched");

        Log.info("[STEP-11] - View item just trashed");
        webLinkPage.viewItemByStatus(Constants.TRASHED_STATUS);

        Log.info("[STEP-12] - Check item just trashed is displays");
        Assert.assertTrue(webLinkPage.isDisplayTitle(nameWebLinkRandom), "item just trashed is not displays");
    }

    @Test(testName = "TC_JOOMLA_WEBLINKS_014", description = "Verify user can change the order of weblinks using the Ordering column")
    public void TC_JOOMLA_WEBLINKS_014() {
        Log.startTestCase("TC_JOOMLA_WEBLINKS_014 : Verify user can change the order of weblinks using the Ordering column");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Components > Weblink on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.WEBLINK_ITEM);

        Log.info("[STEP-3] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-4] -Init new data for weblink form");
        String nameWebLinkRandom1 = DataHelper.randomText();
        String url1 = DataHelper.randomUrl();

        Log.info("[STEP-5] -Fill this data to weblink form");
        webLinkPage.enterWebLinkForm(nameWebLinkRandom1, url1, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-6] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-7] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS, "Save  sucess message does not matched");

        Log.info("[STEP-8] - Click content on menu nav bar)");
        webLinkPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-9] - Hover Banner item of Components menu");
        webLinkPage.clickMenuItem(Constants.WEBLINK_ITEM);

        Log.info("[STEP-10] - Click new button");
        webLinkPage.clickNewBtn();

        Log.info("[STEP-11] -Init the second new data for weblink form");
        String nameWebLinkRandom2 = DataHelper.randomText();
        String url2 = DataHelper.randomUrl();

        Log.info("[STEP-12] -Fill this data to weblink form");
        webLinkPage.enterWebLinkForm(nameWebLinkRandom2, url2, Constants.STATUS_PUBLISHED);

        Log.info("[STEP-13] - Click save button");
        webLinkPage.clickSaveAndCloseBtn();

        Log.info("[STEP-14] - Assert weblink saved success");
        Assert.assertEquals(webLinkPage.getSavedMessageSuccess(), Constants.SAVE_WEBLINK_SUCCESS, "Save  sucess message does not matched");

        webLinkPage.paging(Constants.ALL_QUANTITY);
        Log.info("[STEP-15] - Get first title of categories");
        String firstTitle = webLinkPage.getFirstTitle();

        Log.info("[STEP-16] - Choose first weblink and click order button");
        webLinkPage.orderingWebLink();

        Log.info("[STEP-17] - Assert the first title before and after sorting ");
        Assert.assertNotEquals(firstTitle, webLinkPage.getFirstTitle(), "The item is not ordering");
    }
}
