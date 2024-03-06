package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class ConfigManager { //on the lessons: BaseTest.java
//есть чейн или стримы (lambda)

    private static WebDriver driver;

    public static WebDriver getDriver() {
        //to change with while
//        int counter = 0;
//        while (driver == null || counter <= 5) {
//            try {
//                Thread.sleep(500);
//            }catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

//прайват и паблик - это модификаторы доступа
//статик дает 1. возможность вызывать публичные методы
// этого класса без создания экз. объекта класса
//2. Как запускается код: наживаем ран, идет компеляция,
//программа проходит по всем  статик переменным, методам и тд,
//и только после этого она запускает мэйн/тест и тд
//3. статик нужно ставить только то, что надо при каждом запуске
//тк он тратит время и память

        //singleton
//        if(driver == null) {
//            setUp("chrome");
//        }
        return driver;
    }

    @BeforeSuite
    @Parameters("browser")
    public static void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en");
//            chromeOptions.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("intl.accept_languages", "en");
//            firefoxOptions.addArguments("-headless");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("language", "en");
//            edgeOptions.addArguments("--headless");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setCapability("language", "en");
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver(safariOptions);
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // driver.navigate().to("https://demoqa.com/");
        navigateToMainPage();
    }
public static void  navigateToMainPage () {
    driver.navigate().to("https://demoqa.com/");

}
    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }
}