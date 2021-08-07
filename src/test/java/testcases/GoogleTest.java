package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.GooglePage;
import utilities.Constants;
import utilities.Log;

public class GoogleTest extends BaseTest {

    @Test
    public void Scenario01() {
        GooglePage googlePage = new GooglePage();
        Log.info("Go go Google page");

        Log.info("Search for Heal The World");
        googlePage.search(Constants.KEY_WORLD);

        Log.info("Verify search results on main section");
        Assert.assertTrue(googlePage.verifyMainResult(Constants.KEY_WORLD), "The text is not contained in the main search result");

        Log.info("Verify search results on Video section");
        Assert.assertTrue(googlePage.verifyVideoSections(Constants.KEY_WORLD), "The text is not contained in the Video section");

        Log.info("Verify search results on People also ask");
        Assert.assertTrue(googlePage.verifyTitlesPeopleAsk(Constants.KEY_WORLD), "The text is not contained in the People also ask section");
    }
}
