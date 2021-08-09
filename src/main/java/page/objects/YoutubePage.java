package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static helpers.BrowserHelper.*;

public class YoutubePage extends BasePage {

    //Selector
    private By lblFirstVideo = By.xpath("//h3[@class='LC20lb MMgsKf']");
    private By btnPlay = By.xpath("//button[@title='Play (k)']");
    private By btnPause = By.xpath("//button[@title='Pause (k)']");
    private By lblTitleVideo = By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']");
    private By bdPlayerContent = By.tagName("body");
    private By videoContainer = By.xpath("//div[@class='html5-video-container']");

    //Method
    public void clickToFirstVideo() {
        getElement(lblFirstVideo).click();
    }

    public void playAndPauseVideo(int time) {
        getElement(btnPlay).click();
        waitForElement(getElement(btnPause),time);
        hoverToElement(getElement(videoContainer));
        getElement(bdPlayerContent).sendKeys(Keys.SPACE);
    }

    public boolean verifyTitleVideo(String value) {
        return getElement(lblTitleVideo).getText().toLowerCase().contains(value.toLowerCase());
    }

    public boolean verifyVideoPlayInTime() {
        return getElement(btnPlay).isDisplayed();
    }

}
