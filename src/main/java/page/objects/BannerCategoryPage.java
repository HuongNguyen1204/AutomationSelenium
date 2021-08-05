package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.getWebDriver;

public class BannerCategoryPage extends BasePage {
    //Locator
    private By _categoriesTitle = By.id("jform_title");

    //Element
    private WebElement categoriesTile() {
        return getWebDriver().findElement(_categoriesTitle);
    }

    /***
     * Fill name categories
     * @param nameTitle
     */

    public void enterCategoriesForm(String nameTitle) {
        categoriesTile().sendKeys(nameTitle);
    }
}
