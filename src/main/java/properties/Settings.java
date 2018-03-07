package properties;

import utils.PathUtils;

public class Settings {
    private String appFile = System.getenv("APP_FILE");
    private String platformName = System.getenv("PLATFORM_NAME");
    private String platformVersion = System.getenv("PLATFORM_VERSION");
    private String deviceName = System.getenv("DEVICE_NAME");

    // testDroid settings
    // user and password can be added to desiredCapabilities using keys testdroid_username and testdroid_password
    private String testDroidUser = System.getenv("TESTDROID_USERNAME");
    private String testDroidPwd = System.getenv("TESTDROID_PASSWORD");
    private String testDroidAppLocation = System.getenv("TESTDROID_PASSWORD");//?
    private String testDroidTargetAppPath = System.getenv("TARGET_APP_PATH");

    private String testDroidApiKey = System.getProperty("apiKey");
    private String testDroidExecutionType = System.getProperty("executionType");
    private String testDroidApplicationPath = System.getProperty("ApplicationPath");
    private String testDroidExportResults = System.getProperty("exportResults");

    public static final String TESTDROID_SERVER = "http://appium.testdroid.com";
    public static final String TESTDROID_UPLOAD_URL = TESTDROID_SERVER + "/upload";


    private static Settings settings = null;

    public static final String projectDir = PathUtils.getOsPath(System.getProperty("user.dir"));
    public static final String mainDir = PathUtils.getOsPath(projectDir, "src", "main");
    public static final String mainResourcesDir = PathUtils.getOsPath(mainDir, "resources");
    public static final String testsDir = PathUtils.getOsPath(projectDir, "src", "test");
    public static final String testsResourcesDir = PathUtils.getOsPath(testsDir, "resources");

    public static final String serverURL = "http://127.0.0.1:4723/wd/hub";

    private Settings() {
        if (appFile == null) appFile = PathUtils.getOsPath(Settings.mainResourcesDir, "helloKitty.apk");
        if (platformName == null) platformName = "Android";
        if (platformVersion == null) platformVersion = "";
        if (deviceName == null) deviceName = "Android Device";
        if (testDroidExecutionType == null) testDroidExecutionType = "clientside";
    }

    public static Settings get() {
        if (settings == null)
            settings = new Settings();
        return settings;
    }

    public String appFile() {
        return appFile;
    }

    public String platformName() {
        return platformName;
    }

    public String platformVersion() {
        return platformVersion;
    }

    public String deviceName() {
        return deviceName;
    }

    public String executionType() {
        return this.testDroidExecutionType;
    }

    public String testDroidUser() {
        return testDroidUser;
    }

    public String testDroidPwd() {
        return testDroidPwd;
    }

    public String getTestDroidApiKey() {
        return testDroidApiKey;
    }
}
