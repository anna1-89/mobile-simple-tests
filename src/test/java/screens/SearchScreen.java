package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {

    ConfirmWindow confirmWindow = new ConfirmWindow();

    //Elements
    private static final SelenideElement closeWidgetButton = $(accessibilityId("Close"));
    private static final SelenideElement searchField = $(accessibilityId("Search Wikipedia"));
    private static final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private static final ElementsCollection articlesList = $$(id("org.wikipedia.alpha:id/fragment_search_results"));
    private static final SelenideElement backScreenButton = $(accessibilityId("Navigate up"));
    private static final SelenideElement savedTab = $(accessibilityId("Saved"));

    //Actions
    @Step("Закрываем всплывающие экраны")
    public SearchScreen closeWidget() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (closeWidgetButton.has(Condition.interactable)) {
            closeWidgetButton.click();
        }
        return this;
    }

    @Step("Нажимаем на строку для ввода поискового запроса")
    public SearchScreen clickOnSearchField() {
        searchField.click();
        return this;
    }

    @Step("Вводим запрос на поиск статьи и нажимает Enter")
    public SearchScreen setSearchValue(String value) {
        searchInput.sendKeys(value);
        return this;
    }

    @Step("Открывем статью: {value}")
    public SearchScreen openArticle(String value) {
        SelenideElement article = $x("//android.widget.TextView[@text=\"" + value + "\"]");
        article.click();
        return this;
    }

    @Step("Нажимаем на кнопку \"Назад\" рядом со строкой поиска")
    public SearchScreen clickBackScreenButton() {
        backScreenButton.click();
        return this;
    }

    @Step("Нажимаем на вкладку \"Сохраненные\"")
    public SearchScreen clickSavedTab() {
        savedTab.click();
        return this;
    }

    //Asserts
    @Step("Проверяем что список найденных статей не пустой")
    public SearchScreen checkArticlesListIsNotEmpty() {
        articlesList.shouldHave(sizeGreaterThan(0));
        return this;
    }

}
