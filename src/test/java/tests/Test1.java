package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        //Desired capability
        //Hangi cihaz ve hangi uygulamaya bağlanılıcak

        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "3c7eb8");
        capabilities.setCapability("appium:version", "12");
        capabilities.setCapability("appium:deviceName", "Xaomi Redmi Note 8");
     //   capabilities.setCapability("appium:realDevice", "false");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appium:appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appium:appActivity","com.touchboarder.androidapidemos.MainActivity");

        /*
                "appium:udid": "emulator-5554",
                "appium:version": "11",
                "appium:deviceName": "Pixcel12",
                "appium:realDevice": "false",
                "platformName": "Android"
        */

        //driver lazım burda bize
        //RemoteWebDriver->WebDriver->AppiumDriver-->(AndroidDriver,iosDriver)

        AppiumDriver<MobileElement> driver;
        driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='DEVAM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='TAMAM']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();

        Thread.sleep(2000);
        driver.closeApp();

    }
}
