package api;

import api.contollers.UserController;
import api.models.TestUsers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class UserEndpointTests {

    UserController userController;

    @BeforeEach
    void setup() {
        userController = new UserController();
    }

    @Test
    @Order(1)
    void createUserTest(){
        Response response = userController.createUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(2)
    void getUserTest(){
        Response response = userController.getUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(3)
    void updateUserData(){
        TestUsers.MY_USER.setEmail("new@email.com");
        Response response = userController.updateUser(TestUsers.MY_USER);
        Assertions.assertEquals(200, response.getStatusCode());

        response = userController.getUser(TestUsers.MY_USER);
        Boolean isUpdated = response.getBody().asPrettyString().contains("new@email.com");
        Assertions.assertEquals(true, isUpdated, "User field is not updated");
    }

    @Test
    @Order(4)
    void deleteUser(){
        Response response = userController.deleteUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        response = userController.getUser(TestUsers.MY_USER);
        Assertions.assertEquals(404, response.getStatusCode());
    }

}
