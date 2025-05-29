package api.contollers;

import api.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class FluentUserController {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private static final String USER_ENDPOINT = "user";

    private final RequestSpecification requestSpecification;
    private Response lastResponse;

    public FluentUserController() {
        this.requestSpecification = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

    public FluentUserController createUser(User user) {
        this.lastResponse = given(this.requestSpecification)
                .body(user)
                .when()
                .post(USER_ENDPOINT)
                .andReturn();
        return this;
    }

    public FluentUserController getUser(User user) {
        this.lastResponse = given(this.requestSpecification)
                .when()
                .get(USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
        return this;
    }

    public FluentUserController updateUser(User user) {
        this.lastResponse = given(this.requestSpecification)
                .body(user)
                .when()
                .put(USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
        return this;
    }

    public FluentUserController deleteUser(User user) {
        this.lastResponse = given(this.requestSpecification)
                .when()
                .delete(USER_ENDPOINT + "/" + user.getUsername())
                .andReturn();
        return this;
    }

    public Response response() {
        return this.lastResponse;
    }

    public ValidatableResponse then() {
        return this.lastResponse.then();
    }
}
