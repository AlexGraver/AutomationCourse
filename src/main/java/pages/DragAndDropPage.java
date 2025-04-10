//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.WebElement;
//
//public class DragAndDropPage {
//
//    //-------------------------------------DragAndDropPage-------------------------------------------------//
//    //-----------------------------------------------------------------------------------------------------//
//    private static final By HEADER_DRAG_DROP = By.xpath("//h1[@class=\"display-6\"]");
//    private static final By DRAG_FROM = By.xpath("//div[@id=\"draggable\"]");
//    private static final By DROP_TO = By.xpath("//div[@id=\"target\"]");
//
////-------------------------------------DragAndDropPage-------------------------------------------------//
//    //-----------------------------------------------------------------------------------------------------//
//
//    @Test
//    void dragAndDropTest(){
//        openPage("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
//        WebElement source = driver.findElement(DRAG_FROM);
//        WebElement target = driver.findElement(DROP_TO);
//        actions.dragAndDrop(source, target).perform();
//        Point locationSource = source.getLocation();
//        Point locationTarget = target.getLocation();
//        Assertions.assertEquals(locationSource, locationTarget);
//    }
//
//
//
//
//}
