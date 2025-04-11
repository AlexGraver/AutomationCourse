import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest{

    DragAndDropPage dragAndDropPage;

    @BeforeEach
    void setUp(){
        dragAndDropPage = initUiTest().openDragAndDropTab();
    }

    @Test
    void dragAndDropTest(){
        WebElement draggable = dragAndDropPage.getDraggableElement();
        WebElement target = dragAndDropPage.getTargetElement();
        dragAndDropPage.dragAndDrop(draggable, target);

        Point locationSource = draggable.getLocation();
        Point locationTarget = target.getLocation();
        Assertions.assertEquals(locationSource, locationTarget);
    }
}
