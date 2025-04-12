import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import pages.StoragePage;

public class StoragePageTest extends BaseTest{

    StoragePage storagePage;

    @BeforeEach
    void setUp(){
        storagePage = initUiTest().openWebStorageTab();
    }

    @Test
    void localStorageTest(){
        LocalStorage localStorage = storagePage.getLocalStorage();
        System.out.printf("Local storage elements: %d%n", localStorage.size());
        localStorage.keySet()
                .forEach(key -> System.out.printf("Local storage: %s = %s%n", key, localStorage.getItem(key)));

        Assertions.assertEquals(4, localStorage.size());

        localStorage.setItem("ItemName", "ItemValue");
        System.out.printf("Local storage elements: %d%n", localStorage.size());
        localStorage.keySet()
                .forEach(key -> System.out.printf("Local storage: %s = %s%n", key, localStorage.getItem(key)));
        Assertions.assertEquals(5, localStorage.size());
    }


    @Test
    void sessionStorageTest(){
        SessionStorage sessionStorage = storagePage.getSessionStorage();
        System.out.printf("Session storage elements: %d%n", sessionStorage.size());
        sessionStorage.keySet()
                .forEach(key -> System.out.printf("Session storage: %s = %s%n", key, sessionStorage.getItem(key)));

        Assertions.assertEquals(2, sessionStorage.size());

        sessionStorage.setItem("ItemName", "ItemValue");
        System.out.printf("Session storage elements: %d%n", sessionStorage.size());
        sessionStorage.keySet()
                .forEach(key -> System.out.printf("Session storage: %s = %s%n", key, sessionStorage.getItem(key)));
        Assertions.assertEquals(3, sessionStorage.size());
    }
}
