import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElementInteractions {




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





    //====================================================================================================//
    //--------------------------------------InteractionTests----------------------------------------------//
    //====================================================================================================//

    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }









    @AfterAll
    static void tearDown(){
         driver.quit();
    }
}
