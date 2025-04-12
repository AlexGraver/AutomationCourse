package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


public class CookiesPage extends BasePage {

    public CookiesPage(WebDriver driver){
        super(driver);
    }

    private static final By REFRESH_COOKIE = By.xpath("//button[@id=\"refresh-cookies\"]");
    private static final By COOKIE_LIST = By.xpath("//p[@id=\"cookies-list\"]");

    public void refreshCookie(){
        findElement(REFRESH_COOKIE).click();
    }

    public String getCookieText(){
        return findElement(COOKIE_LIST).getText();
    }

    public void addCookie(String key, String value){
        driver.manage().addCookie(new Cookie(key, value));
    }

    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

}
