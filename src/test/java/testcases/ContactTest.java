package testcases;

import helpers.DataHelper;
import helpers.MenuHelper;
import org.testng.Assert;
import page.objects.ContactPage;
import page.objects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.Log;

public class ContactTest extends BaseTest {
    LoginPage loginPage;
    ContactPage contactPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage();
        contactPage = new ContactPage();
    }

    @Test(testName = "TO_JOOMLA_CONTACTS_006", description = "Verify user can check in contact")
    public void TC_JOOMLA_CONTACTS_006() {
        Log.startTestCase("TO_JOOMLA_CONTACTS_006: Verify user can check in contact ");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        MenuHelper.clickToItemMenu(Constants.COMPONENTS_MENU+">"+Constants.CONTACT_MENU);

        Log.info("[STEP-3] - Click New icon");
        contactPage.clickNewBtn();

        Log.info("[STEP-4] - Fill data to contact form");
        String titleRandom = DataHelper.randomText();
        contactPage.enterContactForm(titleRandom, Constants.STATUS_PUBLISHED, Constants.CATEGORY_CONTACT);

        Log.info("[STEP-5] - Click save and close button");
        contactPage.clickSaveAndCloseBtn();

        Log.info("[STEP-6] - Assert saved contact success");
        Assert.assertEquals(contactPage.getSavedMessageSuccess(), Constants.SAVE_CONTACT_SUCCESS, "Save  sucess message does not matched");

        Log.info("[STEP-7] - Select to show all contact");
        contactPage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-8] - Assert the tile contact just saved");
        Assert.assertTrue(contactPage.isDisplayTitle(titleRandom), "The contact just posted is not display");
    }

    @Test(testName = "TC_JOOMLA_CONTACTS_013", description = "Verify user can add image to contact's information")
    public void TC_JOOMLA_CONTACTS_013() {
        Log.startTestCase("TC_JOOMLA_CONTACTS_013: Verify user can add image to contact's information");

        Log.info("[STEP-1] - Log in with account registered before");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        Log.info("[STEP-2] - Click content on menu nav bar)");
        contactPage.clickMenuItem(Constants.COMPONENTS_MENU);

        Log.info("[STEP-3] - Click Contact item of components menu");
        contactPage.clickMenuItem(Constants.CONTACT_MENU);

        Log.info("[STEP-4] - Click New icon");
        contactPage.clickNewBtn();

        Log.info("[STEP-5] - Fill data to contact form");
        String titleRandom = DataHelper.randomText();

        contactPage.enterContactForm(titleRandom, Constants.STATUS_PUBLISHED, Constants.CATEGORY_CONTACT);
        Log.info("[STEP-6] - Click to image button");
        contactPage.clickImageBtn();

        Log.info("[STEP-7] - Insert image to contact form");
        contactPage.insertImage();

        Log.info("[STEP-8] - Click save and close button");
        contactPage.clickSaveAndCloseBtn();

        Log.info("[STEP-9] - Assert saved contact success");
        Assert.assertEquals(contactPage.getSavedMessageSuccess(), Constants.SAVE_CONTACT_SUCCESS, "Save  sucess message does not matched");

        Log.info("[STEP-10] - Select to show all contact");
        contactPage.paging(Constants.ALL_QUANTITY);

        Log.info("[STEP-11] - Assert the tile contact just saved");
        Assert.assertTrue(contactPage.isDisplayTitle(titleRandom), "The contact just posted is not display");

    }
}
