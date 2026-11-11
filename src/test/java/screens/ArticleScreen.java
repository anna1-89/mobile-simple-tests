package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ArticleScreen {

    //Elements
    private final static SelenideElement saveButton = $(accessibilityId("Save"));
    private final static SelenideElement confirmDeleteFromSavedButtonButton = $(accessibilityId("Saved"));

    //Actions
    @Step("Нажимаем на кнопку \"Назад\"")
    public ArticleScreen clickBackButton() {
        back();
        return this;
    }

    @Step("Нажимаем на пункт \"Сохранить\"")
    public ArticleScreen clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Нажимаем на пункт \"Подтвердить удаление из Сохраненных\"")
    public ArticleScreen confirmDeleteFromSavedButton() {
        confirmDeleteFromSavedButtonButton.click();
        return this;
    }

    //Asserts
    @Step("Проверяем что статья содержит текст {text}")
    public ArticleScreen checkRightArticleIsOpen(String text) {
        SelenideElement articleTitle = $x("//*[contains(@text, '" + text + "')]");
        articleTitle.shouldHave(text(text));
        return this;
    }

}
