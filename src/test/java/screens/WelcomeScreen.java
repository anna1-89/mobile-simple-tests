package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class WelcomeScreen {

    //Elements
    private static final SelenideElement firstWelcomeScreen = $(accessibilityId("Wikipedia"));
    private static final SelenideElement secondWelcomeScreen = $(accessibilityId("Data & Privacy"));
    private static final SelenideElement thirdWelcomeScreen = $(accessibilityId("Read in more than 300 languages"));
    private static final SelenideElement fourthWelcomeScreen = $(accessibilityId("Follow your curiosity"));
    private static final SelenideElement forwardButton = $(accessibilityId("Forward"));
    private static final SelenideElement skipButton = $x("//android.widget.TextView[@text=\"Skip\"]\n");

    //Actions
    @Step("Нажимаем на \"Далее\" в первом Welcome скрине \"All the world's knowledge\"")
    public WelcomeScreen passFirstWelcomeScreen() {
        firstWelcomeScreen.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Нажимаем на \"Далее\" во втором Welcome скрине \"Data and Privacy\"")
    public WelcomeScreen passSecondWelcomeScreen() {
        secondWelcomeScreen.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Нажимаем на \"Далее\" в третьем Welcome скрине \"Read in more than 300 languages\"")
    public WelcomeScreen passThirdWelcomeScreen() {
        thirdWelcomeScreen.shouldBe(Condition.visible);
        forwardButton.click();
        return this;
    }

    @Step("Нажимаем на \"Пропустить\" в последнем Welcome скрине \"Follow your curiosity\"")
    public WelcomeScreen passFourthWelcomeScreen() {
        fourthWelcomeScreen.shouldBe(Condition.visible);
        skipButton.click();
        return this;
    }

    @Step("Открываем главное окно приложения")
    public WelcomeScreen passWelcomeScreens() {
        back();
        return this;
    }

}
