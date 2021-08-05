package page.objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.Constants;
import utilities.Log;

import static helpers.BrowserHelper.getWebDriver;
import static helpers.BrowserHelper.waitForElement;

public class BasePage {

    //Locator
    private By _newBtn = By.cssSelector("#toolbar button.button-new");
    private By _saveAndCloseBtn = By.cssSelector("#toolbar-save button");
    private By _savedSuccessMessage = By.cssSelector("div.alert-success div.alert-message");
    private By _searchToolBtn = By.xpath("//button[normalize-space()='Search Tools']");
    private By _statusSelectSearchTool = By.id("filter_published_chzn");
    private By _trashBtn = By.cssSelector("#toolbar-trash button");
    private By _helpBtn = By.cssSelector("#toolbar button[rel=help]");
    private By _listLimit = By.id("list_limit_chzn");
    private By _editBtn = By.cssSelector("#toolbar-edit button");
    private By _statusSelect = By.id("jform_state_chzn");
    private By _categorySelect = By.id("jform_catid_chzn");
    private By _saveBtn = By.xpath("//div[@id='toolbar']// button[normalize-space(.)='Save']");
    private static String _itemSubMenu = "//ul[@id='submenu']//li//a[contains(text(),'%s')]";
    private static String _menuItem = "//ul[@id='menu']//li//a[normalize-space(.)='%s']";
    private String _nameOption = "//div[@class='controls']//a[.='%s']";
    private String _typeStatus = "//div[@id='filter_published_chzn']//ul/li[.='%s']";
    private String _checkboxBtn = "//table//tbody//a[normalize-space()='%s']/../.. //preceding-sibling::td//input[@type='checkbox']";
    private String _titlePosted = "//tbody//td//a[normalize-space()='%s']";
    private String _quantityItem = "//div[@id='list_limit_chzn']//ul//li[normalize-space()='%s']";

    //Element
    private static WebElement menuItem(String nameMenuItem) {
        return getWebDriver().findElement(By.xpath(String.format(_menuItem, nameMenuItem)));
    }

    private WebElement newBtn() {
        return getWebDriver().findElement(_newBtn);
    }

    private WebElement saveAndCloseBtn() {
        return getWebDriver().findElement(_saveAndCloseBtn);
    }

    private WebElement nameOption(String nameOption) {
        return getWebDriver().findElement(By.xpath(String.format(_nameOption, nameOption)));
    }

    private WebElement savedSuccessMessage() {
        return getWebDriver().findElement(_savedSuccessMessage);
    }

    private static WebElement subMenuItem(String nameSubItem) {
        return getWebDriver().findElement(By.xpath(String.format(_itemSubMenu, nameSubItem)));
    }

    private WebElement trashBtn() {
        return getWebDriver().findElement(_trashBtn);
    }

    private WebElement searchToolBtn() {
        return getWebDriver().findElement(_searchToolBtn);
    }

    private WebElement checkboxBtn(String nameTitle) {
        return getWebDriver().findElement(By.xpath(String.format(_checkboxBtn, nameTitle)));
    }

    private WebElement statusSelectSearchTool() {
        return getWebDriver().findElement(_statusSelectSearchTool);
    }

    private WebElement typeStatus(String nameType) {
        return getWebDriver().findElement(By.xpath(String.format(_typeStatus, nameType)));
    }

    private WebElement titlePosted(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_titlePosted, name)));
    }

    private WebElement listLimitItem() {
        return getWebDriver().findElement(_listLimit);
    }

    private WebElement editBtn() {
        return getWebDriver().findElement(_editBtn);
    }

    private WebElement quantityItem(String numberItems) {
        return getWebDriver().findElement(By.xpath(String.format(_quantityItem, numberItems)));
    }

    private WebElement helpBtn() {
        return getWebDriver().findElement(_helpBtn);
    }

    private WebElement statusSelect() {
        return getWebDriver().findElement(_statusSelect);
    }

    private WebElement categorySelect() {
        return getWebDriver().findElement(_categorySelect);
    }

    private WebElement saveBtn() {
        return getWebDriver().findElement(_saveBtn);
    }

    //Method
    public static void clickMenuItem(String menuItemName) {
        waitForElement(menuItem(menuItemName), Constants.TIMES_WAIT_ELEMENTS);
        scrollToClick(menuItem(menuItemName));
    }

    public void clickNewBtn() {
        newBtn().click();
    }

    public void clickOptionName(String name) {
        nameOption(name).click();
    }

    public void clickSaveAndCloseBtn() {
        BrowserHelper.clickByJs(saveAndCloseBtn());
    }

    public void clickTrashBtn() {
        trashBtn().click();
    }

    public void clickEditBtn() {
        editBtn().click();
    }

    public void clickCheckboxBtnByName(String name) {
        BrowserHelper.clickByJs(checkboxBtn(name));
    }

    public void clickSearchToolBtn() {
        searchToolBtn().click();
    }

    public void clickStatusSearchTool() {
        statusSelectSearchTool().click();
    }

    public void clickToStatusSelect() {
        statusSelect().click();
    }

    public void clickToSaveBtn() {
        saveBtn().click();
    }

    /***
     * Get text of elements
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        return element.getText().trim();
    }

    /***
     * Scroll to view an element and click
     * @param element
     */
    public static void scrollToClick(WebElement element) {
        BrowserHelper.scrollToView(element);
        element.click();
    }

    /***
     * Get success message after saved success
     * @return
     */
    public String getSavedMessageSuccess() {
        waitForElement(savedSuccessMessage(),Constants.TIMES_WAIT_ELEMENTS);
        return getText(savedSuccessMessage());
    }

    /***
     * Deletem item by name title
     * @param nameItem
     */
    public void deleteItem(String nameItem) {
        clickCheckboxBtnByName(nameItem);
        clickTrashBtn();
    }

    /***
     * View item by status
     * @param nameStatus
     */
    public void viewItemByStatus(String nameStatus) {
        clickSearchToolBtn();
        clickStatusSearchTool();
        typeStatus(nameStatus).click();
    }

    /***
     * Check the title is displays
     * @param titlePosted
     * @return
     */
    public boolean isDisplayTitle(String titlePosted) throws NoSuchElementException {
        try {
            return titlePosted(titlePosted).isDisplayed();
        } catch (NoSuchElementException e) {
            Log.info("The item just posted not displays" + e);
            return false;
        }
    }

    /***
     * Deletem item by name title
     * @param nameItem
     */
    public void editItem(String nameItem) {
        clickCheckboxBtnByName(nameItem);
        clickEditBtn();
    }

    /***
     * paging by quantity
     * @param quantity
     */
    public void paging(String quantity) {
        listLimitItem().click();
        quantityItem(quantity).click();
    }

    public void clickHelpBtn() {
        helpBtn().click();
    }

    public static void waitToClick(WebElement element) {
        BrowserHelper.waitForElement(element, Constants.TIMES_WAIT_ELEMENTS);
        element.click();
    }

    /***
     * Click to sub menu of menu dropdown
     * @param name
     */
    public static void clickToSubMenu(String name) {
        waitToClick(subMenuItem(name));
    }

    public boolean isDisplayTitleHelpPage(String title, int seconds) {
        for (String windowHandle : getWebDriver().getWindowHandles())
            BrowserHelper.switchToWindow(windowHandle);
        return BrowserHelper.waitForTitle(title, seconds);
    }

    public void chooseStatus(String nameStatus) {
        clickToStatusSelect();
        clickOptionName(nameStatus);
    }

    public void chooseCategory(String nameCategory) {
        categorySelect().click();
        clickOptionName(nameCategory);
    }
}
