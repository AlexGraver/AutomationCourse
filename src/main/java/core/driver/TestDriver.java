package core.driver;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import core.configs.Configs;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class TestDriver {
    private static WebDriver driver;
    private static Configs configs = ConfigFactory.create(Configs.class);

    //private singleton constructor
    private TestDriver(){}

    public static WebDriver getDriver() {
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
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
