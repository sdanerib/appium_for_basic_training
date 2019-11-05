package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import pageobject.MobilePageObject;


public class VodQALogin extends MobilePageObject {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"login\"]\n")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"login\"]\n")
    private MobileElement loginBtn;

    public VodQALogin(AppiumDriver driver) {
        super(driver);
    }

    public void login(){
        loginBtn.click();
    }


}
