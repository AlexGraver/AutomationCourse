package homework_7;

import helpers.WaitHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SlowCalculator {


    private static final By LOADER = By.xpath("//span[@class=\"spinner-border\"]");
    private static final By SCREEN = By.xpath("//div[@class='screen']");
    private static WaitHelper waitHelper;
    private static WebDriver driver;

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        waitHelper = new WaitHelper(driver);
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
    }

    @Test
    void checkSumTest(){
        reset();
        pressNumber(3);
        sum();
        pressNumber(3);
        pressResult();

        Assertions.assertEquals(6, getResult());
    }

    @Test
    void checkMultiplyTest(){
        reset();
        pressNumber(6);
        multiply();
        pressNumber(3);
        pressResult();

        Assertions.assertEquals(18, getResult());
    }

    @Test
    void checkSubtract(){
        reset();
        pressNumber(1);
        pressNumber(0);
        subtract();
        pressNumber(3);
        pressResult();

        Assertions.assertEquals(7, getResult());
    }

    @Test
    void checkDevision(){
        reset();
        pressNumber(1);
        pressNumber(0);
        devide();
        pressNumber(2);
        pressResult();

        Assertions.assertEquals(5, getResult());
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }

















    private double getResult(){
        String result = waitHelper.waitUntilElementClickable(SCREEN).getDomProperty("textContent");
        return Integer.parseInt(result);
    }

    private void reset(){
        waitHelper.waitUntilElementClickable(By.xpath("//span[@class=\"clear btn btn-outline-danger\"]"))
                .click();
    }

    private void pressResult(){
       waitHelper.waitUntilElementClickable(By.xpath("//span[@class='btn btn-outline-warning']")).click();
       dismissLoader();
    }

    private void subtract(){
        pressAction("-");
    }

    private void devide(){
        waitHelper.waitUntilElementClickable(By.xpath("(//span[@class='operator btn btn-outline-success'])[3]"))
                        .click();
    }

    private void multiply(){
        pressAction("x");
    }

    private void sum(){
        pressAction("+");
    }

    void pressAction(String action){
        if(action.equals("-")
        || action.equals("x")
        || action.equals("+")
        || action.equals("÷")){
            String xpath = "//span[contains(@class, 'operator btn btn-outline-success') and text()='" + action + "']";
            waitHelper.waitUntilElementClickable(By.xpath(xpath)).click();
        }else {
            throw new IllegalArgumentException("Only -, +, x, ÷ is allowed to use");
        }
    }

    void pressNumber(int number){
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("Argument should be a digit from 0 to 9");
        }
        String xpath = "//span[contains(@class, 'btn btn-outline-primary') and text()='" + String.valueOf(number) + "']";
        waitHelper.waitUntilElementClickable(By.xpath(xpath)).click();
    }


    private boolean loaderIsDisplayed(){
        if(loaderIsPresent()){
            return driver.findElement(LOADER).isDisplayed();
        }else{
            return false;
        }
    }

    private boolean loaderIsPresent(){
        try{
            driver.findElement(LOADER);
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    private void dismissLoader(){
        if(loaderIsDisplayed()){
            waitHelper.waitUntilElementNotDisplayed(LOADER);
        }
    }



}
