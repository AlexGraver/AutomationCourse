package ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import pages.DialogBoxesPage;

public class DialogBoxesPageTest extends BaseTest {

    DialogBoxesPage dialogBoxesPage;

    @BeforeEach
     void setUp() {
        dialogBoxesPage = initUiTest().openDialogBoxesTab();
    }

    @Test
    void switchToAlertTest(){
        Alert alert = dialogBoxesPage.switchToAlert();
        String text = alert.getText();
        alert.accept();
        Assertions.assertEquals(text, "Hello world!");
    }

    @Test
    void acceptConfirmTest(){
        Alert alert = dialogBoxesPage.switchToConfirm();
        String text = alert.getText();

        Assertions.assertEquals(text, "Is this correct?");
        alert.accept();
        String result = dialogBoxesPage.getConfirmResult();
        Assertions.assertEquals(result,"You chose: true");
    }

    @Test
    void cancelConfirmTest(){
        Alert alert = dialogBoxesPage.switchToConfirm();
        String text = alert.getText();

        Assertions.assertEquals("Is this correct?", text);
        alert.dismiss();
        String result = dialogBoxesPage.getConfirmResult();
        Assertions.assertEquals(result,"You chose: false");
    }

    @Test
    void promptTest(){
        Alert alert = dialogBoxesPage.switchToPrompt();
        String text = alert.getText();

        Assertions.assertEquals("Please enter your name", text);
        alert.sendKeys("Alex");
        alert.accept();
        String result = dialogBoxesPage.getPromptResult();
        Assertions.assertEquals(result,"You typed: Alex");
    }

    @Test
    void modalCloseTest(){
        String text = dialogBoxesPage.openModalAndGetContent();
        dialogBoxesPage.closeModalContent();
        String result = dialogBoxesPage.getModalResult();

        Assertions.assertTrue(text.contains("This is the modal body"), "Text not as expected");
        Assertions.assertEquals(result, "You chose: Close");
    }

    @Test
    void modalSaveTest(){
        String text = dialogBoxesPage.openModalAndGetContent();
        dialogBoxesPage.saveModalContent();
        String result = dialogBoxesPage.getModalResult();

        Assertions.assertTrue(text.contains("This is the modal body"), "Text not as expected");
        Assertions.assertEquals(result, "You chose: Save changes");
    }
}
