package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import drivers.DriverFactory;
import screens.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    WelcomeScreen welcomeScreen = new WelcomeScreen();
    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();
    ArticleScreen articleScreen = new ArticleScreen();
    SavedArticlesScreen savedArticles = new SavedArticlesScreen();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        Configuration.browser = new DriverFactory().getDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);
        Attach.screenshot();
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }

}


