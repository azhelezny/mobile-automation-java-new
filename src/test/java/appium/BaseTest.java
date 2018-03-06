package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.Settings;
import utils.CommandLineUtils;
import utils.PathUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class BaseTest {
    public static AppiumDriver<MobileElement> driver = null;
    public DesiredCapabilities capabilities;

    public void setUpTest() throws IOException {
        this.capabilities = new DesiredCapabilities();

        if (isLocalRun()) {
            // local run
            capabilities.setCapability(MobileCapabilityType.APP, Settings.get().appFile());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Settings.get().platformName());
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Settings.get().platformVersion());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Settings.get().deviceName());
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

            CommandLineUtils.executeCommandLineCommandLocally("adb uninstall io.appium.settings",false);
            CommandLineUtils.executeCommandLineCommandLocally("adb uninstall io.appium.unlock",false);
        } else {
            //battle mode
            //TODO add code after understanding of work scope
        }
        if (Settings.get().platformName().toLowerCase().equals("android")) {
            driver = new AndroidDriver<>(new URL(Settings.serverURL), capabilities);
        } else {
            driver = new IOSDriver<>(new URL(Settings.serverURL), capabilities);
        }
    }

    private boolean isLocalRun() {
        return Settings.get().executionType().equals("clientside");
    }

    protected void quitAppiumSession() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected File takeScreenshot(String screenshotName) {
        String fullFileName = PathUtils.getOsPath(Settings.projectDir, "screenshots", screenshotName + ".png");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File testScreenshot = new File(fullFileName);
            FileUtils.copyFile(scrFile, testScreenshot);
            return testScreenshot;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
