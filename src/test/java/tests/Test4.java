package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

public class Test4 {

    By lDevam= By.xpath("//*[@text='DEVAM']");
    By lButton1= By.id("android:id/button1");
    By lTamam=By.xpath("//*[@text='TAMAM']");
    By lAPI_Demos=By.xpath("//*[@text='API Demos']");
    By lAccessibility=By.xpath("//*[@text='Accessibility']");

    AppiumDriver<MobileElement> driver;
    @BeforeTest
    public void beforeTest(){
        Driver.runAppium();

        driver = Driver.getDriver(Device.Redmi_Note_8, App.APIDEMO);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        Driver.stopAppium();
    }

    @Test
    public void test1(){
        driver.findElement(lDevam).click();
        driver.findElement(lButton1).click();
        driver.findElement(lTamam).click();
        driver.findElement(lAPI_Demos).click();
        driver.findElement(lAccessibility).click();
    }
    @Test
    public void test2(){
        click(lDevam);
        click(lButton1);
        click(lTamam);
        click(lAPI_Demos);
        click(lAccessibility);

    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
}
