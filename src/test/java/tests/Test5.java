package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import java.text.MessageFormat;

public class Test5 {

    By lDevam = By.xpath("//*[@text='DEVAM']");
    By lButton1 = By.id("android:id/button1");
    By lTamam = By.xpath("//*[@text='TAMAM']");
    By lAPI_Demos = By.xpath("//*[@text='API Demos']");
    // By lAccessibility = By.xpath("//*[@text='Accessibility']");

    String textXpath = "//*[@text=\"{0}\"]";

    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        Driver.runAppium();
        driver = Driver.getDriver(Device.Redmi_Note_8, App.APIDEMO);
        wait = new WebDriverWait(driver, 4);
        click(lDevam);
        click(lButton1);
        click(lTamam);
        click(lAPI_Demos);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        Driver.stopAppium();
    }

    @Test
    public void test1() {

        click(xpathOfText("Accessibility"));
        driver.navigate().back();
        click(xpathOfText("Media"));
        driver.navigate().back();
        click(xpathOfText("OS"));


    }

    @Test
    public void test2() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathOfText("Accessibility"))).click();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathOfText("Views"))).click();
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathOfText("Preference"))).click();

    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    By xpathOfText(String... text) {
        return By.xpath(MessageFormat.format(textXpath, text));
    }
}
