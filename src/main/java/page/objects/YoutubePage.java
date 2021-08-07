package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static helpers.BrowserHelper.*;

public class YoutubePage extends BasePage {

    //Selector
    private By _firstVideo = By.xpath("//h3[@class='LC20lb MMgsKf']");
    private By _playButton = By.xpath("//button[@title='Play (k)']");
    private By _pauseButton = By.xpath("//button[@title='Pause (k)']");
    private By _titleVideo = By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']");
    private By _body = By.tagName("body");

    //Element
    private WebElement firstVideo() {
        return getWebDriver().findElement(_firstVideo);
    }

    private WebElement playButton() {
        return getWebDriver().findElement(_playButton);
    }

    private WebElement pauseButton() {
        return getWebDriver().findElement(_pauseButton);
    }

    private WebElement titleVideo() {
        return getWebDriver().findElement(_titleVideo);
    }

    private WebElement body() {
        return getWebDriver().findElement(_body);
    }

    //Method
    public void clickToFirstVideo() {
        firstVideo().click();
    }


    public void playAndPauseVideo(int time) {
        playButton().click();
        waitForElement(pauseButton(), time);
        body().sendKeys(Keys.SPACE);
    }

    public boolean verifyTitleVideo(String value) {
        return titleVideo().getText().toLowerCase().contains(value.toLowerCase());
    }

    public boolean verifyVideoPlayInTime() {
        return playButton().isDisplayed();
    }

}
