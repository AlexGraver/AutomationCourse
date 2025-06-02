package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiDownloadUploadTests {

    @Test
    void apiDownloadTest() {
        String endpoint = "https://bonigarcia.dev/selenium-webdriver-java/docs/webdrivermanager.png";
        String fileName = "downloaded.png";

        Response response =
                given().
                        when().
                        get(endpoint).
                        then().
                        contentType("image/png").
                        statusCode(200).
                        extract().response();
        FileManagerApi.saveFile(response, fileName);
        File downloadedFile = new File(fileName);
        assertTrue(downloadedFile.exists(), "File not exists");
    }

    @Test
    void apiUploadTest() {
        String apiUrl = "https://petstore.swagger.io/v2/pet/1/uploadImage";
        File file = new File("C:\\Users\\agali\\IdeaProjects\\AutomationCourse\\downloaded.png");
        Response response =
                given()
                        .header("accept", "application/json")
                        .contentType("multipart/form-data")
                        .multiPart("file", file, "image/png") // Указываем тип содержимого файла
                        .when()
                        .post(apiUrl)
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        System.out.println("Response: " + response.asString());
    }
}
