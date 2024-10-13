package com;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    public static AndroidDriver driver; // Hilangkan parameter generic

    public static void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Konfigurasi capabilities
        caps.setCapability("platformName", "ANDROID");
        caps.setCapability("platformVersion", "12.0");  // Sesuaikan dengan perangkat kamu
        caps.setCapability("deviceName", "Pixel_7_API_31"); // Ganti dengan nama perangkat fisik atau emulator
        caps.setCapability("appPackage", "com.uptodown");
        caps.setCapability("appActivity", "com.uptodown.activities.MainActivity");
        caps.setCapability("automationName", "UiAutomator2");

        // Jika menggunakan aplikasi yang sudah terinstall di perangkat
        caps.setCapability("noReset", "true");

        // Inisialisasi driver tanpa <>, tanpa generic
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
