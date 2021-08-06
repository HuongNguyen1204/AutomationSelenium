package page.objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.BrowserHelper.getWebDriver;

public class GooglePage extends BasePage {

    //Selector
    private By _tilesMainResult = By.xpath("//h3[@class='LC20lb DKV0Md']");
    private By _titlesVideoSection = By.xpath("//div[@class= 'fc9yUc oz3cqf p5AXld']");
    private By _titlesPeopleAsk = By.xpath("//div[@jsname='jIA8B']");

    //Element

    private List<WebElement> titlesMainResult() {
        return getWebDriver().findElements(_tilesMainResult);
    }

    private List<WebElement> titlesVideoSection() {
        return getWebDriver().findElements(_titlesVideoSection);
    }

    private List<WebElement> titlesPeopleAsk() {
        return BrowserHelper.getWebDriver().findElements(_titlesPeopleAsk);
    }

    //Method

    public boolean verifyMainResult(String value) {
        return verifyTitleInList(titlesMainResult(), value);
    }

    public boolean verifyVideoSections(String value) {
        return verifyTitleInList(titlesVideoSection(), value);
    }

    public boolean verifyTitlesPeopleAsk(String value) {
        return verifyTitleInList(titlesPeopleAsk(), value);
    }

}
