package tests;

import frameworkbase.AppiumFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class AppiumBase {

    public static AppiumFactory appiumFactory;

    @BeforeEach
    public void instantiateDriverObject() {
                appiumFactory = new AppiumFactory();
    }

    public WebDriver getDriver() throws Exception {
        return appiumFactory.getDriver();
    }

    @AfterEach
    public void closeDriverObjects() {
            appiumFactory.quitDriver();
    }
}