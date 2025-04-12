package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;

public class StoragePage extends BasePage {

    public StoragePage(WebDriver driver){
        super(driver);
    }

    private static final String PAGE_URL = "https://bonigarcia.dev/selenium-webdriver-java/web-storage.html";
    private static WebDriver driver;
    private static WebStorage webStorage;
    private static final By SHOW_LOCAL_STORAGE = By.xpath("//button[@id=\"display-local\"]");
    private static final By SHOW_SESSION_STORAGE = By.xpath("//button[@id=\"display-session\"]");

    public LocalStorage getLocalStorage(){
        driver.findElement(SHOW_LOCAL_STORAGE).click();
        return webStorage.getLocalStorage();
    }

    public SessionStorage getSessionStorage(){
        driver.findElement(SHOW_SESSION_STORAGE).click();
        return webStorage.getSessionStorage();
    }



}
