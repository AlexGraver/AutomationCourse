package pages.webFormPage;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {

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

}
