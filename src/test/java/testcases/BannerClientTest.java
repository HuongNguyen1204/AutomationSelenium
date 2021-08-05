package testcases;

import helpers.DataHelper;
import helpers.MenuHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.BannerClientPage;
import page.objects.LoginPage;
import utilities.Constants;
import utilities.Log;

public class BannerClientTest extends BaseTest {
    LoginPage loginPage;
    BannerClientPage bannerClientPagePage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        bannerClientPagePage = new BannerClientPage();
    }

    @Test(testName = "TC_JOOMLA_BANNERS_CLIENTS_002", description = "User can edit a client")
    public void TC_JOOMLA_BANNERS_CLIENTS_002() {
        Log.startTestCase("TC_JOOMLA_BANNERS_CLIENTS_002 : User can edit a client");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Component>Banner > Client on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.BANNER_MENU+">"+Constants.CLIENTS_ITEMS);

        Log.info("[STEP-3] - Click new button");
        bannerClientPagePage.clickNewBtn();

        Log.info("[STEP-4] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-5] - Fill this data to contact form");
        bannerClientPagePage.enterClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-6] - Click save and close button");
        bannerClientPagePage.clickSaveAndCloseBtn();

        Log.info("[STEP-7] - Assert saved clients success");
        Assert.assertEquals(bannerClientPagePage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS, "success message save client does not matched");

        Log.info("[STEP-8] - Click to show all client ");
        bannerClientPagePage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-9] - Click edit the client item just posted");
        bannerClientPagePage.editItem(nameClientRandom);

        Log.info("[STEP-10] - Clear data old");
        bannerClientPagePage.clearDataClientForm();

        Log.info("[STEP-11] - Init new data for edit clients");
        String editNameClient = DataHelper.randomText();
        String editNameContact = DataHelper.randomText();
        String editEmail = DataHelper.randomEmail();

        Log.info("[STEP-12] - Fill this data to contact form");
        bannerClientPagePage.enterClientForm(editNameClient, editNameContact, editEmail);

        Log.info("[STEP-13] - Click save and close button");
        bannerClientPagePage.clickSaveAndCloseBtn();

        Log.info("[STEP-14] - Assert saved clients success");
        Assert.assertEquals(bannerClientPagePage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS, "success message save client does not matched");

        Log.info("[STEP-15] - Check item banner just posted is displays");
        Assert.assertTrue(bannerClientPagePage.isDisplayTitle(editNameClient), "the item client just posted is not display");
    }

    @Test(testName = "TC_JOOMLA_BANNERS_CLIENTS_009", description = "User can search a client by using filter dropdown list")
    public void TO_JOOMLA_BANNERS_CLIENTS_009() {
        Log.startTestCase("TO_JOOMLA_BANNERS_CLIENTS_009 : User can search a client by using filter dropdown list");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Commponent > Banner >Client item of Banner item");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.BANNER_MENU+">"+Constants.CLIENTS_ITEMS);

        Log.info("[STEP-3] - Click new button");
        bannerClientPagePage.clickNewBtn();

        Log.info("[STEP-4] - Init data for new clients");
        String nameClientRandom = DataHelper.randomText();
        String nameContactRandom = DataHelper.randomText();
        String emailRandom = DataHelper.randomEmail();

        Log.info("[STEP-5] - Fill this data to contact form");
        bannerClientPagePage.enterClientForm(nameClientRandom, nameContactRandom, emailRandom);

        Log.info("[STEP-6] - Select unpublished status");
        bannerClientPagePage.chooseStatus(Constants.STATUS_UNPUBLISHED);

        Log.info("[STEP-7] - Click save and close button");
        bannerClientPagePage.clickSaveAndCloseBtn();

        Log.info("[STEP-8] - Assert saved clients success");
        Assert.assertEquals(bannerClientPagePage.getSavedMessageSuccess(), Constants.SAVE_CLIENTS_SUCCESS, "success message save client does not matched");

        Log.info("[STEP-9] - View client by unpublished status");
        bannerClientPagePage.filterBannerByStatus(Constants.STATUS_UNPUBLISHED);

        Log.info("[STEP-10] - View all item");
        bannerClientPagePage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-11] - Check banner just posted");
        Assert.assertTrue(bannerClientPagePage.isDisplayTitle(nameClientRandom), "the item client just posted is not display");
    }

    @Test(testName = "TC_JOOMLA_BANNERS_CLIENTS_016", description = "Verify that user can change the quantity of items displayed in client table")
    public void TC_JOOMLA_BANNERS_CLIENTS_016() {
        Log.startTestCase("TC_JOOMLA_BANNERS_CLIENTS_016 : Verify that user can change the quantity of items displayed in client table");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click Component>Banner > Client on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.BANNER_MENU+">"+Constants.CLIENTS_ITEMS);

        Log.info("[STEP-3] - Click to view 5 item");
        bannerClientPagePage.paging(String.valueOf(Constants.FIVE_ITEM));

        Log.info("[STEP-4] - Assert the quantity item after change the quantity");
        Assert.assertTrue(bannerClientPagePage.getSizeAllRows() <= Constants.FIVE_ITEM, "The quantity of client display wrong");
    }
}
