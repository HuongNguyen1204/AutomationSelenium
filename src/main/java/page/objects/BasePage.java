package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.BrowserHelper.getWebDriver;

public class BasePage {
    //selector
    private By textBoxSearch = By.cssSelector("input[name=q]");

    //Elements
    private WebElement textBox() {
        return getWebDriver().findElement(textBoxSearch);
    }

    //Method
    public void search(String name) {
        textBox().sendKeys(name);
        textBox().sendKeys(Keys.ENTER);
    }

    public boolean isAllTitlesContainValue(List<WebElement> titles, String value) {
        for (WebElement title : titles) {
            if(!title.getText().toLowerCase().contains(value.toLowerCase())) return false;
        }
        return true;
    }
}
