package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.getWebDriver;

public class WebLinkPage extends BasePage {

    //Locator
    private By _webLinkTitle = By.id("jform_title");
    private By _url = By.id("jform_url");
    private By _orderBtn = By.cssSelector("thead tr th span[class='icon-menu-2']");
    private By _firstTitle = By.cssSelector("tbody tr:first-child td.nowrap.has-context a ");

    //Element
    private WebElement webLinkTitle() {
        return getWebDriver().findElement(_webLinkTitle);
    }

    private WebElement url() {
        return getWebDriver().findElement(_url);
    }

    private WebElement orderBtn() {
        return getWebDriver().findElement(_orderBtn);
    }

    private WebElement firstTitle() {
        return getWebDriver().findElement(_firstTitle);
    }

    //Method
    public void enterWebLinkForm(String name, String url, String status) {
        webLinkTitle().sendKeys(name);
        url().sendKeys(url);
        clickToStatusSelect();
        clickOptionName(status);
    }

    /***
     * Click first weblink article and click to order icon
     */
    public void orderingWebLink() {
        clickCheckboxBtnByName(getFirstTitle());
        orderBtn().click();
    }

    public String getFirstTitle() {
        return getText(firstTitle());
    }

}
