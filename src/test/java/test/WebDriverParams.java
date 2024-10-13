package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WebDriverParams {

    private void setupWebDriver() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15_000L;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeEach
    void init() {
        setupWebDriver();
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }
}