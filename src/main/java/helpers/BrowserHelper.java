package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;
import utilities.Log;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                Log.info("------------------------------- OPEN CHROME DRIVER -------------------------------");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                Log.info("------------------------------- OPEN FIREFOX DRIVER -------------------------------");
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                Log.info("------------------------------- OPEN EDGE DRIVER ----------------------------------");
                driver = new EdgeDriver();
                break;
            default:
                Log.error("[startBrowser] No browser passed throw exception");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIME_WAITS_DRIVER, TimeUnit.SECONDS);
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement getElement(By element){
       return driver.findElement(element);
    }

}