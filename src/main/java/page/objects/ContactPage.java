package page.objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log;

import static helpers.BrowserHelper.getWebDriver;

public class ContactPage extends BasePage {

    //Locator
    private By _contactTile = By.id("jform_name");
    private By _statusSelect = By.id("jform_published_chzn");
    private By _imageBtn = By.cssSelector(".field-media-wrapper button.btn.button-select");
    private By _parentImageIframe = By.cssSelector("div#imageModal_jform_image iframe");
    private By _insertBtn = By.cssSelector("button.button-save-selected");
    private By _imageIframe = By.id("imageframe");
    private By _imageItem = By.xpath("//div[normalize-space(.)='powered_by...']//preceding-sibling::div");

    //Element
    private WebElement contactTile() {
        return getWebDriver().findElement(_contactTile);
    }

    private WebElement statusSelect() {
        return getWebDriver().findElement(_statusSelect);
    }

    private WebElement imageBtn() {
        return getWebDriver().findElement(_imageBtn);
    }

    private WebElement imageIframe() {
        return getWebDriver().findElement(_imageIframe);
    }

    private WebElement parentImageIframe() {
        return getWebDriver().findElement(_parentImageIframe);
    }

    private WebElement imageItem() {
        return getWebDriver().findElement(_imageItem);
    }

    private WebElement insertButton() {
        return getWebDriver().findElement(_insertBtn);
    }

    //Method

    /***
     * Choose status select input
     * @param status
     */
    public void chooseStatus(String status) {
        statusSelect().click();
        clickOptionName(status);
    }

    /***
     * Fill data to contact form
     * @param title
     * @param status
     * @param category
     */
    public void enterContactForm(String title, String status, String category) {
        contactTile().sendKeys(title);
        chooseStatus(status);
        chooseCategory(category);
    }

    public void clickImageBtn() {
        imageBtn().click();
    }

    public void clickInsertButton() {
        insertButton().click();
    }

    /***
     * Insert image to contact form
     */
    public void insertImage() {

        Log.info(" + Choose image");
        BrowserHelper.switchToIframe(parentImageIframe());
        BrowserHelper.switchToIframe(imageIframe());
        imageItem().click();

        Log.info(" + Click Insert button");
        BrowserHelper.switchToDefaultContent();
        BrowserHelper.switchToIframe(parentImageIframe());
        clickInsertButton();
        BrowserHelper.switchToDefaultContent();
    }
}
