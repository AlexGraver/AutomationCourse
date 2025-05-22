package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DropdownMenuPage;

public class DropdownMenuPageTest extends BaseTest {

    DropdownMenuPage dropdownMenuPage;

    @BeforeEach
    void setUp(){
        dropdownMenuPage = initUiTestSelenide().openDropdownMenuTab();
    }

    @Test
    void leftClickTest(){
        dropdownMenuPage.openLeftMenu();
        Assertions.assertTrue(dropdownMenuPage.leftMenuIsExpanded(), "Should be expanded");
    }

    @Test
    void  rightClickTest(){
        dropdownMenuPage.openRightMenu();
        Assertions.assertTrue(dropdownMenuPage.rightMenuIsExpanded(), "Should be expanded");
    }

    @Test
    void doubleClickTest(){
        dropdownMenuPage.openDoubleMenu();
        Assertions.assertTrue(dropdownMenuPage.doubleMenuIsExpanded(), "Should be expanded");
    }
}
