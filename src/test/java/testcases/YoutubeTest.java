package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.YoutubePage;
import utilities.Constants;
import utilities.Log;

public class YoutubeTest extends BaseTest{

    @Test
    public void Scenario02(){
        YoutubePage youtubePage = new YoutubePage();

        Log.info("Go to google page");

        Log.info("Search for Heal The World");
        youtubePage.search(Constants.KEY_WORLD);

        Log.info("Click on the first Video");
        youtubePage.clickToFirstVideo();

        Log.info("Play and Pause video 10");
        youtubePage.playAndPauseVideo(Constants.TIME_WAITS_PAUSE);

        Log.info("Verify title video is  same to Google result");
        Assert.assertTrue(youtubePage.verifyTitleVideo(Constants.KEY_WORLD));

        Log.info("Verify video play and pause correctly");
        Assert.assertTrue(youtubePage.verifyVideoPlayInTime(),"Video play and pause incorrectly");
    }
}
