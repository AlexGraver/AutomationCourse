package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class PlaywrightLoginPage {

    private final Page page;

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator invalidPassError;
    private final Locator loginSuccessNotification;

    public PlaywrightLoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("//input[@id=\"username\"]");
        this.passwordInput = page.locator("//input[@id=\"password\"]");
        this.loginButton = page.locator("//button[@type=\"submit\"]");
        this.invalidPassError = page.locator("//div[@id=\"invalid\"]");
        this.loginSuccessNotification = page.locator("//div[@class=\"alert alert-success\"]");
    }

    public void navigate() {
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public void loginAs(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public boolean checkLoginSuccess(){
        if(invalidPassError.isVisible()){
            return false;
        }else{
            return loginSuccessNotification.isVisible();
        }
    }

}
