import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationPageTest {

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
}
