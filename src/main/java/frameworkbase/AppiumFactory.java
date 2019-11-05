package frameworkbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumFactory {

    private WebDriver driver;
    private AppiumDriverType selectedDriverType;

    private final AppiumDriverType defaultDriverType = AppiumDriverType.IPHONE;

    private final String appiumConfig = System.getProperty("device", defaultDriverType.toString()).toUpperCase();
    private final boolean setDebugMode = Boolean.getBoolean("enableDebugMode");
    private final String pathToAppFile = System.getProperty("pathToAppFile");
    private final String appiumServerLocation = System.getProperty("appiumServerLocation", "http://127.0.0.1:4723/wd/hub");

    public WebDriver getDriver() throws Exception {
        if (null == driver) {
            determineEffectiveDriverType();
            DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities(pathToAppFile, setDebugMode);
            instantiateWebDriver(desiredCapabilities);
        }

        return driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

    private void determineEffectiveDriverType() {
        AppiumDriverType driverType = defaultDriverType;
        try {
            driverType = AppiumDriverType.valueOf(appiumConfig);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        selectedDriverType = driverType;
    }

    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException {
        System.out.println("Current Appium Config Selection: " + selectedDriverType);
        System.out.println("Current Appium Server Location: " + appiumServerLocation);

        driver = selectedDriverType.getWebDriverObject(new URL(appiumServerLocation), desiredCapabilities);;
    }
}

