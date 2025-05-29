package api;

import api.contollers.FluentUserController;
import api.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static api.models.TestUsers.MY_USER;
import static org.hamcrest.Matchers.equalTo;

public class FluentUserEndpointTests {

    FluentUserController fluentUserController;
    User user;

    @BeforeEach
    void setup() {
        fluentUserController = new FluentUserController();
        user = MY_USER;
    }

    @Test
    @Order(1)
    void createUserTest(){
        fluentUserController.createUser(user)
                .then()
                .statusCode(200);
    }

    @Test
    @Order(2)
    void getUserTest(){
        fluentUserController.getUser(user)
                .then()
                .statusCode(200)
                .body("username", equalTo(user.getUsername()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("email", equalTo(user.getEmail()))
                .body("password", equalTo(user.getPassword()))
                .body("phone", equalTo(user.getPhone()))
                .body("userStatus", equalTo(user.getUserStatus()));
    }

    @Test
    @Order(3)
    void updateUserData(){
        user.setLastName("Great again");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fluentUserController.updateUser(user)
                .then()
                .statusCode(200)
                .body("username", equalTo(user.getUsername()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("email", equalTo(user.getEmail()))
                .body("password", equalTo(user.getPassword()))
                .body("phone", equalTo(user.getPhone()))
                .body("userStatus", equalTo(user.getUserStatus()));
    }

    @Test
    @Order(4)
    void deleteUser(){
        fluentUserController.deleteUser(user).then().statusCode(200);
    }

}
