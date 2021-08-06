package page.objects;

import static helpers.BrowserHelper.getWebDriver;
import static helpers.BrowserHelper.waitToBeClick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YoutubePage extends BasePage {

    //Selector
    private By _firstVideo = By.xpath("//h3[@class='LC20lb MMgsKf']");
    private By _playButton = By.xpath("//button[@title='Play (k)']");
    private By _pauseButton = By.xpath("//button[@title='Pause (k)']");
    private By _titleVideo = By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']");

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

    //Method
    public void clickToFirstVideo() {
        firstVideo().click();
    }

    public void playAndPauseVideo(int time) {
        playButton().click();
        waitToBeClick(pauseButton(), time);
    }

    public boolean verifyTitleVideo(String value) {
        return titleVideo().getText().toLowerCase().contains(value.toLowerCase());
    }


}
