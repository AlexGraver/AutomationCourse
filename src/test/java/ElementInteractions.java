import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElementInteractions {

    //======================================Locators======================================================//
    //-----------------------Should be removed to separate pages in future--------------------------------//
    //====================================================================================================//

    //-------------------------------------WebFormPage-----------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final By DATE_PICKER = By.xpath("//input[@name=\"my-date\"]");
    private static final By DAY_OPTIONS = By.xpath("//*[@class=\"day\"]");
    private static final By MONTH_OPTIONS = By.xpath("//span[contains(@class, \"month\")]");

    private static final By YEAR_LEVEL = By.xpath("(//th[@class=\"datepicker-switch\"])[1]");
    private static final By YEAR_LEVEL_PREV = By.xpath("(//th[@class=\"prev\"])[2]");
    private static final By YEAR_LEVEL_NEXT = By.xpath("(//th[@class=\"next\"])[2]");

    private static final By DECADE_LEVEL = By.xpath("(//th[@class=\"datepicker-switch\"])[2]");
    private static final By DECADE_LEVEL_PREV = By.xpath("(//th[@class=\"prev\"])[3]");
    private static final By DECADE_LEVEL_NEXT = By.xpath("(//th[@class=\"next\"])[3]");

    private static final By CENTURY_LEVEL = By.xpath("(//th[@class=\"datepicker-switch\"])[3]");
    private static final By CENTURY_LEVEL_PREV = By.xpath("(//th[@class=\"prev\"])[4]");
    private static final By CENTURY_LEVEL_NEXT = By.xpath("(//th[@class=\"next\"])[4]");

    private static final By EXAMPLE_RANGE = By.xpath("//input[@name=\"my-range\"]");
    private static final By RETURN_FROM_WEB_FORM = By.xpath("//a[@href=\"./index.html\"]");
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    //-------------------------------------NavigationPage--------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
    private static final By HEADER_NAVIGATION = By.xpath("//h1[@class=\"display-6\"]");
    private static final By BACK_TO_INDEX = By.xpath("//a[@href=\"index.html\"]");
    private static final By PAGINATION_ABSTRACT_ELEMENT = By.xpath("//li[contains(@class, \"page-item\")]");
    private static final By PAGINATION_PREVIOUS = By.xpath("//a[contains(@class, \"page-link\") and text() = \"Previous\"]");
    private static final By PAGINATION_NEXT = By.xpath("//a[contains(@class, \"page-link\") and text() = \"Next\"]");
    private static final By PAGINATION_PAGE_1 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"1\"]");
    private static final By PAGINATION_PAGE_2 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"2\"]");
    private static final By PAGINATION_PAGE_3 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"3\"]");

    //-------------------------------------DropDownMenuPage------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
    private static final By HEADER_DROPDOWN = By.xpath("//h1[@class=\"display-6\"]");
    private static final By LEFT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-1\"]");
    private static final By RIGHT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-2\"]");
    private static final By RIGHT_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-2\"]");
    private static final By DOUBLE_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-3\"]");
    private static final By DOUBLE_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-3\"]");

    //-------------------------------------DragAndDropPage-------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
    private static final By HEADER_DRAG_DROP = By.xpath("//h1[@class=\"display-6\"]");
    private static final By DRAG_FROM = By.xpath("//div[@id=\"draggable\"]");
    private static final By DROP_TO = By.xpath("//div[@id=\"target\"]");



    //====================================================================================================//
    //----------------------------------Global variables and methods--------------------------------------//
    //====================================================================================================//
     private static WebDriver driver;
     private static Actions actions;
     //private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";


     boolean correctPageIsOpened(By header, String expected){
        String actual = driver.findElement(header).getText();
        if(actual.equals(expected)){
            return true;
        }else{
            return false;
        }
    }

    static void openPage(String url){
        driver.get(url);
    }



    //====================================================================================================//
    //--------------------------------------InteractionTests----------------------------------------------//
    //====================================================================================================//

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }


    //-------------------------------------WebFormPage-----------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
    @Test
    void openWebFormPagePageTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        Assertions.assertTrue(correctPageIsOpened(HEADER_WEB_FORM, "Web form"));
    }

    @Test
    void inputTextTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
         String textToEnter = "MyCustomText";
         WebElement textField = driver.findElement(TEXT_INPUT);
         String defaultText = textField.getDomProperty("defaultValue");
         if(!(defaultText.equals(""))){
             textField.clear();
         }else{
             textField.sendKeys(textToEnter);
             submitFormAndReturn();
         }
         textField = driver.findElement(TEXT_INPUT);
         Assertions.assertEquals(textToEnter, textField.getDomProperty("value"));
    }

    @Test
    void passwordFieldTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        String passToEnter = "MyPass123";
        WebElement textField = driver.findElement(PASSWORD);
        String defaultText = textField.getDomProperty("defaultValue");
        if(!(defaultText.equals(""))){
            textField.clear();
        }else{
            textField.sendKeys(passToEnter);
            submitFormAndReturn();
        }
        textField = driver.findElement(PASSWORD);
        Assertions.assertEquals(passToEnter, textField.getDomProperty("value"));
    }

    @Test
    void textAreaTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        String passToEnter = "TextAreaCompleted";
        WebElement textField = driver.findElement(TEXT_AREA);
        String defaultText = textField.getDomProperty("defaultValue");
        if(!(defaultText.equals(""))){
            textField.clear();
        }else{
            textField.sendKeys(passToEnter);
            submitFormAndReturn();
        }
        Assertions.assertEquals(passToEnter, textField.getDomProperty("value"));
    }

    @Test
    void returnToHomePageTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.findElement(RETURN_FROM_WEB_FORM).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", driver.getCurrentUrl());
    }

    @Test
    void disabledInputTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
         Assertions.assertThrows(ElementNotInteractableException.class, ()-> driver.findElement(DISABLED_INPUT).sendKeys("AnyKey"));
    }

    @Test
    void readOnlyInputTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        String currentText = driver.findElement(READONLY_INPUT).getDomProperty("value");
        driver.findElement(READONLY_INPUT).sendKeys("AnyKey");
        submitFormAndReturn();
        String updatedText = driver.findElement(READONLY_INPUT).getDomProperty("value");
        Assertions.assertEquals(currentText, updatedText);
    }

    @Test
    void selectDropdownTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        Select select = new Select(driver.findElement(DROPDOWN_SELECT));
        assertAll(
                () -> assertEquals("Open this select menu", select.getFirstSelectedOption().getText()),
                () -> {
                    select.selectByIndex(1);
                    assertEquals("One", select.getFirstSelectedOption().getText());
                },
                () -> {
                    select.selectByValue("2");
                    assertEquals("Two", select.getFirstSelectedOption().getText());
                }
        );
    }

    @Test
    void dataListDropdownTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement datalist = driver.findElement(DROPDOWN_DATA_LIST);
        datalist.sendKeys("New");
        actions.sendKeys(datalist, Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        submitFormAndReturn();
        Assertions.assertEquals("New York", datalist.getDomProperty("value"));
    }

    @Test
    void fileInputTest(){
        boolean notImplemented = true;
        Assertions.assertFalse(notImplemented, "Not implemented");
    }

    @Test
    void checkedCheckBoxTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement box = driver.findElement(CHECKED_CHECKBOX);
        Assertions.assertTrue(box.isSelected(), "Precondition should be true");
        box.click();
        Assertions.assertFalse(box.isSelected(), "Result should be false");
    }

    @Test
    void uncheckedCheckBoxTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement box = driver.findElement(DEFAULT_CHECKBOX);
        Assertions.assertFalse(box.isSelected(), "Precondition should be true");
        box.click();
        Assertions.assertTrue(box.isSelected(), "Result should be true");
    }

    @Test
    void radioButtonTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement radioChecked = driver.findElement(CHECKED_RADIO);
        WebElement radioUnchecked = driver.findElement(DEFAULT_RADIO);
        Assertions.assertTrue(radioChecked.isSelected(), "Precondition should be true");
        Assertions.assertFalse(radioUnchecked.isSelected(), "Precondition should be false");

        radioUnchecked.click();

        Assertions.assertFalse(radioChecked.isSelected(), "Result should be false");
        Assertions.assertTrue(radioUnchecked.isSelected(), "Result should be true");
    }

    @Test
    void colorPickerTest(){
        boolean notImplemented = true;
        Assertions.assertFalse(notImplemented, "Not implemented");


    }

    @Test
    void datePickerTest(){
        boolean notImplemented = true;
        Assertions.assertFalse(notImplemented, "Not implemented");
    }

    @Test
    void exampleRageTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement range = driver.findElement(EXAMPLE_RANGE);
        String startValue = range.getDomProperty("value");

        actions.clickAndHold(driver.findElement(EXAMPLE_RANGE))
                .moveByOffset(50, 0)
                .release()
                .perform();
        String endValue = range.getDomProperty("value");
        Assertions.assertTrue(Integer.parseInt(endValue) > Integer.parseInt(startValue));

        actions.clickAndHold(driver.findElement(EXAMPLE_RANGE))
                .moveByOffset(- 100, 0)
                .release()
                .perform();
        endValue = range.getDomProperty("value");
        Assertions.assertTrue(Integer.parseInt(endValue) < Integer.parseInt(startValue));

    }

    void submitFormAndReturn(){
         driver.findElement(SUBMIT).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
    }

    void selectYear(){

    }
    void selectMonth(){

    }

    void selectDay(String day){
        List<WebElement> days = driver.findElements(DAY_OPTIONS);
        int dayCount = Integer.parseInt(day);
        if(dayCount > days.size() || dayCount < days.size()){
            throw new IllegalArgumentException("Current month doesn't have such date");
        }
        for(WebElement d: days){
            if(d.getText().equals(day)){
                d.click();
                break;
            }else{
                
            }
        }
    }





    //-------------------------------------NavigationPage--------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//

    @Test
    void openNavigationPageTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");
         Assertions.assertTrue(correctPageIsOpened(HEADER_NAVIGATION, "Navigation example"));
    }

    @Test
    void paginationNavigationTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");

        int activePageBeforeNext = checkActivePage();
        clickNext();
        int activePageAfterNext = checkActivePage();
        Assertions.assertEquals(activePageAfterNext, activePageBeforeNext + 1);

        int activePageBeforePrevious = checkActivePage();
        clickPrevios();
        int activePageAfterPrevious = checkActivePage();
        Assertions.assertEquals(activePageBeforePrevious -1, activePageAfterPrevious);
    }

    @Test
    void goToHomePageTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");
         driver.findElement(BACK_TO_INDEX).click();
         Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", driver.getCurrentUrl());
    }


    void clickNext(){
        if(buttonIsEnabled(PAGINATION_NEXT)){
            driver.findElement(PAGINATION_NEXT).click();
        }else{
            System.err.println("Button is Disabled");
        }
    }

    void clickPrevios(){
        if(buttonIsEnabled(PAGINATION_PREVIOUS)){
            driver.findElement(PAGINATION_PREVIOUS).click();
        }else{
            System.err.println("Button is Disabled");
        }
    }


    private int checkActivePage(){
        List<WebElement> pagination_elements = driver.findElements(PAGINATION_ABSTRACT_ELEMENT);
        int elementNumber = -1;
        for(WebElement element: pagination_elements){
            if(element.getDomProperty("className").contains("active")){
                elementNumber = Integer.parseInt(element.getDomProperty("innerText"));
            }
        }
        return elementNumber;
    }

    private boolean buttonIsEnabled(By element){
        WebElement parent = driver.findElement(element).findElement(By.xpath(".."));
        if(parent.getDomProperty("className").contains("disabled")){
            return false;
        }else{
            return true;
        }
    }

    //-------------------------------------DropDownMenuPage------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//
    @Test
    void leftClickTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
         WebElement leftClickMenu = driver.findElement(LEFT_CLICK_MENU);
         actions.click(leftClickMenu).perform();
         String isExpanded = leftClickMenu.getDomProperty("ariaExpanded");
         Assertions.assertTrue(isExpanded.equalsIgnoreCase("true"), "Should be expanded");
    }

    @Test
    void  rightClickTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        WebElement rightClickMenu = driver.findElement(RIGHT_CLICK_MENU);
        WebElement context = driver.findElement(RIGHT_CLICK_CONTEXT_MENU);
        String style = context.getDomProperty("style");
        Assertions.assertTrue(style.equalsIgnoreCase("[]"));
        actions.contextClick(rightClickMenu).perform();
        style = context.getDomProperty("style");
        Assertions.assertTrue(style.equalsIgnoreCase("[display]"));
    }

    @Test
    void doubleClickTest(){
        openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        WebElement doubleClickMenu = driver.findElement(DOUBLE_CLICK_MENU);
        WebElement context = driver.findElement(DOUBLE_CLICK_CONTEXT_MENU);
        String style = context.getDomProperty("style");
        Assertions.assertTrue(style.equalsIgnoreCase("[]"));
        actions.doubleClick(doubleClickMenu).perform();
        style = context.getDomProperty("style");
        Assertions.assertTrue(style.equalsIgnoreCase("[display]"));
    }

    //-------------------------------------DragAndDropPage-------------------------------------------------//
    //-----------------------------------------------------------------------------------------------------//

    @Test
    void dragAndDropTest(){
         openPage("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
         WebElement source = driver.findElement(DRAG_FROM);
         WebElement target = driver.findElement(DROP_TO);
         actions.dragAndDrop(source, target).perform();
         Point locationSource = source.getLocation();
         Point locationTarget = target.getLocation();
         Assertions.assertEquals(locationSource, locationTarget);
    }




    @AfterAll
    static void tearDown(){
         driver.quit();
    }
}
