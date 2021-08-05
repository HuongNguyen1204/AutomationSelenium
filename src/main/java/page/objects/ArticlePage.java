package page.objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log;

import static helpers.BrowserHelper.getWebDriver;

public class ArticlePage extends BasePage {

    // Locator
    private By _titleInput = By.id("jform_title");
    private By _articleTextArea = By.id("jform_articletext_ifr");
    private By _imageIcon = By.xpath("//div [@class='js-editor-tinymce'] //button[.='Image']");
    private By _firstTile = By.cssSelector("tbody tr:first-child a[data-original-title=Edit]");
    private By _imageItem = By.xpath("//div[normalize-space(.)='powered_by...']//preceding-sibling::div");
    private By _insertBtn = By.cssSelector("button.button-save-selected");
    private By _parentImageIframe = By.cssSelector("div.mce-container-body.mce-window-body iframe");
    private By _imageIframe = By.id("imageframe");

    // Element
    private WebElement titleInput() {
        return getWebDriver().findElement(_titleInput);
    }

    private WebElement firstTile() {
        return getWebDriver().findElement(_firstTile);
    }

    private WebElement articleTextArea() {
        return getWebDriver().findElement(_articleTextArea);
    }

    private WebElement imageTab() {
        return getWebDriver().findElement(_imageIcon);
    }

    private WebElement imageItem() {
        return getWebDriver().findElement(_imageItem);
    }

    private WebElement insertButton() {
        return getWebDriver().findElement(_insertBtn);
    }

    private WebElement imageIframe() {
        return getWebDriver().findElement(_imageIframe);
    }

    private WebElement parentImageIframe() {
        return getWebDriver().findElement(_parentImageIframe);
    }

    // Method
    public void clickImageTab() {
        waitToClick(imageTab());
    }

    public void clickInsertButton() {
        insertButton().click();
    }

    /***
     * fill data to article form and click save
     * @param title
     * @param status
     * @param category
     * @param text
     */
    public void enterArticleForm(String title, String status, String category, String text) {
        titleInput().sendKeys(title);
        chooseStatus(status);
        chooseCategory(category);
        articleTextArea().sendKeys(text);
    }

    /***
     * Insert image
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


    /***
     * Get first title articles post
     * @return
     */
    public String getFirstTitle() {
        return getText(firstTile());
    }
}
