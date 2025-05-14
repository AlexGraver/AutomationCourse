package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadFilesPage extends BasePage {

    public DownloadFilesPage(WebDriver driver) {
        super(driver);
    }

    public static final By WEB_DRIVER_LOGO = By.xpath("//a[@href=\"./docs/webdrivermanager.png\"]");
    public static final By WEB_DRIVER_DOC = By.xpath("//a[@href=\"./docs/webdrivermanager.pdf\"]");
    public static final By SELENIUM_LOGO = By.xpath("//a[@href=\"./docs/selenium-jupiter.png\"]");
    public static final By SELENIUM_DOC = By.xpath("//a[@href=\"./docs/selenium-jupiter.pdf\"]");


}
