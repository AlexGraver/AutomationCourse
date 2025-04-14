package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationPage extends BasePage {

    private static final By HEADER_NAVIGATION = By.xpath("//h1[@class=\"display-6\"]");
    private static final By BACK_TO_INDEX = By.xpath("//a[@href=\"index.html\"]");
    private static final By PAGINATION_ABSTRACT_ELEMENT = By.xpath("//li[contains(@class, \"page-item\")]");
    private static final By PAGINATION_PREVIOUS = By.xpath("//a[contains(@class, \"page-link\") and text() = \"Previous\"]");
    private static final By PAGINATION_NEXT = By.xpath("//a[contains(@class, \"page-link\") and text() = \"Next\"]");
    private static final By PAGINATION_PAGE_1 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"1\"]");
    private static final By PAGINATION_PAGE_2 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"2\"]");
    private static final By PAGINATION_PAGE_3 = By.xpath("//a[contains(@class, \"page-link\") and text() = \"3\"]");

    public NavigationPage(WebDriver driver){
        super(driver);
    }

    @Step("Click to 'next' button")
    public void clickNext(){
        if(buttonIsEnabled(PAGINATION_NEXT)){
            findElement(PAGINATION_NEXT).click();
        }else{
            System.err.println("Button is Disabled");
        }
    }

    @Step("Click to 'previous' button")
    public void clickPrevious(){
        if(buttonIsEnabled(PAGINATION_PREVIOUS)){
            findElement(PAGINATION_PREVIOUS).click();
        }else{
            System.err.println("Button is Disabled");
        }
    }

    @Step("Active page is = {elementNumber}")
    public int checkActivePage(){
        List<WebElement> pagination_elements = findElements(PAGINATION_ABSTRACT_ELEMENT);
        int elementNumber = -1;
        for(WebElement element: pagination_elements){
            if(element.getDomProperty("className").contains("active")){
                elementNumber = Integer.parseInt(element.getDomProperty("innerText"));
            }
        }
        return elementNumber;
    }

    @Step
    public boolean buttonIsEnabled(By element){
        WebElement parent = findElement(element).findElement(By.xpath(".."));
        if(parent.getDomProperty("className").contains("disabled")){
            return false;
        }else{
            return true;
        }
    }

    @Step
    public HomePage goToHomePage(){
        findElement(BACK_TO_INDEX).click();
        return new HomePage(driver);
    }

    @Step
    public boolean pageIsOpened(){
        String actual = findElement(HEADER_NAVIGATION).getText();
        if(actual.equals("Navigation example")){
            return true;
        }else{
            return false;
        }
    }



}
