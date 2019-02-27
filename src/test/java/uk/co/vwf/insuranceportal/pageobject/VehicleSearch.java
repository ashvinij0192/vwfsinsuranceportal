package uk.co.vwf.insuranceportal.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static uk.co.vwf.insuranceportal.common.DriverFactory.getWaiter;

public class VehicleSearch {

    public WebDriver driver;

    public VehicleSearch(RemoteWebDriver driver) {
        this.driver = driver;

    }

    public void loadPage(String url) {
        driver.get(url);
    }

    public void pageRefresh() {
        driver.navigate().refresh();
    }


    public WebElement getWebElementBy(By by) {
        return driver.findElement(by);
    }

    public boolean isDealerSearchTitleDisplayed() {
        WebElement element1 = getWebElementBy(By.id("dlg-dealersearch-title"));
        return element1.isDisplayed();
    }

    public String getDealerSearchTitle() {
        WebElement element1 = getWebElementBy(By.id("dlg-dealersearch-title"));
        return element1.getText();
    }

    public boolean isDealerSearchSubTitleDisplaed() {
        WebElement element2 = getWebElementBy(By.id("dlg-dealersearch-subtitle"));
        return element2.isDisplayed();
    }

    public String getDealerSearchSubTitle() {
        WebElement element2 = getWebElementBy(By.id("dlg-dealersearch-subtitle"));
        return element2.getText();
    }

    public void enterRegistrationNo(String regNo) {
        WebElement element3 = getWebElementBy(By.id("vehicleReg"));
        element3.sendKeys(regNo);
    }

    public void clearInput() {
        WebElement element3 = getWebElementBy(By.id("vehicleReg"));
        element3.clear();
    }

    public boolean isRegistrationNoTextFieldEditable() {
        WebElement element3 = getWebElementBy(By.id("vehicleReg"));
        return element3.isEnabled();
    }

    public void clickOnFindVehicleButton() {
        WebElement element4 = getWebElementBy(By.name("btnfind"));
        element4.click();
    }

    public String getResult() {
        getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.className("result")));
        WebElement result = getWebElementBy(By.className("result"));
        return result.getText();
    }

    public String getResultStartDate() {
        try {
            WebElement result = getWebElementBy(By.xpath("//*[@id=\"page-container\"]/div[4]/div[2]"));
            return result.getText();

        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getResultEndDate() {
        try {
            WebElement result = getWebElementBy(By.xpath("//*[@id=\"page-container\"]/div[4]/div[3]"));
            return result.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }

    public String getInputErrorMessage() {
        WebElement error = getWebElementBy(By.className("error-required"));
        return error.getText();
    }
}
