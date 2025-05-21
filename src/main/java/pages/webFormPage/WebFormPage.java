package pages.webFormPage;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WebFormPage extends BasePage {

    public WebFormPage(WebDriver driver){
        super(driver);
    }

    private static final By HEADER_WEB_FORM = By.xpath("//h1[@class=\"display-6\"]");
    private static final By PAGE_NAME = By.xpath("//h1[@class=\"display-6\"]");
    private static final By TEXT_INPUT = By.xpath("//input[@id=\"my-text-id\"]");
    private static final By PASSWORD = By.xpath("//input[@name=\"my-password\"]");
    private static final By TEXT_AREA = By.xpath("//textarea[@name=\"my-textarea\"]");
    private static final By DISABLED_INPUT = By.xpath("//input[@name=\"my-disabled\"]");
    private static final By READONLY_INPUT = By.xpath("//input[@name=\"my-readonly\"]");
    private static final By DROPDOWN_SELECT = By.xpath("//select[@name=\"my-select\"]");
    private static final By DROPDOWN_DATA_LIST = By.xpath("//input[@name=\"my-datalist\"]");
    private static final By FILE_INPUT = By.xpath("//input[@name=\"my-file\"]");
    private static final By CHECKED_CHECKBOX = By.xpath("//input[@id=\"my-check-1\"]");
    private static final By DEFAULT_CHECKBOX = By.xpath("//input[@id=\"my-check-2\"]");
    private static final By CHECKED_RADIO = By.xpath("//input[@id=\"my-radio-1\"]");
    private static final By DEFAULT_RADIO = By.xpath("//input[@id=\"my-radio-2\"]");
    private static final By SUBMIT = By.xpath("//button[@type=\"submit\"]");
    private static final By COLOR_PICKER = By.xpath("//input[@name=\"my-colors\"]");
    private static final By EXAMPLE_RANGE = By.xpath("//input[@name=\"my-range\"]");
    private static final By RETURN_FROM_WEB_FORM = By.xpath("//a[@href=\"./index.html\"]");
    private static final By UPLOAD_FILE = By.xpath("//input[@name = \"my-file\"]");

    public void submitFormAndReturn(){
        findElement(SUBMIT).click();
        sleep(1000);
        navigateBack();
    }

    public void submitForm(){
        findElement(SUBMIT).click();
        sleep(1000);
    }

    public void uploadFile(String filePath) throws IOException {
        List<String> pathParts =  Arrays.asList(filePath.split("/"));
        String fileName = pathParts.get(pathParts.size() -1);
        URL url = WebFormPage.class.getClassLoader().getResource(fileName);
        String absolutePath;
        if (url != null) {
            absolutePath = new File(url.getPath()).getAbsolutePath();
            System.out.println("Absolute file path: " + absolutePath);
        } else {
            System.out.println("Resource not found");
        }
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println("File content: " + content);
        findElement(UPLOAD_FILE).sendKeys(new File(filePath).getAbsolutePath());
    }

    public boolean pageIsOpened(){
        String actual = findElement(HEADER_WEB_FORM).getText();
        return actual.equals("Web form");
    }

    public void fillInputTextField(String text){
        setTextInToElement(TEXT_INPUT, text);
    }

    public String getInputTextValue(){
        return getDomProperty(TEXT_INPUT, "value");
    }

    public void fillPasswordField(String pass){
        setTextInToElement(PASSWORD, pass);
    }

    public String getPassword(){
        return getDomProperty(PASSWORD, "value");
    }

    public HomePage goToHomePage(){
        findElement(RETURN_FROM_WEB_FORM).click();
        return new HomePage(driver);
    }

    public void moveRangePicker(int horizontal, int vertical){
        mouseClickAndMove(EXAMPLE_RANGE, horizontal, vertical);
    }

    public String getRangeValue(){
        return getDomProperty(EXAMPLE_RANGE, "value");
    }

    public void fillTextArea(String text){
        setTextInToElement(TEXT_AREA, text);
    }

    public String getTextAreaValue(){
        return getDomProperty(TEXT_AREA, "value");
    }

    public void trySendKeys(){
        setTextInToElement(DISABLED_INPUT, "Any key");
        setTextInToElement(READONLY_INPUT, "Any key");
    }

    public String getReadOnlyValue(){
        return getDomProperty(READONLY_INPUT, "value");
    }

    public Select getSelectDropdown(){
        return new Select(findElement(DROPDOWN_SELECT));
    }

    public WebElement getDataList(){
        return findElement(DROPDOWN_DATA_LIST);
    }

    public void clickCheckedCheckbox(){
        waitUntilElementClickable(CHECKED_CHECKBOX).click();
    }

    public boolean checkedCheckboxIsSelected(){
        return findElement(CHECKED_CHECKBOX).isSelected();
    }

    public void clickDefaultCheckbox(){
        waitUntilElementClickable(DEFAULT_CHECKBOX).click();
    }

    public boolean defaultCheckboxIsSelected(){
        return findElement(DEFAULT_CHECKBOX).isSelected();
    }

    public void clickCheckedRadio(){
        findElement(CHECKED_RADIO).click();
    }

    public boolean checkedRadioIsSelected(){
        return findElement(CHECKED_RADIO).isSelected();
    }

    public void clickUncheckedRadio(){
        findElement(DEFAULT_RADIO).click();
    }

    public boolean checkedDefaultIsSelected(){
        return findElement(DEFAULT_RADIO).isSelected();
    }

}
