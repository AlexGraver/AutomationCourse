//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class DropdownMenuPage {
//
//    //-------------------------------------DropDownMenuPage------------------------------------------------//
//    //-----------------------------------------------------------------------------------------------------//
//    private static final By HEADER_DROPDOWN = By.xpath("//h1[@class=\"display-6\"]");
//    private static final By LEFT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-1\"]");
//    private static final By RIGHT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-2\"]");
//    private static final By RIGHT_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-2\"]");
//    private static final By DOUBLE_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-3\"]");
//    private static final By DOUBLE_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-3\"]");
//
//
//    //-------------------------------------DropDownMenuPage------------------------------------------------//
//    //-----------------------------------------------------------------------------------------------------//
//    @Test
//    void leftClickTest(){
//        openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
//        WebElement leftClickMenu = driver.findElement(LEFT_CLICK_MENU);
//        actions.click(leftClickMenu).perform();
//        String isExpanded = leftClickMenu.getDomProperty("ariaExpanded");
//        Assertions.assertTrue(isExpanded.equalsIgnoreCase("true"), "Should be expanded");
//    }
//
//    @Test
//    void  rightClickTest(){
//        openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
//        WebElement rightClickMenu = driver.findElement(RIGHT_CLICK_MENU);
//        WebElement context = driver.findElement(RIGHT_CLICK_CONTEXT_MENU);
//        String style = context.getDomProperty("style");
//        Assertions.assertTrue(style.equalsIgnoreCase("[]"));
//        actions.contextClick(rightClickMenu).perform();
//        style = context.getDomProperty("style");
//        Assertions.assertTrue(style.equalsIgnoreCase("[display]"));
//    }
//
//    @Test
//    void doubleClickTest(){
//        openPage("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
//        WebElement doubleClickMenu = driver.findElement(DOUBLE_CLICK_MENU);
//        WebElement context = driver.findElement(DOUBLE_CLICK_CONTEXT_MENU);
//        String style = context.getDomProperty("style");
//        Assertions.assertTrue(style.equalsIgnoreCase("[]"));
//        actions.doubleClick(doubleClickMenu).perform();
//        style = context.getDomProperty("style");
//        Assertions.assertTrue(style.equalsIgnoreCase("[display]"));
//    }
//}
