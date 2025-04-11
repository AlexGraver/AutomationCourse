import core.configs.Configs;
import core.driver.TestDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.webFormPage.WebFormPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormPageTest extends BaseTest{

    WebFormPage webFormPage;
    Configs configs = ConfigFactory.create(Configs.class);

    @BeforeEach
    void setUp(){
        webFormPage = initUiTest().openWebFormTab();
    }

    @Test
    void openWebFormPagePageTest(){
        Assertions.assertTrue(webFormPage.pageIsOpened());
    }

    @Test
    void inputTextTest(){
        String textToEnter = "MyCustomText";
        webFormPage.fillInputTextField(textToEnter);
        webFormPage.submitFormAndReturn();
        String textField = webFormPage.getInputTextValue();

        assertEquals(textToEnter, textField);
    }

    @Test
    void passwordFieldTest(){
        String passToEnter = "MyPass123";
        webFormPage.fillPasswordField(passToEnter);
        webFormPage.submitFormAndReturn();
        String textField = webFormPage.getPassword();

        assertEquals(passToEnter, textField);
    }

    @Test
    void textAreaTest(){
        String textAreaText = "TextAreaCompleted";
        webFormPage.fillTextArea(textAreaText);
        webFormPage.submitFormAndReturn();

        assertEquals(textAreaText, webFormPage.getTextAreaValue());
    }

    @Test
    void returnToHomePageTest(){
        webFormPage.goToHomePage();

        assertEquals(configs.baseUrl(), TestDriver.getDriver().getCurrentUrl());
    }

    @Test
    void disabledInputTest(){
        Assertions.assertThrows(ElementNotInteractableException.class, ()-> webFormPage.trySendKeys());
    }

    @Test
    void readOnlyInputTest(){
        String currentText = webFormPage.getReadOnlyValue();
        webFormPage.trySendKeys();
        webFormPage.submitFormAndReturn();
        String updatedText = webFormPage.getReadOnlyValue();
        assertEquals(currentText, updatedText);
    }

    @Test
    void selectDropdownTest(){
        Select select = webFormPage.getSelectDropdown();


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
        WebElement datalist = webFormPage.getDataList();
        datalist.sendKeys("New");
        webFormPage.clickKeyBoardButton(Keys.ARROW_DOWN);
        webFormPage.clickKeyBoardButton(Keys.ENTER);
        webFormPage.submitFormAndReturn();
        assertEquals("New York", datalist.getDomProperty("value"));
    }

    @Test
    void fileInputTest(){
        boolean notImplemented = true;
        Assertions.assertFalse(notImplemented, "Not implemented");
    }

    @Test
    void checkedCheckBoxTest(){
        boolean checkedCheckboxSelected = webFormPage.checkedCheckboxIsSelected();
        Assertions.assertTrue(checkedCheckboxSelected, "Precondition should be true");
        webFormPage.clickCheckedCheckbox();
        Assertions.assertFalse(checkedCheckboxSelected, "Result should be false");
    }

    @Test
    void uncheckedCheckBoxTest(){
        boolean defaultCheckboxSelected = webFormPage.defaultCheckboxIsSelected();
        Assertions.assertFalse(defaultCheckboxSelected, "Precondition should be true");
        webFormPage.clickDefaultCheckbox();
        Assertions.assertTrue(defaultCheckboxSelected, "Result should be true");
    }

    @Test
    void radioButtonTest(){

        boolean radioChecked = webFormPage.checkedRadioIsSelected();
        boolean radioUnchecked = webFormPage.checkedDefaultIsSelected();

        Assertions.assertTrue(radioChecked, "Precondition should be true");
        Assertions.assertFalse(radioUnchecked, "Precondition should be false");

        webFormPage.clickCheckedRadio();

        Assertions.assertFalse(radioChecked, "Result should be false");
        Assertions.assertTrue(radioUnchecked, "Result should be true");
    }

    @Test
    void colorPickerTest(){
        boolean notImplemented = true;
        Assertions.assertFalse(notImplemented, "Not implemented");
    }

    @Test
    void exampleRageTest(){
        String startValue = webFormPage.getRangeValue();
        webFormPage.moveRangePicker(50, 0);
        String endValue = webFormPage.getRangeValue();

        Assertions.assertTrue(Integer.parseInt(endValue) > Integer.parseInt(startValue));

        webFormPage.moveRangePicker(-100, 0);
        endValue = webFormPage.getRangeValue();

        Assertions.assertTrue(Integer.parseInt(endValue) < Integer.parseInt(startValue));

    }


}
