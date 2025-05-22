package ui;

import core.driver.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DownloadFilesPage;
import pages.webFormPage.WebFormPage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class FileInteractionTest extends BaseTest {

    @Test
    void downloadFile() throws IOException {
        DownloadFilesPage downloadFilesPage = initUiTest().openDownloadFilesTab();

        File pngDriverLogo = downloadFilesPage.downloadDriverLogo();
        File pdfDriverDoc = downloadFilesPage.downloadDriverDoc();
        File pngSeleniumLogo = downloadFilesPage.downloadSeleniumLogo();
        File pdfSeleniumDoc = downloadFilesPage.downloadSeleniumDoc();

        Assertions.assertAll(
                ()-> Assertions.assertTrue(pngDriverLogo.exists(), "File not found/exist: " + pngDriverLogo.getName()),
                ()-> Assertions.assertTrue(pdfDriverDoc.exists(), "File not found/exist: " + pdfDriverDoc.getName()),
                ()-> Assertions.assertTrue(pngSeleniumLogo.exists(), "File not found/exist: " + pngSeleniumLogo.getName()),
                ()-> Assertions.assertTrue(pdfSeleniumDoc.exists(), "File not found/exist: " + pdfSeleniumDoc.getName())
        );
    }

    @Test
    void uploadFileTest() throws IOException {
        String filePath = "src/main/resources/driver_logo_for_upload.png";

        WebFormPage webFormPage = initUiTest().openWebFormTab();
        webFormPage.uploadFile(filePath);
        webFormPage.submitForm();

        Assertions.assertTrue(Objects.requireNonNull(TestDriver.getDriver().getCurrentUrl())
                .contains("driver_logo_for_upload.png"), "File not uploaded");
    }
}
