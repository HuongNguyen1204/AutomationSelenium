package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.BrowserHelper.getWebDriver;

public class BasePage {
    //selector
    private By _textBox = By.cssSelector("input[name=q]");

    //Elements
    private WebElement textBox() {
        return getWebDriver().findElement(_textBox);
    }

    //Method
    public void search(String name) {
        textBox().sendKeys(name);
        textBox().sendKeys(Keys.ENTER);
    }

    public boolean verifyTitleInList(List<WebElement> titles, String value) {
        boolean result = true;
        for (WebElement title : titles) {
            result = title.getText().toLowerCase().contains(value.toLowerCase());
        }
        return result;
    }
}
