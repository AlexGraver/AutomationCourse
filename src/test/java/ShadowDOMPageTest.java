import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import pages.ShadowDOMPage;

public class ShadowDOMPageTest extends BaseTest{

    ShadowDOMPage shadowDOMPage;

    @BeforeEach
    void setUp(){
        shadowDOMPage = initUiTest().openShadowDomTab();
    }
    @Test
    void checkShadowContentIsUnavailable() {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> shadowDOMPage.getShadowContentDirectly());
    }

    @Test
    void checkAbilityToReachShadowContentTest() {
        String shadowText = shadowDOMPage.getShadowTextViaRoot();

        Assertions.assertNotNull(shadowText, "Shadow content was not found!");
        System.out.println("Shadow DOM text: " + shadowText);
    }

}
