package core.driver;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import core.configs.Configs;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class TestDriver {

    public static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static WebDriver driver;
    private static final Configs configs = ConfigFactory.create(Configs.class);
    private static String remoteUrl;

    //private singleton constructor
    private TestDriver(){}

    public static WebDriver getDriver() {
        remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        log.info("Using SELENIUM_REMOTE_URL: {}", remoteUrl);
        if(driver == null){
            if(remoteUrl != null){
                driver = getRemoteDriver();
            }else{
                driver = getLocalDrover();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(configs.implicitWait()));
        return driver;
    }


    private static WebDriver getRemoteDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
        log.info("Options are created");
        try {
            driver = new RemoteWebDriver(new URL(remoteUrl), options);
            log.info("RemoteWebDriver initialized: {}", driver.getClass().getName());
        } catch (Exception e) {
            throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
        }
        return driver;
    }

    private static WebDriver getLocalDrover(){
        switch (configs.browser()) {
            case "win_chrome":
                driver = new ChromeDriver();
                break;
            case "win_edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + configs.browser());
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
