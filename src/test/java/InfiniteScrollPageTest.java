import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;

public class InfiniteScrollPageTest extends BaseTest{

    InfiniteScrollPage infiniteScrollPage;

    @BeforeEach
    void setUp() {
        infiniteScrollPage = initUiTest().openInfiniteScrollTab();
    }


    @Test
    void scrollTest(){
        int current = 0;
        int afterScroll = 1000;

        while(current < afterScroll){
            current = infiniteScrollPage.getParagraphCount();

            infiniteScrollPage.scrollToPageFooter();
            current = infiniteScrollPage.getParagraphCount();
        }
        Assertions.assertTrue(afterScroll <= infiniteScrollPage.getParagraphCount());
    }
}
