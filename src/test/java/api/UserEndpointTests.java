package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserEndpointTests {

    String body = """
            {
              "id": 0,
              "username": "Alex",
              "firstName": "string",
              "lastName": "string",
              "email": "string",
              "password": "string",
              "phone": "string",
              "userStatus": 0
            }
    """;

    @Test
    void createUserTest(){
        Response response = given()
                    .baseUri("https://petstore.swagger.io/v2/")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                .when()
                    .body(body)
                    .post("user")
                .andReturn();

        System.out.println(response.getStatusCode());
        System.out.println("========================");
        System.out.println(response.prettyPrint());
    }

    @Test
    void getUserTest(){
        Response response = given()
                    .baseUri("https://petstore.swagger.io/v2/")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                .when()
                    .get("user/Alex")
                .andReturn();

        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

    }

}
