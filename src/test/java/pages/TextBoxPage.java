package pages;

import config.ConfigManager;
import org.testng.annotations.BeforeClass;
import tests.BaseTest;

public class TextBoxPage extends BasePage {

    public boolean validateUrlTexBoxCorrect() {
        String url = "https://demoqa.com/text-box";
        String currentUrl = getCurrentUrlBase();
        return isTextEqualBy2Strings(currentUrl, url);
    };
}
