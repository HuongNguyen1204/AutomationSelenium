package page.objects;

import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.BrowserHelper.*;

public class GooglePage extends BasePage {

    //Selector
    private By lblTilesMainResult = By.xpath("//h3[@class='LC20lb DKV0Md']");
    private By lblTitlesVideoSection = By.xpath("//div[@class= 'fc9yUc oz3cqf p5AXld']");
    private By lblTitlesPeopleAsk = By.xpath("//div[@jsname='jIA8B']");

    //Element

    private List<WebElement> titlesMainResult() {
        return getWebDriver().findElements(lblTilesMainResult);
    }

    private List<WebElement> titlesVideoSection() {
        return getWebDriver().findElements(lblTitlesVideoSection);
    }

    private List<WebElement> titlesPeopleAsk() {
        return BrowserHelper.getWebDriver().findElements(lblTitlesPeopleAsk);
    }

    //Method
    public boolean verifyMainResult(String value) {
        return isAllTitlesContainValue(titlesMainResult(), value);
    }

    public boolean verifyVideoSections(String value) { return isAllTitlesContainValue(titlesVideoSection(), value); }

    public boolean verifyTitlesPeopleAsk(String value) {
        return isAllTitlesContainValue(titlesPeopleAsk(), value);
    }

}
