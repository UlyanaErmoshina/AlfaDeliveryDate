package ru.netology;

import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.DataGenerator.getDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


class AlfaDateTest {

    private UserInfo user;
    private DataGenerator alfaUser;

    @BeforeEach
    void setUpAll() {
        user = alfaUser.getUserInfo();

    }

    @Test
    void shouldSendRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue(user.getCity());
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(getDate(4));
        form.$("[data-test-id=name] input").setValue(user.getName());
        form.$("[data-test-id=phone] input").setValue(user.getPhone());
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=success-notification]").shouldHave(text("Встреча успешно запланирована на "+ getDate((4))));
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(getDate(5));
        form.$(".button").click();
        $(byText("Перепланировать")).waitUntil(visible, 15000);
        $("[data-test-id=replan-notification] button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=success-notification]").shouldHave(text("Встреча успешно запланирована на "+ getDate((5))));

    }
}

