package tests;

import config.ConfigManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import pages.TextBoxPage;

public class BaseTest extends ConfigManager{

    MainPage mainPage = new MainPage();
    ElementsPage elementsPage = new ElementsPage();
    TextBoxPage textBoxPage = new TextBoxPage();


//    @BeforeSuite
//    public void init() {
//        ConfigManager.setUp("chrome");
//    }
//
//    @AfterSuite
//    public void stop() {
//        ConfigManager.tearDown();
//    }
}