package uk.co.vwf.insuranceportal.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverFactory {
    public static RemoteWebDriver driver;
    public static WebDriverWait waiter;

    public static WebDriverWait getWaiter() {
        if (waiter == null)
            waiter = new WebDriverWait(driver, Constant.WAIT_TIME_OUT);
        return waiter;
    }

    public static RemoteWebDriver createDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", Constant.DRIVER_PATH);
            driver = new ChromeDriver();

        }
        return driver;

    }
}
