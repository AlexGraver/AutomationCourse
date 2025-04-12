package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class SlowCalculatorPage extends BasePage {

    public SlowCalculatorPage(WebDriver driver){
        super(driver);
    }

    private static final By LOADER = By.xpath("//span[@class=\"spinner-border\"]");
    private static final By SCREEN = By.xpath("//div[@class='screen']");


    //============================================================================================================//

    public float getResult(){
        String result = waitUntilElementClickable(SCREEN).getDomProperty("textContent");
        return Float.parseFloat(result);
    }

    public void reset(){
        waitUntilElementClickable(By.xpath("//span[@class=\"clear btn btn-outline-danger\"]"))
                .click();
    }

    public void pressResult(){
       waitUntilElementClickable(By.xpath("//span[@class='btn btn-outline-warning']")).click();
       dismissLoader();
    }

    public void subtract(){
        pressAction("-");
    }

    public void devide(){
        waitUntilElementClickable(By.xpath("(//span[@class='operator btn btn-outline-success'])[3]"))
                        .click();
    }

    public void multiply(){
        pressAction("x");
    }

    public void sum(){
        pressAction("+");
    }

    public void pressAction(String action){
        if(action.equals("-")
        || action.equals("x")
        || action.equals("+")
        || action.equals("÷")){
            String xpath = "//span[contains(@class, 'operator btn btn-outline-success') and text()='" + action + "']";
            waitUntilElementClickable(By.xpath(xpath)).click();
        }else {
            throw new IllegalArgumentException("Only -, +, x, ÷ is allowed to use");
        }
    }

    public void pressNumber(int number){
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("Argument should be a digit from 0 to 9");
        }
        String xpath = "//span[contains(@class, 'btn btn-outline-primary') and text()='" + String.valueOf(number) + "']";
        waitUntilElementClickable(By.xpath(xpath)).click();
    }


    private boolean loaderIsDisplayed(){
        if(loaderIsPresent()){
            return findElement(LOADER).isDisplayed();
        }else{
            return false;
        }
    }

    private boolean loaderIsPresent(){
        try{
            findElement(LOADER);
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    private void dismissLoader(){
        if(loaderIsDisplayed()){
            waitUntilElementNotDisplayed(LOADER);
        }
    }



}
