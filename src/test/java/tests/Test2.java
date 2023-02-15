package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test2 {
    // appiumu java ile baslatmak icin service
    AppiumDriverLocalService service;
    @Test
    public void test1() throws InterruptedException {
// appium icin servis ayarlari yapiliyor.
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        // appium servisi baslatilyor.
        service.start();
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "3c7eb8");
        capabilities.setCapability("appium:version", "12");
        capabilities.setCapability("appium:deviceName", "Xaomi Redmi Note 8");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appium:appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appium:appActivity","com.touchboarder.androidapidemos.MainActivity");


        AppiumDriver<MobileElement> driver;
        driver = new AndroidDriver<>(service.getUrl(), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text='DEVAM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//*[@text='TAMAM']")).click();
        driver.findElement(By.xpath("//*[@text='API Demos']")).click();
        driver.findElement(By.xpath("//*[@text='Accessibility']")).click();

        driver.closeApp();

        // appium service durduruluyor
        service.stop();
    }
}
