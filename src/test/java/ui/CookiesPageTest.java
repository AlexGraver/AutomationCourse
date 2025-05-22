package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CookiesPage;

public class CookiesPageTest extends BaseTest {

    CookiesPage cookiesPage;

    @BeforeEach
    void setUp(){
        cookiesPage = initUiTest().openCookiesTab();
    }

    @Test
    void cookieTest(){
        cookiesPage.refreshCookie();
        String textBefore = cookiesPage.getCookieText();

        Assertions.assertEquals("username=John Doe\n" +
                "date=10/07/2018", textBefore);

        cookiesPage.addCookie("age", "30");
        cookiesPage.addCookie("position","Manager");

        cookiesPage.refreshCookie();
        String textAfter = cookiesPage.getCookieText();

        Assertions.assertEquals("username=John Doe\n" +
                "date=10/07/2018\n" +
                "age=30\n" +
                "position=Manager", textAfter);

        cookiesPage.deleteAllCookies();
        cookiesPage.refreshCookie();
        String clearedCookie = cookiesPage.getCookieText();

        Assertions.assertEquals("", clearedCookie);
    }
}
