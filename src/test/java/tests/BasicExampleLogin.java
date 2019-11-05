package tests;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.VodQALogin;
import tests.AppiumBase;

import static java.lang.Thread.sleep;

public class BasicExampleLogin extends AppiumBase {

    @Test
    public void Login(){
        VodQALogin loginPage = null;

        try {
            loginPage = new VodQALogin((AppiumDriver) getDriver());
            loginPage.login();
            sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}