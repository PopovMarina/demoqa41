package pages;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//Протектед - доступен только в расках данного ПЭКИЖДА
//Прайват - только в рамках данного КЛАССА и даже наследники его не видят
//Паблик - видят все и использовать можно из ЛЮБОГО класса

public class BasePage {
    protected WebElement findElementBase(By locator) {
        //протектед - доступен только в рамках пэкиджа пэйджес
        return ConfigManager.getDriver().findElement(locator);
    }

    protected String getTextBase(By locator) {

        return findElementBase(locator).getText().toUpperCase().trim();
    }

    protected void clickBase(By locator) {
        findElementBase(locator).click();
    }

    protected void jsExecutorBase(String str) {
        JavascriptExecutor js = (JavascriptExecutor) ConfigManager.getDriver();
        js.executeScript(str);
    }

    protected boolean isTextEqual(By locator, String expectedResult) {
        expectedResult = expectedResult.toUpperCase().trim();
        String actualResult = getTextBase(locator);
       return isTextEqualBy2Strings(actualResult, expectedResult);
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    protected String getCurrentUrlBase() {
        return ConfigManager.getDriver().getCurrentUrl();
    }
    protected boolean isTextEqualBy2Strings(String actualResult, String expectedResult) {

        if(expectedResult.equals(actualResult)) {
            return true;
        } else
            System.out.println("actual result: " + actualResult
                    + " expected result " + expectedResult);
        return false;
    }

}
