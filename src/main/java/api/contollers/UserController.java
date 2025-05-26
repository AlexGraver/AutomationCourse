package api.contollers;


import api.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserController {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private static final String USER_ENDPOINT = "user";
    RequestSpecification requestSpecification;

    public UserController(){
        this.requestSpecification = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

    public Response createUser(User user){
        return given(this.requestSpecification)
                    .body(user)
                .when()
                    .post(USER_ENDPOINT)
                .andReturn();
    }

    public Response getUser(User user){
        return given(this.requestSpecification)
                .when()
                    .get(BASE_URI + USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }

    public Response updateUser(User user){
        return given(this.requestSpecification)
                    .body(user)
                .when()
                    .put(BASE_URI + USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }

    public Response deleteUser(User user){
        return given(this.requestSpecification)
                    .body(user)
                .when()
                    .delete(BASE_URI + USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
    }

}
