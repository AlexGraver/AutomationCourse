package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DialogBoxesPage extends BasePage {

    public DialogBoxesPage(WebDriver driver){
        super(driver);
    }

    private static final By ALERT = By.xpath("//button[@id=\"my-alert\"]");
    private static final By CONFIRM = By.xpath("//button[@id=\"my-confirm\"]");
    private static final By CONFIRM_RESULT = By.xpath("//p[@id=\"confirm-text\"]");
    private static final By PROMPT = By.xpath("//button[@id=\"my-prompt\"]");
    private static final By PROMPT_RESULT = By.xpath("//p[@id=\"prompt-text\"]");
    private static final By MODAL = By.xpath("//button[@id=\"my-modal\"]");
    private static final By MODAL_CONTENT = By.xpath("//div[@class=\"modal-body\"]");
    private static final By MODAL_CLOSE = By.xpath("(//button[@data-bs-dismiss=\"modal\"])[1]");
    private static final By MODAL_SAVE = By.xpath("(//button[@data-bs-dismiss=\"modal\"])[2]");
    private static final By MODAL_RESULT = By.xpath("//p[@id=\"modal-text\"]");

    public Alert switchToAlert(){
        return switchTo(ALERT);
    }

    public Alert switchToConfirm(){
        return switchTo(CONFIRM);
    }

    public String getConfirmResult(){
        return findElement(CONFIRM_RESULT).getText();
    }

    public Alert switchToPrompt(){
        return switchTo(PROMPT);
    }

    public String getPromptResult(){
        return findElement(PROMPT_RESULT).getText();
    }

    public String openModalAndGetContent(){
        waitUntilElementClickable(MODAL).click();
        return waitUntilElementDisplayed(MODAL_CONTENT).getText();
    }

    public void saveModalContent(){
        findElement(MODAL_SAVE).click();
    }

    public void closeModalContent(){
        findElement(MODAL_CLOSE).click();
    }

    public String getModalResult(){
        return findElement(MODAL_RESULT).getText();
    }







    public Alert switchTo(By locator){
        findElement(locator).click();
        waitUntilAlertIsPresent();
        return driver.switchTo().alert();
    }


}
