package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.*;

public class YoutubePage extends BasePage {

    //Selector
    private By lblFirstVideo = By.xpath("//h3[@class='LC20lb MMgsKf']");
    private By btnPlay = By.xpath("//button[@title='Play (k)']");
    private By btnPause = By.xpath("//button[@title='Pause (k)']");
    private By lblTitleVideo = By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']");
    private By bdPlayerContent = By.tagName("body");

    //Element
    private WebElement firstVideo() {
        return getWebDriver().findElement(lblFirstVideo);
    }

    private WebElement buttonPlay() {
        return getWebDriver().findElement(btnPlay);
    }

    private WebElement buttonPause() {
        return getWebDriver().findElement(btnPause);
    }

    private WebElement titleVideo() {
        return getWebDriver().findElement(lblTitleVideo);
    }

    private WebElement bodyPlayerContent() {
        return getWebDriver().findElement(bdPlayerContent);
    }

    //Method
    public void clickToFirstVideo() {
        firstVideo().click();
    }


    public void playAndPauseVideo(int time) {
        buttonPlay().click();
        waitForElement(buttonPause(), time);
        bodyPlayerContent().sendKeys(Keys.SPACE);
    }

    public boolean verifyTitleVideo(String value) {
        return titleVideo().getText().toLowerCase().contains(value.toLowerCase());
    }

    public boolean verifyVideoPlayInTime() {
        return buttonPlay().isDisplayed();
    }

}
