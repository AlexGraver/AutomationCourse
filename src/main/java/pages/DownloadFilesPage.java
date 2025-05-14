package pages;

import core.BasePage;
import core.helpers.AllureHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class DownloadFilesPage extends BasePage {

    AllureHelper allureHelper = new AllureHelper();

    public DownloadFilesPage(WebDriver driver) {
        super(driver);
    }

    public static final By WEB_DRIVER_LOGO = By.xpath("//a[@href=\"./docs/webdrivermanager.png\"]");
    public static final By WEB_DRIVER_DOC = By.xpath("//a[@href=\"./docs/webdrivermanager.pdf\"]");
    public static final By SELENIUM_LOGO = By.xpath("//a[@href=\"./docs/selenium-jupiter.png\"]");
    public static final By SELENIUM_DOC = By.xpath("//a[@href=\"./docs/selenium-jupiter.pdf\"]");

    private File downloadFileInCoreDirectoryWithName(By locator, String name) throws IOException {
        File file = new File(".", name);
        WebElement element = findElement(locator);
        allureHelper.download(element.getDomProperty("href"), file);
        return file;
    }

    public File downloadDriverLogo() throws IOException {
        return downloadFileInCoreDirectoryWithName(WEB_DRIVER_LOGO, "driver_logo.png");
    }

    public File downloadDriverDoc() throws IOException {
        return downloadFileInCoreDirectoryWithName(WEB_DRIVER_DOC, "driver_doc.pdf");
    }

    public File downloadSeleniumLogo() throws IOException {
        return downloadFileInCoreDirectoryWithName(SELENIUM_LOGO, "selenium_logo.png");
    }

    public File downloadSeleniumDoc() throws IOException {
        return downloadFileInCoreDirectoryWithName(SELENIUM_DOC, "selenium_doc.pdf");
    }

}
