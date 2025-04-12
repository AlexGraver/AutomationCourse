package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.webFormPage.WebFormPage;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    List<WebElement> elements;
    private final By CHAPTER_3_BLOCK = By.xpath("//h5[@class=\"card-title\" and text() = \"Chapter 3. WebDriver Fundamentals\"]");
    private final By CHAPTER_BLOCK_CONTENT = By.xpath(".//a[@class=\"btn btn-outline-primary mb-2\"]");
    private final By HEADER = By.xpath("//h1[contains (@class, \"display-6\")]");

    public WebFormPage openWebFormTab() {
        findElement(By.xpath(getElementXpathByOrder(1))).click();
        return new WebFormPage(driver);
    }

    public NavigationPage openNavigationTab() {
        findElement(By.xpath(getElementXpathByOrder(2))).click();
        return new NavigationPage(driver);
    }

    public DropdownMenuPage openDropdownMenuTab() {
        findElement(By.xpath(getElementXpathByOrder(3))).click();
        return new DropdownMenuPage(driver);
    }
//
//    public MouseOverPage openMouseOverTab() {
//        findElement(By.xpath(getElementXpathByOrder(4)));
//        return new MouseOverPage(driver);
//    }
//
    public DragAndDropPage openDragAndDropTab() {
        findElement(By.xpath(getElementXpathByOrder(5))).click();
        return new DragAndDropPage(driver);
    }
//
//    public DrawInCanvasPage openDrawInCanvasTab() {
//        findElement(By.xpath(getElementXpathByOrder(6)));
//        return new DrawInCanvasPage(driver);
//    }
//
//    public LoadingImagesPage openLoadingImagesTab() {
//        findElement(By.xpath(getElementXpathByOrder(7)));
//        return new LoadingImagesPage(driver);
//    }
//
//    public SlowCalculatorPage openSlowCalculatorTab() {
//        findElement(By.xpath(getElementXpathByOrder(8)));
//        return new SlowCalculatorPage(driver);
//    }
//
//    public LongPage openLongPageTab() {
//        findElement(By.xpath(getElementXpathByOrder(9)));
//        return new LongPage(driver);
//    }
//
//    public InfiniteScrollPage openInfiniteScrollTab() {
//        findElement(By.xpath(getElementXpathByOrder(10)));
//        return new InfiniteScrollPage(driver);
//    }
//
//    public ShadowDomPage openShadowDomTab() {
//        findElement(By.xpath(getElementXpathByOrder(11)));
//        return new ShadowDomPage(driver);
//    }
//
//    public CookiesPage openCookiesTab() {
//        findElement(By.xpath(getElementXpathByOrder(12)));
//        return new CookiesPage(driver);
//    }
//
//    public FramesPage openFramesTab() {
//        findElement(By.xpath(getElementXpathByOrder(13)));
//        return new FramesPage(driver);
//    }
//
//    public IframesPage openIframesTab() {
//        findElement(By.xpath(getElementXpathByOrder(14)));
//        return new IframesPage(driver);
//    }
//
    public DialogBoxesPage openDialogBoxesTab() {
        findElement(By.xpath(getElementXpathByOrder(15)));
        return new DialogBoxesPage(driver);
    }
//
//    public WebStoragePage openWebStorageTab() {
//        findElement(By.xpath(getElementXpathByOrder(16)));
//        return new WebStoragePage(driver);
//    }
//
//    public GeolocationPage openGeolocationTab() {
//        findElement(By.xpath(getElementXpathByOrder(17)));
//        return new GeolocationPage(driver);
//    }
//
//    public NotificationsPage openNotificationsTab() {
//        findElement(By.xpath(getElementXpathByOrder(18)));
//        return new NotificationsPage(driver);
//    }
//
//    public GetUserMediaPage openGetUserMediaTab() {
//        findElement(By.xpath(getElementXpathByOrder(19)));
//        return new GetUserMediaPage(driver);
//    }
//
//    public MultilanguagePage openMultilanguagePageTab() {
//        findElement(By.xpath(getElementXpathByOrder(20)));
//        return new MultilanguagePage(driver);
//    }
//
//    public ConsoleLogsPage openConsoleLogsTab() {
//        findElement(By.xpath(getElementXpathByOrder(21)));
//        return new ConsoleLogsPage(driver);
//    }
//
//    public LoginFormPage openLoginFormTab() {
//        findElement(By.xpath(getElementXpathByOrder(22)));
//        return new LoginFormPage(driver);
//    }
//
//    public SlowLoginFormPage openSlowLoginFormTab() {
//        findElement(By.xpath(getElementXpathByOrder(23)));
//        return new SlowLoginFormPage(driver);
//    }
//
//    public RandomCalculatorPage openRandomCalculatorTab() {
//        findElement(By.xpath(getElementXpathByOrder(24)));
//        return new RandomCalculatorPage(driver);
//    }
//
//    public DownloadFilesPage openDownloadFilesTab() {
//        findElement(By.xpath(getElementXpathByOrder(25)));
//        return new DownloadFilesPage(driver);
//    }
//
//    public AbTestingPage openAbTestingTab() {
//        findElement(By.xpath(getElementXpathByOrder(26)));
//        return new AbTestingPage(driver);
//    }
//
//    public DataTypesPage openDataTypesTab() {
//        findElement(By.xpath(getElementXpathByOrder(27)));
//        return new DataTypesPage(driver);
//    }






    private String getElementXpathByOrder(int order){
            String locatorXpath = CHAPTER_BLOCK_CONTENT.toString().replace("By.xpath: ", "");
            return   "("+locatorXpath+")["+String.valueOf(order)+"]";
    }

}
