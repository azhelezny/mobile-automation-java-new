package po.hello_kitty;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import po.common.BasicPage;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class HelloKittyPage extends BasicPage {

    @FindBy(id = "textView")
    private MobileElement textView;

    @FindBy(id = "imageButton")
    private MobileElement imageButton;

    @FindBy(id = "editText")
    private MobileElement textArea;

    public HelloKittyPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public String getCaption() {
        return textView.getText();
    }

    public void clickButton() {
        imageButton.click();
    }

    public void setText(String text) {
        textArea.sendKeys(text);
    }
}
