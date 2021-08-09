package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.BrowserHelper.getElement;

public class BasePage {
    //selector
    private By textBoxSearch = By.cssSelector("input[name=q]");

    //Method
    public void search(String name) {
        getElement(textBoxSearch).sendKeys(name);
        getElement(textBoxSearch).sendKeys(Keys.ENTER);
    }

    public boolean isAllTitlesContainValue(List<WebElement> titles, String value) {
        for (WebElement title : titles) {
            if (!title.getText().toLowerCase().contains(value.toLowerCase())) return false;
        }
        return true;
    }
}
