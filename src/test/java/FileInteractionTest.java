import core.helpers.AllureHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DownloadFilesPage;

import java.io.File;
import java.io.IOException;

public class FileInteractionTest extends BaseTest{

    @Test
    void downloadFile() throws IOException {
        AllureHelper allureHelper = new AllureHelper();
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
}
