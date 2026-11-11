package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainScreen {

    private static final SelenideElement homePageButton = $(accessibilityId("Home"));
    private static final SelenideElement searchButton = $(accessibilityId("Search"));

    @Step("Проверка что мы на главное старнице")
    public MainScreen checkHomeScreenIsOpen() {
        homePageButton.shouldBe(Condition.selected);
        return this;
    }

    @Step("Переход на экран поиска")
    public MainScreen clickOnSearchButton() {
        searchButton.click();
        return this;
    }


}
