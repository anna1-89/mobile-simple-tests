package drivers;

public class DriverFactory {

    public String getDriver() {
        String browser = null;
        browser = BrowserstackDriver.class.getName();
        return browser;
    }


}
