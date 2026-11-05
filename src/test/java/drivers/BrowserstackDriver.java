package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static config.ConfigProvider.browserStackConfig;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", browserStackConfig.userName());
        bstackOptions.put("accessKey", browserStackConfig.accessKey());
        bstackOptions.put("projectName", browserStackConfig.projectName());
        bstackOptions.put("buildName", browserStackConfig.buildName());
        bstackOptions.put("sessionName", browserStackConfig.sessionName());
        bstackOptions.put("deviceName", browserStackConfig.browserstackDevice());
        bstackOptions.put("osVersion", browserStackConfig.browserstackOsVersion());
        bstackOptions.put("appiumVersion", browserStackConfig.appiumVersion());

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setApp(browserStackConfig.app());
        options.setCapability("bstack:options", bstackOptions);


        try {
            return new AndroidDriver(
                    new URL(browserStackConfig.browserstackUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}
