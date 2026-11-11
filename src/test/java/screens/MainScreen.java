package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainScreen {

    //Elements
    private static final SelenideElement mainButton = $(accessibilityId("Home"));
    private static final SelenideElement searchTab = $(accessibilityId("Search"));

    //Actions
    @Step("Нажимаем на вкладку \"Поиск\" в основном меню")
    public MainScreen clickSearchTab() {
        searchTab.click();
        return this;
    }

    //Asserts
    @Step("Проверям, что находимся на главном экране приложения")
    public MainScreen checkMainScreenIsOpen() {
        mainButton.shouldBe(Condition.selected);
        return this;
    }


}
