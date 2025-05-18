import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.PlaywrightLoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class PlaywrightLoginPageTest {

    static Playwright playwright;
    static Browser browser;
    Page page;
    BrowserContext context;
    PlaywrightLoginPage playwrightLoginPage;


    @BeforeAll
    static void setupAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void teardownAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext();
        page = context.newPage();
        playwrightLoginPage = new PlaywrightLoginPage(page);
    }

    @AfterEach
    void cleanup() {
        page.close();
    }

    @Test
    void loginTest() {
        playwrightLoginPage.navigate();
        playwrightLoginPage.loginAs("user", "user");
        assertTrue(playwrightLoginPage.checkLoginSuccess(), "Login failed");
    }

    @Test
    void invalidCredentialsTest(){
        playwrightLoginPage.navigate();
        playwrightLoginPage.loginAs("wrong", "credentials");
        assertFalse(playwrightLoginPage.checkLoginSuccess(), "Login should be failed");
    }
}
