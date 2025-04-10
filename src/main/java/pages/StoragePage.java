//package pages;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.html5.LocalStorage;
//import org.openqa.selenium.html5.SessionStorage;
//import org.openqa.selenium.html5.WebStorage;
//
//public class StoragePage {
//
//    private static final String PAGE_URL = "https://bonigarcia.dev/selenium-webdriver-java/web-storage.html";
//    private static WebDriver driver;
//    private static WebStorage webStorage;
//    private static final By SHOW_LOCAL_STORAGE = By.xpath("//button[@id=\"display-local\"]");
//    private static final By SHOW_SESSION_STORAGE = By.xpath("//button[@id=\"display-session\"]");
//
//    @BeforeAll
//    static void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(PAGE_URL);
//        webStorage = (WebStorage) driver;
//    }
//
//    @AfterAll
//    static void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @Test
//    void localStorageTest(){
//        driver.findElement(SHOW_LOCAL_STORAGE).click();
//        LocalStorage localStorage = webStorage.getLocalStorage();
//        System.out.printf("Local storage elements: %d%n", localStorage.size());
//        localStorage.keySet()
//                .forEach(key -> System.out.printf("Local storage: %s = %s%n", key, localStorage.getItem(key)));
//
//        Assertions.assertEquals(4, localStorage.size());
//
//        localStorage.setItem("ItemName", "ItemValue");
//        System.out.printf("Local storage elements: %d%n", localStorage.size());
//        localStorage.keySet()
//                .forEach(key -> System.out.printf("Local storage: %s = %s%n", key, localStorage.getItem(key)));
//        Assertions.assertEquals(5, localStorage.size());
//
//
//    }
//
//
//    @Test
//    void sessionStorageTest(){
//        driver.findElement(SHOW_SESSION_STORAGE).click();
//        SessionStorage sessionStorage = webStorage.getSessionStorage();
//        System.out.printf("Session storage elements: %d%n", sessionStorage.size());
//        sessionStorage.keySet()
//                .forEach(key -> System.out.printf("Session storage: %s = %s%n", key, sessionStorage.getItem(key)));
//
//        Assertions.assertEquals(2, sessionStorage.size());
//
//        sessionStorage.setItem("ItemName", "ItemValue");
//        System.out.printf("Session storage elements: %d%n", sessionStorage.size());
//        sessionStorage.keySet()
//                .forEach(key -> System.out.printf("Session storage: %s = %s%n", key, sessionStorage.getItem(key)));
//        Assertions.assertEquals(3, sessionStorage.size());
//
//
//    }
//
//
//}
