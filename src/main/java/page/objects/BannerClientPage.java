package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Constants;

import java.util.List;

import static helpers.BrowserHelper.getWebDriver;
import static helpers.BrowserHelper.waitForElement;

public class BannerClientPage extends BasePage {
    // Locator
    private By _nameInput = By.id("jform_name");
    private By _contactName = By.id("jform_contact");
    private By _contactEmail = By.id("jform_email");
    private By _rowsTable = By.cssSelector(".table-striped tbody tr");
    private By _stateSelectSearchTool = By.id("filter_state_chzn");
    private By _statusSelect = By.id("jform_state_chzn");
    private String _typeStatusSelect = "//div[@id='jform_state_chzn']//ul//li[.='%s']";
    private String _statusBySearchTool = "//div[@id='filter_state_chzn']//ul/li[.='%s']";

    // Element
    private WebElement nameInput() {
        return getWebDriver().findElement(_nameInput);
    }

    private WebElement contactName() {
        return getWebDriver().findElement(_contactName);
    }

    private WebElement contactEmail() {
        return getWebDriver().findElement(_contactEmail);
    }

    private WebElement statusSelect() {
        return getWebDriver().findElement(_statusSelect);
    }

    private WebElement typeStatusSelect(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_typeStatusSelect, name)));
    }

    private WebElement stateSelectSearchTool() {
        return getWebDriver().findElement(_stateSelectSearchTool);
    }

    private WebElement statusBySearchTool(String name) {
        return getWebDriver().findElement(By.xpath(String.format(_statusBySearchTool, name)));
    }

    private List<WebElement> rowsTable() {
        return getWebDriver().findElements(_rowsTable);
    }

    /***
     * Fill data to clients form
     * @param textClientName
     * @param textContactName
     * @param textContactEmail
     */
    public void enterClientForm(String textClientName, String textContactName, String textContactEmail) {
        waitForElement(nameInput(),Constants.TIMES_WAIT_ELEMENTS);
        nameInput().sendKeys(textClientName);
        waitForElement(contactName(),Constants.TIMES_WAIT_ELEMENTS);
        contactName().sendKeys(textContactName);
        contactEmail().sendKeys(textContactEmail);
    }

    /***
     * Choose status of contact form
     * @param nameStatus
     */
    public void chooseStatus(String nameStatus) {
        statusSelect().click();
        typeStatusSelect(nameStatus).click();
    }

    /***
     * Clear data of client form ( use for edit client form )
     */
    public void clearDataClientForm() {
        nameInput().clear();
        contactName().clear();
        contactEmail().clear();
    }

    public int getSizeAllRows() { return rowsTable().size();}

    public void chooseStatusByName(String name) {
        waitToClick(statusBySearchTool(name));
    }

    public void selectStatusSearchTool(String status){
        stateSelectSearchTool().click();
        chooseStatusByName(status);
    }
    /***
     * View item by status
     * @param nameStatus
     */
    public void filterBannerByStatus(String nameStatus) {
        clickSearchToolBtn();
        selectStatusSearchTool(nameStatus);
    }
}
