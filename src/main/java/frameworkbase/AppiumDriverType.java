package frameworkbase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public enum AppiumDriverType implements AppiumDriverSetup {

    ANDROID {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {

            String appResourcesPath = System.getProperty("user.dir") + "/src/main/resources/VodQA";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 XL API 26");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
            capabilities.setCapability(MobileCapabilityType.APP, appResourcesPath +"-Android.apk");

            System.out.println(">>>" +  appResourcesPath +"-Android.apk");

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {

            return new AndroidDriver<>(appiumServerURL, capabilities);
        }
    },
    IPHONE {
        public DesiredCapabilities getDesiredCapabilities(String pathToAppFile, boolean debug) {

            String appResourcesPath = System.getProperty("user.dir") + "/src/main/resources/VodQA";

            DesiredCapabilities capabilities = DesiredCapabilities.iphone();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
            capabilities.setCapability(MobileCapabilityType.APP, appResourcesPath +"ReactNative.app");

            if (debug) {
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3600");
            }

            return capabilities;
        }

        public RemoteWebDriver getWebDriverObject(URL appiumServerURL, DesiredCapabilities capabilities) {
            return new IOSDriver<>(appiumServerURL, capabilities);
        }
    }

}
