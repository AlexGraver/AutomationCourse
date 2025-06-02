package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiDownloadUploadTests {

    @Test
    void testDownloadHttpClient() {
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
}
