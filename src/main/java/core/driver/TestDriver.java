package core.driver;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import core.configs.Configs;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class TestDriver {
    private static WebDriver driver;
    private static Configs configs = ConfigFactory.create(Configs.class);

    //private singleton constructor
    private TestDriver(){}

    public static WebDriver getDriver() {
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");
        System.out.println("Using SELENIUM_REMOTE_URL: " + remoteUrl);

        if(remoteUrl != null && !remoteUrl.isEmpty()){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), options);
                System.out.println("RemoteWebDriver initialized: " + (driver != null));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed URL for Selenium Remote WebDriver", e);
            }
        }else{
            if(driver == null){
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
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(configs.implicitWait()));
            }
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
