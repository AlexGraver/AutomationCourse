package api;

import api.contollers.UserController;
import api.models.TestUsers;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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
    @Description("Create user test")
    void createUserTest(){
        Response response = userController.createUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(2)
    @Description("Get user test")
    void getUserTest(){
        Response response = userController.getUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(3)
    @Description("Update user test")
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
    @Description("Delete user test")
    void deleteUser(){
        Response response = userController.deleteUser(TestUsers.MY_USER);
        response.prettyPrint();
        Assertions.assertEquals(200, response.getStatusCode());
        response = userController.getUser(TestUsers.MY_USER);
        Assertions.assertEquals(404, response.getStatusCode());
    }

}
