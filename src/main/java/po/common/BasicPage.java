package po.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public abstract class BasicPage {
    protected AppiumDriver driver;

    public BasicPage(AppiumDriver<? extends MobileElement> driver){
        this.driver = driver;
    }

}
