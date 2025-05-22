package ui.testExtensions;

import core.driver.TestDriver;
import core.helpers.AllureHelper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class ScreenshotOnFailureExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        new AllureHelper().captureScreenshot(TestDriver.getDriver());
    }
}
